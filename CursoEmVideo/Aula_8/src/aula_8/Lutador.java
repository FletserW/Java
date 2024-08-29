/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_8;

/**
 *
 * @author reido
 */
public class Lutador {
    private String nome, nacionalidade, categoria;
    private int idade, vitorias, derrotas, empates;
    private float altura, peso;
    private int força = 5, velocidade = 5, experiencia = 5, sorte;

    public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derroatas, int empates) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.setPeso(peso);
        this.vitorias = vitorias;
        this.derrotas = derroatas;
        this.empates = empates;
    }
    
    public void apresentar(){
        System.out.println("----------------------------------------------");
        System.out.println("Chegou a hora! apresentando o lutador " + this.getNome());
        System.out.println("Diretamante de " + this.getNacionalidade());
        System.out.println("Com " + this.getIdade() + " anos e " + this.getAltura() + "de altura");
        System.out.println("Pesando " + this.getPeso() + "KG");
        System.out.println(this.getVitorias() + " Vitorias");
        System.out.println(this.getDerrotas() + " Derrotas");
        System.out.println(this.getEmpates() + " Empates");
    }
    public void status(){
        System.out.println("-----------------------------------------------");
        System.out.println(this.getNome() + " e um peso " + this.categoria);
        System.out.println("Ganhou " + this.vitorias + " vezes");
        System.out.println("Pedeu " + this.derrotas + " vezes");
        System.out.println("Empatou " + this.empates + " vezes");
    }
    public void ganharLuta(){
        this.setVitorias(this.getVitorias() + 1);
    }
    public void perderLuta(){
        this.setDerrotas(this.getDerrotas() + 1);
    }
    public void empatarLuta(){
        this.setEmpates(this.getEmpates() + 1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if(this.peso < 52.2){
            this.categoria = "invalido";
        }else if(this.peso <= 70.3){
            this.categoria = "leve";
        }else if(this.peso <= 83.9){
            this.categoria = "medio";
        }else if(this.peso <= 120.2){
            this.categoria = "Pesado";
        }else{
            this.categoria = "Invalido";
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derroatas) {
        this.derrotas = derroatas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public int getForça() {
        return força;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getSorte() {
        return sorte;
    }

    public void setSorte(int sorte) {
        this.sorte = sorte;
    }
    
}
