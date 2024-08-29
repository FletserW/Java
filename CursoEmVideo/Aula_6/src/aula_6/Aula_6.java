/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula_6;

/**
 *
 * @author reido
 */
public class Aula_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControleRemoto c = new ControleRemoto(0, false, false);
        c.ligar();
        c.maisVolume();
        c.maisVolume();
        c.play();
        c.abrirMenu();
        c.fecharMenu();
    }
    
}
