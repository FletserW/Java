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

    public TelaFornecedores(PainelConsultar painelConsultar) {
        this.painelConsultar = painelConsultar;

        // Define a cor de fundo
        Color corDeFundo = new Color(0x6E8066);
        setBackground(corDeFundo);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Contato");
        tableModel.addColumn("Telefone");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 500, 300);
        add(scrollPane);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(520, 10, 70, 30);
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

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(520, 50, 70, 30);
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

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(550, 50, 70, 30);
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

    private void ocultarTelaFornecedores() {
        setVisible(false);
    }

    private void carregarFornecedores() {
        Connection conexao = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoBD.conectar();
            stmt = conexao.createStatement();
            rs = stmt.executeQuery("SELECT nome, contato, telefone FROM fornecedores");

            // Limpa os dados da tabela antes de carregar novamente
            tableModel.setRowCount(0);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String contato = rs.getString("contato");
                String telefone = rs.getString("telefone");

                tableModel.addRow(new Object[]{nome, contato, telefone});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }

    private void abrirJanelaEdicao(String nomeFornecedor) {
    // Obter os detalhes do fornecedor do banco de dados para exibição ou edição
    String contato = ""; // Aqui, você pode obter os detalhes do fornecedor do banco de dados
    String telefone = ""; // Substitua com a lógica real para obter do banco de dados

    // Criar uma janela de edição
    JFrame janelaEdicao = new JFrame("Editar Fornecedor");
    janelaEdicao.setLayout(null); // Usando layout nulo para configurar manualmente os bounds

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

    JButton btnSalvar = new JButton("Salvar");
    btnSalvar.setBounds(10, 100, 80, 25);
    btnSalvar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Salvar as alterações no banco de dados
            salvarEdicao(nomeFornecedor, txtNome.getText(), txtContato.getText(), txtTelefone.getText());

            // Recarregar os fornecedores após a edição
            carregarFornecedores();

            // Fechar a janela de edição
            janelaEdicao.dispose();
        }
    });
    janelaEdicao.add(btnSalvar);

    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(100, 100, 80, 25);
    btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Fechar a janela de edição sem salvar alterações
            janelaEdicao.dispose();
        }
    });
    janelaEdicao.add(btnCancelar);

    janelaEdicao.setSize(320, 170);
    janelaEdicao.setLocationRelativeTo(null);
    janelaEdicao.setVisible(true);
}

    private void salvarEdicao(String nomeFornecedor, String novoNome, String novoContato, String novoTelefone) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConexaoBD.conectar();
            String sql = "UPDATE fornecedores SET nome=?, contato=?, telefone=? WHERE nome=?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, novoNome);
            stmt.setString(2, novoContato);
            stmt.setString(3, novoTelefone);
            stmt.setString(4, nomeFornecedor);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }

    private void excluirFornecedor(String nomeFornecedor) {
        Connection conexao = null;
        PreparedStatement stmt = null;

        try {
            conexao = ConexaoBD.conectar();
            String sql = "DELETE FROM fornecedores WHERE nome = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeFornecedor);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }
}
