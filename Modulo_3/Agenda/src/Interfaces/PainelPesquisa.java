/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import java.awt.*;

public class PainelPesquisa extends JPanel {
    private JTextField barraPesquisa;

    public PainelPesquisa() {
        setLayout(new FlowLayout());

        barraPesquisa = new JTextField(20);

        add(new JLabel("Pesquisar:"));
        add(barraPesquisa);
    }
}
