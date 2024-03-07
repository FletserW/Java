/*
 * Este código representa a implementação da classe Menu, que é uma extensão de JPanel e funciona como o menu principal da interface gráfica.
 * Os principais componentes e funcionalidades são explicados a seguir:
 * 
 * - A classe possui três botões: "Registrar", "Consultar" e "Sair".
 * - Os botões são estilizados com cores e fontes específicas.
 * - Um ícone é exibido à esquerda do menu.
 * - A classe inclui dois painéis adicionais (PainelRegistrar e PainelConsultar), que são alternadamente exibidos ao clicar nos botões correspondentes.
 * - Os botões possuem ActionListener para lidar com as ações do usuário.
 * - O botão "Sair" fecha o aplicativo quando clicado.
 * - Métodos adicionais são fornecidos para controlar a visibilidade dos botões e alternar entre os painéis.
 */
package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JPanel painelRegistrar;
    private JPanel painelConsultar;
    private JButton btnRegistrar;
    private JButton btnConsultar;
    private JButton btnSair;

    public Menu() {
        setLayout(null);

        // Define a cor de fundo
        Color corDeFundo = new Color(0x6E8066);
        setBackground(corDeFundo);

        // Criar uma imagem à esquerda =========================================
        ImageIcon imagem = new ImageIcon("build\\classes\\img\\logo.png");
        JLabel imagemLabel = new JLabel(imagem);
        imagemLabel.setBounds(10, 10, imagem.getIconWidth(), imagem.getIconHeight());
        add(imagemLabel);
        
        // Inicializar os painéis de Registrar e Consultar
        painelRegistrar = new PainelRegistrar(this);
        this.add(painelRegistrar);
        painelConsultar = new PainelConsultar(this);
        this.add(painelConsultar);
        
        // Botão Registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(450, 100, 200, 60);
        Color corDoBotao = new Color(0x97A989);
        btnRegistrar.setBackground(corDoBotao);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnRegistrar);
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPainelRegistrar();
            }
        });

        // Botão Consultar =====================================================
        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(450, 200, 200, 60);
        btnConsultar.setBackground(corDoBotao);
        btnConsultar.setForeground(Color.WHITE);
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnConsultar);
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPainelConsultar();
            }
        });

        // Botão Sair ==========================================================
        btnSair = new JButton("Sair");
        btnSair.setBounds(450, 300, 200, 60);
        btnSair.setBackground(corDoBotao);
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(new Font("Arial", Font.BOLD, 16));
        add(btnSair);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fechar o aplicativo
            }
        });
    }
    
    // Métodos ==============================================================
    
    // Fazer os botões aparecer
    public void mostrarBotoes(boolean mostrar) {
        btnRegistrar.setVisible(mostrar);
        btnConsultar.setVisible(mostrar);
        btnSair.setVisible(mostrar);
    }

    // Exibir o painel de Consultar
    private void exibirPainelConsultar() {
        mostrarBotoes(false);
        painelConsultar.setVisible(true);
        painelRegistrar.setVisible(false);
    }
    
    // Exibir o painel de Registrar
    private void exibirPainelRegistrar() {
        mostrarBotoes(false);
        painelRegistrar.setVisible(true);
        painelConsultar.setVisible(false);
    }
}
