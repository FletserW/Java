/*
 * Esta classe, PainelRegistrar, representa um painel específico dentro da interface gráfica destinado ao registro de dados.
 * Ela contém botões para acessar funcionalidades relacionadas a produtos, pedidos, fornecedores e para voltar ao menu principal.
 * 
 * Principais componentes e funcionalidades:
 * 
 * - Botões para "Produtos", "Pedidos", "Fornecedores" e "Voltar".
 * - Ao clicar nos botões "Produtos", "Pedidos" e "Fornecedores", os formulários de cadastro correspondentes são exibidos.
 * - O botão "Voltar" permite retornar ao menu principal.
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
        setLayout(null);
        this.menu = menu;

        // Definir a cor de fundo
        Color corDeFundo = new Color(0x6E8066); // Mesma cor de fundo do Menu
        setBackground(corDeFundo);

        // Definir a cor dos botões
        Color corDoBotao = new Color(0x97A989);

        // Fonte para os botões
        Font fonte = new Font("Arial", Font.BOLD, 16);

        // Botão "Produtos"
        JButton btnProdutos = new JButton("Produtos");
        btnProdutos.setBounds(450, 100, 200, 60);
        btnProdutos.setBackground(corDoBotao);
        btnProdutos.setForeground(Color.WHITE);
        btnProdutos.setFont(fonte);
        add(btnProdutos);
        btnProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria e exibe o formulário de cadastro de produto
                CadastroProdutoForm cadastroProdutoForm = new CadastroProdutoForm();
                cadastroProdutoForm.setVisible(true);
            }
        });

        // Botão "Pedidos"
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

        // Botão "Fornecedores"
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

        // Botão "Voltar"
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
