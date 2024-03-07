/*
 * Esta classe, PainelConsultar, representa um painel específico dentro da interface gráfica destinado à consulta de dados.
 * Ela possui botões para acessar funcionalidades relacionadas ao estoque, pedidos, fornecedores, e para voltar ao menu principal.
 * 
 * Principais componentes e funcionalidades:
 * 
 * - Botões para "Estoque (Em Breve)", "Pedidos", "Fornecedores" e "Voltar".
 * - Ao clicar nos botões "Pedidos" e "Fornecedores", os painéis TelaPedidos e TelaFornecedores são exibidos.
 * - O botão "Estoque (Em Breve)" ainda não possui uma funcionalidade implementada.
 * - Ao clicar no botão "Voltar", os botões do menu principal são mostrados novamente.
 * - A classe contém métodos para controlar a visibilidade dos botões, e também métodos privados para exibir os painéis correspondentes.
 */

package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PainelConsultar extends JPanel {
    private Menu menu;
    private TelaFornecedores telaFornecedores;
    private TelaPedidos telaPedidos;
    private JButton btnEstoque;
    private JButton btnPedidos;
    private JButton btnFornecedores;
    private JButton btnVoltar;

    public PainelConsultar(Menu menu) {
        setLayout(null);
        this.menu = menu;
        telaFornecedores = new TelaFornecedores(this); // Fornece a referência atual de PainelConsultar
        telaPedidos = new TelaPedidos(this);
       
        this.add(telaFornecedores);
        this.add(telaPedidos);

        Color corDeFundo = new Color(0x6E8066);
        setBackground(corDeFundo);

        Color corDoBotao = new Color(0x97A989);
        Font fonte = new Font("Arial", Font.BOLD, 16);

        // Botão "Estoque (Em Breve)"
        btnEstoque = new JButton("Estoque (Em Breve)");
        btnEstoque.setBounds(450, 100, 200, 60);
        btnEstoque.setBackground(corDoBotao);
        btnEstoque.setForeground(Color.WHITE);
        btnEstoque.setFont(fonte);
        add(btnEstoque);
        btnEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMensagemAlerta("Em Breve: Recurso de Estoque ainda não implementado!\n         Devido a limitações tecnicas e planejamento.");
            }
        });

        // Botão "Pedidos"
        btnPedidos = new JButton("Pedidos");
        btnPedidos.setBounds(450, 200, 200, 60);
        btnPedidos.setBackground(corDoBotao);
        btnPedidos.setForeground(Color.WHITE);
        btnPedidos.setFont(fonte);
        add(btnPedidos);
        btnPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 exibirTelaPedidos();
            }
        });

        // Botão "Fornecedores"
        btnFornecedores = new JButton("Fornecedores");
        btnFornecedores.setBounds(450, 300, 200, 60);
        btnFornecedores.setBackground(corDoBotao);
        btnFornecedores.setForeground(Color.WHITE);
        btnFornecedores.setFont(fonte);
        add(btnFornecedores);
        btnFornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirTelaFornecedores();
            }
        });

        // Botão "Voltar"
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(450, 400, 200, 60);
        btnVoltar.setBackground(corDoBotao);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(fonte);
        add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.mostrarBotoes(true);
                setVisible(false);
            }
        });

        setBounds(10, 10, 799, 500);
        setVisible(false);
    }

    // Método para mostrar ou ocultar os botões
    public void mostrarBotoesC(boolean mostrar) {
        btnEstoque.setVisible(mostrar);
        btnPedidos.setVisible(mostrar);
        btnFornecedores.setVisible(mostrar);
        btnVoltar.setVisible(mostrar);
    }

    // Método privado para exibir o painel de Fornecedores
    private void exibirTelaFornecedores() {
        mostrarBotoesC(false);
        telaFornecedores.setVisible(true);
    }
    
    // Método privado para exibir o painel de Pedidos
    private void exibirTelaPedidos() {
        mostrarBotoesC(false);
        telaPedidos.setVisible(true);
    }   
    
    private void exibirMensagemAlerta(String mensagem) {
    JOptionPane.showMessageDialog(this, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
}
}
