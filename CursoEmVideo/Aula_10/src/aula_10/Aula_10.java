/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula_10;

public class Aula_10 {

    public static void main(String[] args) {
        Visitante p1 = new Visitante();
        Aluno p2 = new Aluno();
        Professor p3 = new Professor();
        Funcionario p4 = new Funcionario();
        
        p1.setNome("Pedro");
        p2.setNome("Maria");
        p3.setNome("Cladio");
        p4.setNome("Fabiana");
        
        p1.setSexo("H");
        p2.setSexo("M");
        p3.setSexo("H");
        p4.setSexo("M");
        
        p2.setCursos("Informatica");
        p3.setSalario(2500.50f);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
    }
    
}
