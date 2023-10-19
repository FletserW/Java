/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.swing.JFrame;

/**
 *
 * @author solon
 */
public class Menu extends JFrame{
    private Semaforo me;
    public Menu(){
        me = new Semaforo();
        this.setTitle("Jogos");
        this.setSize(200,100);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}    