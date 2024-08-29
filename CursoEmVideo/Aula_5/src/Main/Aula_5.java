/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

/**
 *
 * @author reido
 */
public class Aula_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco(0, true);
        p1.abrirConta(1111, "cc", "Jubileu");
        //p1.depositar(100);
        p1.sacar(50);
        p1.fecharConta();
        
        ContaBanco p2 = new ContaBanco(0, true);
        p2.abrirConta(2222, "cp", "Creuza");
        p2.depositar(500);
        p2.sacar(1000);
       
        p1.estadoAtual();
        p2.estadoAtual();
    }
    
}
