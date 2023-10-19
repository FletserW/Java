/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author solon
 */
public class Semaforo extends JFrame{
    private JLabel titulo;
    private JButton bentrar;
    private JButton bsair;
    
    public Semaforo(){
        titulo = new JLabel("Bem Vindo");
        bentrar = new JButton("Entrar");
        bsair = new JButton("Sair");

        titulo.setBounds(100,50,100,20);
        bentrar.setBounds(90, 100, 75, 50);
        bsair.setBounds(90, 180, 75, 50);
        
        //titulo.setFont("Arial");
        
        this.add(titulo);
        this.add(bentrar);
        this.add(bsair);
        
        //bentrar.addActionListener(this);
        bentrar.addActionListener((ActionListener) this);
        bsair.addActionListener((ActionListener) this);
        
        this.setBackground(Color.yellow);
        this.setLayout(null);
        this.setBounds(500,300,280,400);
        this.setVisible(true);   
    }
}

