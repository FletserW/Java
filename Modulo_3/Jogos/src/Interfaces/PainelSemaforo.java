package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelSemaforo extends JPanel {
    private JButton vermelhoB;
    private JButton amareloB;
    private JButton verdeB;
    private JLabel mensagemL;

    public PainelSemaforo() {
        setLayout(null);

        vermelhoB = new JButton();
        amareloB = new JButton();
        verdeB = new JButton();

        vermelhoB.setBackground(Color.RED);
        amareloB.setBackground(Color.YELLOW);
        verdeB.setBackground(Color.GREEN);

        vermelhoB.setBounds(20, 50, 40, 40);
        amareloB.setBounds(20, 120, 60, 60);
        verdeB.setBounds(20, 190, 60, 60);

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

        mensagemL = new JLabel("");
        mensagemL.setForeground(Color.BLACK);
        mensagemL.setFont(new Font("Arial", Font.BOLD, 16));
        mensagemL.setBounds(100, 50, 150, 60);

        add(vermelhoB);
        add(amareloB);
        add(verdeB);
        add(mensagemL);
        setVisible(false);
    }

    public void tornarVisivel() {
        mensagemL.setText("");
        setVisible(true);
    }
}
