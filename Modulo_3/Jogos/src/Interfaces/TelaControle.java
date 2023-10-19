package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaControle extends JFrame {
    private PainelSemaforo painelSemaforo;

    public TelaControle() {
        setTitle("Jogo Semáforo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel menuLabel = new JLabel("Menu");
        JButton jogarButton = new JButton("Entrar");
        JButton sairButton = new JButton("Sair");

        menuLabel.setBounds(80, 5, 100, 30);
        jogarButton.setBounds(50, 50, 100, 50);
        sairButton.setBounds(50, 120, 100, 50);

        painelSemaforo = new PainelSemaforo();
        painelSemaforo.setBounds(200, 50, 150, 100); // Posicione o PainelSemaforo ao lado dos botões.

        jogarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                painelSemaforo.tornarVisivel();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(menuLabel);
        add(jogarButton);
        add(sairButton);
        add(painelSemaforo);

        setVisible(true);
    }

    public void criarTela() {
        setVisible(true);
    }
}
