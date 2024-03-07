/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/*
 * Este código representa a interface gráfica de um formulário para cadastrar produtos em um sistema.
 * Os principais componentes e funcionalidades são explicados a seguir:
 * 
 * - O formulário permite ao usuário inserir informações como nome do produto, quantidade por embalagem, valor e fornecedor.
 * - A lista de fornecedores é preenchida dinamicamente a partir dos registros existentes no banco de dados.
 * - Ao clicar no botão "Salvar", os dados inseridos são coletados e, em seguida, são utilizados para inserir um novo produto no banco de dados.
 * - O valor do fornecedor é convertido para o correspondente ID de fornecedor antes de ser utilizado no comando SQL.
 * - Em caso de sucesso na inserção, uma mensagem de sucesso é exibida; caso contrário, uma mensagem de falha é exibida.
 * - O botão "Cancelar" fecha o formulário sem realizar qualquer operação.
 * - As interações com o banco de dados são tratadas por meio da classe ConexaoBD, que lida com a conexão, execução de comandos SQL, e desconexão.
*/

import BancoDeDados.ConexaoBD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CadastroProdutoForm extends JFrame {
    private Connection conexao;
    private JTextField txtNome, txtQuantidade, txtValor;
    private JComboBox<String> comboFornecedor;

    public CadastroProdutoForm() {
        this.conexao = conexao;
        // Configurações da janela
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza na tela

        // Painel principal ====================================================
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Definir a cor de fundo
        Color corDeFundo = new Color(0x6E8066); // Mesma cor de fundo do Menu
        panel.setBackground(corDeFundo);

        // Componentes do formulário
        JLabel lblNome = new JLabel("Nome do Produto:");
        lblNome.setBounds(10, 30, 120, 20);
        txtNome = new JTextField();
        txtNome.setBounds(140, 30, 200, 20);

        JLabel lblQuantidade = new JLabel("Qtd Embalagem:");
        lblQuantidade.setBounds(10, 60, 120, 20);
        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(140, 60, 200, 20);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(10, 90, 120, 20);
        txtValor = new JTextField();
        txtValor.setBounds(140, 90, 200, 20);

        JLabel lblFornecedor = new JLabel("Fornecedor:");
        lblFornecedor.setBounds(10, 120, 120, 20);
        comboFornecedor = new JComboBox<>();
        comboFornecedor.setBounds(140, 120, 200, 20);
        preencherComboFornecedor();
        

        // Botões ==============================================================
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(140, 150, 90, 30);
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(240, 150, 100, 30);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);
        btnSalvar.setBackground(corDoBotao);
        btnCancelar.setBackground(corDoBotao);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);
        btnSalvar.setForeground(Color.WHITE);
        btnCancelar.setForeground(Color.WHITE);
        btnSalvar.setFont(fonte);
        btnCancelar.setFont(fonte);

        // Adiciona os componentes ao painel ===================================
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblQuantidade);
        panel.add(txtQuantidade);
        panel.add(lblValor);
        panel.add(txtValor);
        panel.add(lblFornecedor);
        panel.add(comboFornecedor);
        panel.add(btnSalvar);
        panel.add(btnCancelar);

        // Adiciona o painel à janela
        add(panel);

        // Define a ação do botão Salvar =======================================
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pegar os valores dos campos do formulário
                String nome = txtNome.getText();
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                double valor = Double.parseDouble(txtValor.getText());
                String nomeFornecedor = (String) comboFornecedor.getSelectedItem();

                try {
                    // Conectar ao banco de dados
                    Connection conexao = ConexaoBD.conectar();

                    // Obter o ID do fornecedor selecionado
                    int idFornecedor = obterIdFornecedor(conexao, nomeFornecedor);

                    // Inserção de um novo produto
                    String sql = "INSERT INTO produtos (nome, quantidade, valor, fornecedor_id) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                        pstmt.setString(1, nome);
                        pstmt.setInt(2, quantidade);
                        pstmt.setDouble(3, valor);
                        pstmt.setInt(4, idFornecedor);

                        int linhasAfetadas = pstmt.executeUpdate();
                        if (linhasAfetadas > 0) {
                            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao salvar o produto.");
                        }
                    }

                    // Fechar a conexão
                    conexao.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.");
                }
            }
        });


        // Define a ação do botão Cancelar =====================================
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha o formulário
                dispose();
            }
        });
    }
    
    //Preenche ComboBox dos fornecedores =======================================
    
    private void preencherComboFornecedor() {
        try {
            Connection conexao = ConexaoBD.conectar();

            String sql = "SELECT nome FROM fornecedores";
            try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String nomeFornecedor = rs.getString("nome");
                    comboFornecedor.addItem(nomeFornecedor);
                }
            }

            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao preencher fornecedores.");
        }
    }
    
    // Método para obter o ID do fornecedor pelo nome ==========================
    private int obterIdFornecedor(Connection conexao, String nomeFornecedor) throws SQLException {
        String sql = "SELECT id FROM fornecedores WHERE nome = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, nomeFornecedor);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    throw new SQLException("Fornecedor não encontrado: " + nomeFornecedor);
                }
            }
        }
    }

}
