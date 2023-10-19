package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelSemaforo extends JPanel {
    private JLabel tituloL;
    private JButton vermelhoB;
    private JButton amareloB;
    private JButton verdeB;
    private JLabel mensagemL;

    public PainelSemaforo() {
        
        tituloL = new JLabel("Escolha uma cor");
        vermelhoB = new JButton();
        amareloB = new JButton();
        verdeB = new JButton();

        vermelhoB.setBackground(Color.RED);
        amareloB.setBackground(Color.YELLOW);
        verdeB.setBackground(Color.GREEN);

        tituloL.setBounds(45, 10, 140, 20);
        vermelhoB.setBounds(45, 50, 40, 40);
        amareloB.setBounds(45, 100, 40, 40);
        verdeB.setBounds(45, 150, 40, 40);

        vermelhoB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mensagemL.setText("Pare");
            }
        });

        amareloB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mensagemL.setText("Atenção");
            }
        });

        verdeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mensagemL.setText("Siga");
            }
        });
        
        tituloL.setForeground(Color.BLACK);
        tituloL.setFont(new Font("Arial", Font.BOLD, 16));

        mensagemL = new JLabel("");
        mensagemL.setForeground(Color.BLACK);
        mensagemL.setFont(new Font("Arial", Font.BOLD, 16));
        mensagemL.setBounds(100, 85, 150, 60);

        add(tituloL);
        add(vermelhoB);
        add(amareloB);
        add(verdeB);
        add(mensagemL);
        setBackground(Color.WHITE);
        setLayout(null);
        setVisible(false);
    }

    public void tornarVisivel() {
        mensagemL.setText("");
        setVisible(true);
    }
}
