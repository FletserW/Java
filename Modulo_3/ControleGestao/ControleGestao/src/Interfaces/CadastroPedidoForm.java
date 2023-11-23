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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class CadastroPedidoForm extends JFrame {
    private JTextField txtNumeroPedido, txtDataPedido, txtFornecedor, txtPrecoUnitario;
    private JTextArea txtAreaObservacoes;
    private JButton btnAdicionarProduto, btnFinalizarPedido;
    private JDateChooser dateChooser;
    private JComboBox<String> comboFornecedor, comboNome;
    private JFormattedTextField txtQuantidade;

    public CadastroPedidoForm() {
        // Configurações da janela =============================================
        setTitle("Formulário de Pedido");
        setSize(600, 400);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Componentes do formulário ===========================================
        JLabel lblNumeroPedido = new JLabel("Número do Pedido:");
        lblNumeroPedido.setBounds(10, 10, 150, 20);
        txtNumeroPedido = new JTextField();
        txtNumeroPedido.setBounds(160, 10, 150, 20);

        JLabel lblDataPedido = new JLabel("Data do Pedido:");
        lblDataPedido.setBounds(10, 40, 150, 20);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(160, 40, 150, 20);

        JLabel lblFornecedor = new JLabel("Fornecedor:");
        lblFornecedor.setBounds(10, 70, 150, 20);
        comboFornecedor = new JComboBox<>();
        comboFornecedor.setBounds(160, 70, 150, 20);
        preencherComboFornecedor();

        JLabel lblNomeProduto = new JLabel("Nome do Produto:");
        lblNomeProduto.setBounds(10, 100, 150, 20);
        comboNome = new JComboBox<>();
        comboNome.setBounds(160, 100, 150, 20);
        preencherComboNome();
        
        
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(10, 130, 150, 20);
        
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        
        txtQuantidade = new JFormattedTextField(formatter);
        txtQuantidade.setBounds(160, 130, 150, 20);

        JLabel lblPrecoUnitario = new JLabel("Preço Unitário:");
        lblPrecoUnitario.setBounds(10, 160, 150, 20);
        txtPrecoUnitario = new JTextField();
        txtPrecoUnitario.setBounds(160, 160, 150, 20);

        JLabel lblObservacoes = new JLabel("Observações:");
        lblObservacoes.setBounds(10, 190, 150, 20);
        txtAreaObservacoes = new JTextArea();
        txtAreaObservacoes.setBounds(160, 190, 400, 100);

        // Botões ==============================================================
        btnAdicionarProduto = new JButton("Adicionar Produto");
        btnAdicionarProduto.setBounds(10, 300, 150, 30);
        btnFinalizarPedido = new JButton("Finalizar Pedido");
        btnFinalizarPedido.setBounds(180, 300, 150, 30);

        // Adiciona os componentes ao painel ===================================
        panel.add(lblNumeroPedido);
        panel.add(txtNumeroPedido);
        panel.add(lblDataPedido);
        panel.add(dateChooser);
        panel.add(lblFornecedor);
        panel.add(comboFornecedor);
        panel.add(lblNomeProduto);
        panel.add(comboNome);
        panel.add(lblQuantidade);
        panel.add(txtQuantidade);
        panel.add(lblPrecoUnitario);
        panel.add(txtPrecoUnitario);
        panel.add(lblObservacoes);
        panel.add(txtAreaObservacoes);
        panel.add(btnAdicionarProduto);
        panel.add(btnFinalizarPedido);

        // Adiciona o painel à janela
        add(panel);

        // Define a ação do botão Adicionar Produto ============================
        btnAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        adicionarProdutoAoPedido();
    }
        });

        // Define a ação do botão Finalizar Pedido =============================
        btnFinalizarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para finalizar o pedido
                // Pode ser necessário adicionar lógica de validação e cálculos aqui
                JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
            }
        });
        
        
    }
    //Adicionar data ===========================================================
    private Date getDataSelecionada() {
        return dateChooser.getDate();
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
    
    //Preenche ComboBox dos Nome do prodito ====================================
    private void preencherComboNome() {
        try {
            Connection conexao = ConexaoBD.conectar();

            String sql = "SELECT nome FROM produtos";
            try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String nomeProduto = rs.getString("nome");
                    comboNome.addItem(nomeProduto);
                }
            }

            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao preencher fornecedores.");
        }
    }
    
    // Método para obter o ID do fornecedor pelo nome ==========================
    private int obterIdNome(Connection conexao, String nomeProduto) throws SQLException {
        String sql = "SELECT id FROM produtos WHERE nome = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, nomeProduto);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    throw new SQLException("Fornecedor não encontrado: " + nomeProduto);
                }
            }
        }
    }
    //Adicionar produtos ao pedido =============================================
    private void adicionarProdutoAoPedido() {
        Connection conexao = ConexaoBD.conectar();

        // Obtém os valores dos campos
        Date dataPedido = getDataSelecionada();
        String observacoes = txtAreaObservacoes.getText();

        // Insere os dados na tabela de pedidos
        String sqlPedido = "INSERT INTO pedidos (data_pedido, observacao) VALUES (?, ?)";
        try (PreparedStatement pstmtPedido = conexao.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
            pstmtPedido.setDate(1, new java.sql.Date(dataPedido.getTime()));
            pstmtPedido.setString(2, observacoes);

            pstmtPedido.executeUpdate();

            // Obtém o ID gerado para o pedido
            ResultSet generatedKeys = pstmtPedido.getGeneratedKeys();
            int idPedido = -1;
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Falha ao obter o ID gerado para o pedido.");
            }

            // Obtém os valores restantes dos campos
            String nomeFornecedor = (String) comboFornecedor.getSelectedItem();
            String nomeProduto = (String) comboNome.getSelectedItem();
            int quantidade = (int) txtQuantidade.getValue();
            double precoUnitario = Double.parseDouble(txtPrecoUnitario.getText());

            // Obtém os IDs necessários
            int idFornecedor = obterIdFornecedor(conexao, nomeFornecedor);
            int idProduto = obterIdNome(conexao, nomeProduto);

            // Insere os dados na tabela de itens do pedido
            String sqlItens = "INSERT INTO itens_pedido (pedido_id, produto_id, quantidade, valor_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmtItens = conexao.prepareStatement(sqlItens)) {
                pstmtItens.setInt(1, idPedido);
                pstmtItens.setInt(2, idProduto);
                pstmtItens.setInt(3, quantidade);
                pstmtItens.setDouble(4, precoUnitario);
                pstmtItens.setDouble(5, quantidade * precoUnitario);

                pstmtItens.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Produto adicionado ao pedido!");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto ao pedido.");
        } finally {
            ConexaoBD.desconectar(conexao);
        }
    }

}

