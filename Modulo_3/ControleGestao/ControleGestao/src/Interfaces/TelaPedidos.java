package Interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import BancoDeDados.ConexaoBD;

public class TelaPedidos extends JPanel {
    private JTable tabelaPedidos;

    public TelaPedidos() {

        // Criação da tabela
        tabelaPedidos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        scrollPane.setBounds(10, 10, 780, 300);
        add(scrollPane);

        // Preenche a tabela com os dados dos pedidos e produtos
        preencherTabela();
    }

    private void preencherTabela() {
        try {
            Connection conexao = ConexaoBD.conectar();

            // Consulta SQL para obter informações de pedidos e produtos
           String sql = "SELECT pedidos.id AS PedidoID, data_pedido AS DataPedido, " +
                "itens_pedido.id AS ItemID, produtos.nome AS NomeProduto, " +
                "itens_pedido.quantidade AS Quantidade, " +  // Adicionando a tabela para resolver a ambiguidade
                "valor_unitario AS PrecoUnitario, subtotal " +
                "FROM pedidos " +
                "JOIN itens_pedido ON pedidos.id = itens_pedido.pedido_id " +
                "JOIN produtos ON itens_pedido.produto_id = produtos.id";


            try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                // Criação do modelo da tabela
                DefaultTableModel modeloTabela = new DefaultTableModel();
                tabelaPedidos.setModel(modeloTabela);

                // Adiciona as colunas ao modelo
                modeloTabela.addColumn("Pedido ID");
                modeloTabela.addColumn("Data do Pedido");
                modeloTabela.addColumn("Item ID");
                modeloTabela.addColumn("Nome do Produto");
                modeloTabela.addColumn("Quantidade");
                modeloTabela.addColumn("Preço Unitário");
                modeloTabela.addColumn("Subtotal");

                // Adiciona as linhas ao modelo
                while (rs.next()) {
                    Object[] linha = {
                            rs.getInt("PedidoID"),
                            rs.getDate("DataPedido"),
                            rs.getInt("ItemID"),
                            rs.getString("NomeProduto"),
                            rs.getInt("quantidade"),
                            rs.getDouble("PrecoUnitario"),
                            rs.getDouble("subtotal")
                    };
                    modeloTabela.addRow(linha);
                }
            }

            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela de pedidos.");
        }
    }
}
