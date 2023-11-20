/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author reido
 */
import BancoDeDados.ConexaoBD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroFornecedorForm extends JFrame {
    private JTextField txtNome, txtContato, txtTelefone;

    public CadastroFornecedorForm() {
        // Configurações da janela =============================================
        setTitle("Cadastro de Fornecedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Definir a cor de fundo
        Color corDeFundo = new Color(0x6E8066); // Mesma cor de fundo do Menu
        panel.setBackground(corDeFundo);

        // Componentes do formulário ===========================================
        JLabel lblNome = new JLabel("Nome do Fornecedor:");
        lblNome.setBounds(10, 30, 150, 20);
        txtNome = new JTextField();
        txtNome.setBounds(160, 30, 200, 20);

        JLabel lblContato = new JLabel("Contato:");
        lblContato.setBounds(10, 60, 150, 20);
        txtContato = new JTextField();
        txtContato.setBounds(160, 60, 200, 20);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 90, 150, 20);
        txtTelefone = new JTextField();
        txtTelefone.setBounds(160, 90, 200, 20);

        // Botões ==============================================================
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(160, 120, 90, 30);
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(260, 120, 100, 30);

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
        panel.add(lblContato);
        panel.add(txtContato);
        panel.add(lblTelefone);
        panel.add(txtTelefone);
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
                String contato = txtContato.getText();
                String telefone = txtTelefone.getText();

                try {
                    // Conectar ao banco de dados
                    Connection conexao = ConexaoBD.conectar();

                    // Inserção de um novo fornecedor
                    String sql = "INSERT INTO fornecedores (nome, contato, telefone) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                        pstmt.setString(1, nome);
                        pstmt.setString(2, contato);
                        pstmt.setString(3, telefone);

                        int linhasAfetadas = pstmt.executeUpdate();
                        if (linhasAfetadas > 0) {
                            JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Falha ao salvar o fornecedor.");
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
}

