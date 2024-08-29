/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

/**
 *
 * @author reido
 */
public class Aula_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Caneta c1 = new Caneta("bic", "azul", 1.5f, 60, true);
        c1.status();
        c1.setModelo("Bic Cristal");
        c1.setCor("Vermelha");
        c1.setCarga(80);
        
        c1.status();
        c1.destampar();
        
        c1.rabiscar();
                
        
    }
    
}
