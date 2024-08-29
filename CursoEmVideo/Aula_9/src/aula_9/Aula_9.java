/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula_9;

/**
 *
 * @author reido
 */
public class Aula_9 {

    public static void main(String[] args) {
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];
        
        p[0] = new Pessoa("Pedro", 22, "H");
        p[1] = new Pessoa("Maria", 22, "M");
        
        l[0] = new Livro("Aprendendo Java", "Jose da silva", 300, p[0]);
        l[1] = new Livro("POO para iniciantes", "Pedro Paulo",500,p[1]);
        l[2] = new Livro("Java avançado","Maria Candido",580,p[0]);
        
        
        l[0].abrir();
        l[0].folhar(200);
        l[0].avancarPagina();
        System.out.println(l[0].detalhes());
    }
    
}
