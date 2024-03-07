/*
 * A classe TelaPedidos representa um painel na interface gráfica destinado à exibição de dados relacionados a pedidos.
 * Este painel inclui uma tabela que exibe os pedidos cadastrados, contendo informações sobre os itens do pedido, como o nome do produto, quantidade, preço unitário e subtotal.
 *
 * Principais componentes e funcionalidades:
 *
 * - JTable tabelaPedidos: Tabela para exibição dos dados dos pedidos.
 * - JButton btnVoltar: Permite retornar ao painel anterior.
 * - Método preencherTabela: Realiza uma consulta ao banco de dados para obter informações sobre pedidos e produtos e preenche a tabela com esses dados.
 * - Método ocultarTelaPedidos: Oculta a tela de pedidos.
 *
 * Observações:
 *
 * - Os dados dos pedidos são carregados na tabela a partir do banco de dados, incluindo informações sobre os itens do pedido.
 * - A tabela exibe informações como Pedido ID, Data do Pedido, Item ID, Nome do Produto, Quantidade, Preço Unitário e Subtotal.
 * - A ação do botão "Voltar" permite retornar ao painel anterior.
 */

package Interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import BancoDeDados.ConexaoBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPedidos extends JPanel {
    private JTable tabelaPedidos;
    private final PainelConsultar painelConsultar;

    public TelaPedidos(PainelConsultar painelConsultar) {
        this.painelConsultar = painelConsultar;
        
        // Define a cor de fundo
        Color corDeFundo = new Color(0x6E8066);
        setBackground(corDeFundo);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);

        // Criação da tabela
        tabelaPedidos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        scrollPane.setBounds(10, 10, 780, 300);
        add(scrollPane);

        // Preenche a tabela com os dados dos pedidos e produtos
        preencherTabela();  
        
        // Botão "Voltar"
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
                ocultarTelaPedidos();
            }
        });
    }

    // Oculta a tela de pedidos
    private void ocultarTelaPedidos() {
        setVisible(false);
    }

    // Preenche a tabela com os dados dos pedidos e produtos
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
    
        setBounds(300, 10, 500, 500);

        setVisible(false);
    }
}
