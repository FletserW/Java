/*
 * A classe TelaFornecedores representa um painel na interface gráfica destinado à exibição e manipulação de dados relacionados a fornecedores.
 * Este painel inclui uma tabela que exibe os fornecedores cadastrados, botões para editar, excluir e voltar ao painel anterior.
 *
 * Principais componentes e funcionalidades:
 *
 * - JTable: Uma tabela para exibir os fornecedores, com colunas para Nome, Contato e Telefone.
 * - JButton btnEditar: Permite editar as informações do fornecedor selecionado.
 * - JButton btnExcluir: Permite excluir o fornecedor selecionado.
 * - JButton btnVoltar: Permite retornar ao painel anterior.
 * - Métodos carregarFornecedores, abrirJanelaEdicao, salvarEdicao e excluirFornecedor para manipulação de dados e interação com o banco de dados.
 *
 * Observações:
 *
 * - Os dados dos fornecedores são carregados na tabela a partir do banco de dados.
 * - A edição de fornecedores é realizada em uma janela separada, onde é possível modificar o nome, contato e telefone.
 * - As ações de edição e exclusão refletem diretamente no banco de dados.
 */

package Interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BancoDeDados.ConexaoBD;

public class TelaFornecedores extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;
    private final PainelConsultar painelConsultar;
    private JTextField txtPesquisa; 

    public TelaFornecedores(PainelConsultar painelConsultar) {
        this.painelConsultar = painelConsultar;
        setLayout(null);

        // Define a cor de fundo
        Color corDeFundo = new Color(0x6E8066);
        setBackground(corDeFundo);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);
        
        // Barra de Pesquisa
        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(10, 10, 150, 25);
        add(txtPesquisa);

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(170, 10, 150, 25);
        btnPesquisar.setBackground(corDoBotao);
        btnPesquisar.setForeground(Color.WHITE);
        btnPesquisar.setFont(fonte);
        add(btnPesquisar);
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarFornecedor(txtPesquisa.getText());
            }
        });

        // Configuração da tabela e modelo
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Contato");
        tableModel.addColumn("Telefone");
        tableModel.addColumn("Email");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 500, 300);
        add(scrollPane);

        // Botão "Editar"
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(100, 380, 100, 30);
        btnEditar.setBackground(corDoBotao);
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFont(fonte);
        add(btnEditar);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nomeFornecedor = (String) table.getValueAt(selectedRow, 0);
                    abrirJanelaEdicao(nomeFornecedor);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um fornecedor para editar.");
                }
            }
        });

        // Botão "Excluir"
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(210, 380, 100, 30);
        btnExcluir.setBackground(corDoBotao);
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.setFont(fonte);
        add(btnExcluir);
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nomeFornecedor = (String) table.getValueAt(selectedRow, 0);
                    excluirFornecedor(nomeFornecedor);
                    carregarFornecedores();  // Recarrega a tabela após a exclusão
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um fornecedor para excluir.");
                }
            }
        });

        // Botão "Voltar"
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(320, 380, 100, 30);
        btnVoltar.setBackground(corDoBotao);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(fonte);
        add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelConsultar.mostrarBotoesC(true);
                ocultarTelaFornecedores();
            }
        });

        setBounds(300, 10, 500, 500);

        setVisible(false);

        carregarFornecedores();
    }

    // Oculta a tela de fornecedores
    private void ocultarTelaFornecedores() {
        setVisible(false);
    }

    // Carrega os fornecedores do banco de dados para a tabela
    private void carregarFornecedores() {
        Connection conexao = null;
        Statement stmt = null;
        ResultSet rs = null;

    try {
        conexao = ConexaoBD.conectar();
        stmt = conexao.createStatement();
        rs = stmt.executeQuery("SELECT nome, contato, telefone, email FROM fornecedores");

        // Limpa os dados da tabela antes de carregar novamente
        tableModel.setRowCount(0);

        while (rs.next()) {
            String nome = rs.getString("nome");
            String contato = rs.getString("contato");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");

            tableModel.addRow(new Object[]{nome, contato, telefone, email});
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConexaoBD.desconectar(conexao);
    }
}

    // Abre uma janela para edição do fornecedor
    private void abrirJanelaEdicao(String nomeFornecedor) {
    // Obter os detalhes do fornecedor do banco de dados para exibição ou edição
    String contato = ""; 
    String telefone = ""; 
    String email = "";

    // Obter informações reais do fornecedor do banco de dados
    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conexao = ConexaoBD.conectar();
        String sql = "SELECT contato, telefone, email FROM fornecedores WHERE nome=?";
        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nomeFornecedor);
        rs = stmt.executeQuery();

        // Se o fornecedor existir, obter as informações
        if (rs.next()) {
            contato = rs.getString("contato");
            telefone = rs.getString("telefone");
            email = rs.getString("email");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        ConexaoBD.desconectar(conexao);
    }

    // Criar uma janela de edição
        JFrame janelaEdicao = new JFrame("Editar Fornecedor");
        janelaEdicao.setLayout(null); // Usando layout nulo para configurar manualmente os bounds

        // Obtém o painel de conteúdo da janela
        Container contentPane = janelaEdicao.getContentPane();

        // Define a cor de fundo para o painel de conteúdo
        Color corDeFundo = new Color(0x6E8066);
        contentPane.setBackground(corDeFundo);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);


        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 25);
        janelaEdicao.add(lblNome);

        JTextField txtNome = new JTextField(nomeFornecedor);
        txtNome.setBounds(100, 10, 200, 25);
        janelaEdicao.add(txtNome);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setBounds(10, 40, 80, 25);
        janelaEdicao.add(lblContato);

        JTextField txtContato = new JTextField(contato);
        txtContato.setBounds(100, 40, 200, 25);
        janelaEdicao.add(txtContato);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 70, 80, 25);
        janelaEdicao.add(lblTelefone);

        JTextField txtTelefone = new JTextField(telefone);
        txtTelefone.setBounds(100, 70, 200, 25);
        janelaEdicao.add(txtTelefone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 100, 80, 25);
        janelaEdicao.add(lblEmail);

        JTextField txtEmail = new JTextField(email);
        txtEmail.setBounds(100, 100, 200, 25);
        janelaEdicao.add(txtEmail);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 140, 120, 25);
        btnSalvar.setBackground(corDoBotao);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFont(fonte);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Salvar as alterações no banco de dados
                salvarEdicao(nomeFornecedor, txtNome.getText(), txtContato.getText(), txtTelefone.getText(), txtEmail.getText());

                // Recarregar os fornecedores após a edição
                carregarFornecedores();

                // Fechar a janela de edição
                janelaEdicao.dispose();
            }
        });
        janelaEdicao.add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(140, 140, 120, 25);
        btnCancelar.setBackground(corDoBotao);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(fonte);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a janela de edição sem salvar alterações
                janelaEdicao.dispose();
            }
        });
        janelaEdicao.add(btnCancelar);

        janelaEdicao.setSize(320, 250);
        janelaEdicao.setLocationRelativeTo(null);
        janelaEdicao.setVisible(true);
    }


    // Salva as alterações do fornecedor no banco de dados
    private void salvarEdicao(String nomeFornecedor, String novoNome, String novoContato, String novoTelefone, String novoEmail) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConexaoBD.conectar();
            String sql = "UPDATE fornecedores SET nome=?, contato=?, telefone=?, email=? WHERE nome=?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoNome);
            stmt.setString(2, novoContato);
            stmt.setString(3, novoTelefone);
            stmt.setString(4, novoEmail); 
            stmt.setString(5, nomeFornecedor);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }
    // Exclui o fornecedor do banco de dados
    private void excluirFornecedor(String nomeFornecedor) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConexaoBD.conectar();
            String sql = "DELETE FROM fornecedores WHERE nome = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeFornecedor);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir fornecedor. Verifique se o fornecedor está selecionado corretamente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor. Detalhes: " + ex.getMessage());
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }

    // Adicionado método para pesquisar fornecedores============================
    private void pesquisarFornecedor(String termoPesquisa) {
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoBD.conectar();
            String sql = "SELECT nome, contato, telefone, email FROM fornecedores WHERE nome LIKE ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + termoPesquisa + "%");
            rs = stmt.executeQuery();

            // Limpa os dados da tabela antes de carregar novamente
            tableModel.setRowCount(0);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String contato = rs.getString("contato");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");

                tableModel.addRow(new Object[]{nome, contato, telefone, email});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }
        
}
