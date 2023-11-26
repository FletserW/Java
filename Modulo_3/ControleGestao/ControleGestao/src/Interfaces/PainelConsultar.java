package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainelConsultar extends JPanel {
    private Menu menu;
    private TelaFornecedores telaFornecedores;
    private JButton btnEstoque;
    private JButton btnPedidos;
    private JButton btnFornecedores;
    private JButton btnVoltar;

    public PainelConsultar(Menu menu) {
        setLayout(null);
        this.menu = menu;
        telaFornecedores = new TelaFornecedores(this);  // Fornece a referência atual de PainelConsultar

        this.add(telaFornecedores);

        Color corDeFundo = new Color(0x6E8066);
        setBackground(corDeFundo);

        Color corDoBotao = new Color(0x97A989);
        Font fonte = new Font("Arial", Font.BOLD, 16);

        btnEstoque = new JButton("Estoque");
        btnEstoque.setBounds(450, 100, 200, 60);
        btnEstoque.setBackground(corDoBotao);
        btnEstoque.setForeground(Color.WHITE);
        btnEstoque.setFont(fonte);
        add(btnEstoque);
        btnEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica necessária para o botão Estoque
            }
        });

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

    public void mostrarBotoesC(boolean mostrar) {
        btnEstoque.setVisible(mostrar);
        btnPedidos.setVisible(mostrar);
        btnFornecedores.setVisible(mostrar);
        btnVoltar.setVisible(mostrar);
    }

    private void exibirTelaFornecedores() {
        mostrarBotoesC(false);
        telaFornecedores.setVisible(true);
    }
    
    private void exibirTelaPedidos() {
        // Criar uma nova instância de TelaPedidos e exibi-la
        TelaPedidos telaPedidos = new TelaPedidos();
        JFrame frame = new JFrame("Lista de Pedidos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(telaPedidos);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }   
}
