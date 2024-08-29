/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_10;

public class Aluno extends Pessoa{
    private int matricula;
    private String cursos;
    
    public void cancelarMatr(){
        System.out.println("Matricula sera cancelada");      
    }
    
    public void pagarMensalidade(){
        System.out.println("Pagando mensalidade" + this.nome);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }
    
    
}
