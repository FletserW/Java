/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelRegistrar extends JPanel {
    private Menu menu;
    
    public PainelRegistrar(Menu menu) {
        //setSize(1200, 1200);
        setLayout(null);
        
        this.menu = menu;

        // Definir a cor de fundo
        Color corDeFundo = new Color(0x6E8066); // Mesma cor de fundo do Menu
        setBackground(corDeFundo);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);

        // Botão Estoque==========================================================
        JButton btnEstoque = new JButton("Produtos");
        btnEstoque.setBounds(450, 100, 200, 60);
        btnEstoque.setBackground(corDoBotao);
        btnEstoque.setForeground(Color.WHITE);
        btnEstoque.setFont(fonte);
        add(btnEstoque);
        btnEstoque.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cria e exibe o formulário de cadastro de produto
        CadastroProdutoForm cadastroProdutoForm = new CadastroProdutoForm();
        cadastroProdutoForm.setVisible(true);
    }
});


        // Botão Pedidos======================================================
        JButton btnPedidos = new JButton("Pedidos");
        btnPedidos.setBounds(450, 200, 200, 60);
        btnPedidos.setBackground(corDoBotao);
        btnPedidos.setForeground(Color.WHITE);
        btnPedidos.setFont(fonte);
        add(btnPedidos);
        btnPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroPedidoForm formularioPedido = new CadastroPedidoForm();
                formularioPedido.setVisible(true);
            }
        });

        // Botão Fornecedores=================================================
        JButton btnFornecedores = new JButton("Fornecedores");
        btnFornecedores.setBounds(450, 300, 200, 60);
        btnFornecedores.setBackground(corDoBotao);
        btnFornecedores.setForeground(Color.WHITE);
        btnFornecedores.setFont(fonte);
        add(btnFornecedores);
        btnFornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroFornecedorForm cadastroFornecedorForm = new CadastroFornecedorForm();
                cadastroFornecedorForm.setVisible(true);
            }
        });

        // Botão Voltar======================================================
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(450, 400, 200, 60);
        btnVoltar.setBackground(corDoBotao);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(fonte);
        add(btnVoltar);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.mostrarBotoes(true); // Torna os botões do Menu visíveis
                setVisible(false); // Oculta o PainelConsultar
            }
        });
        
        setBounds(10, 10, 700, 500);
        setVisible(false); // Inicialmente, o painel Consultar está oculto
    }


 
}

