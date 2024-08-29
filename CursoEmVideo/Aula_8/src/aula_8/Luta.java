/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_8;

import java.util.Random;

/**
 *
 * @author reido
 */
public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovado;
    
    public void marcarLuta(Lutador l1, Lutador l2){
        if(l1.getCategoria().equals(l2.getCategoria())&& l1 != l2){
            this.aprovado = true;
            this.desafiado = l1;
            this.desafiante = l2;
        }else{
            this.aprovado = false;
            this.desafiado = null;
            this.desafiante = null;
        }
    }
    public void lutar(){
        if(this.aprovado){
            System.out.println("### DESAFIADO ###");
            this.desafiado.apresentar();
            System.out.println("### DESAFIANTE ###");
            this.desafiante.apresentar();
            System.out.println("### Pontuações ###");
            //Altura=====================================
            if(this.desafiado.getAltura() > this.desafiante.getAltura()){
                this.desafiado.setForça(this.desafiado.getForça()+2);
                this.desafiado.setVelocidade(this.desafiado.getVelocidade()-1);
                System.out.println("Desafiado: força: " + this.desafiado.getForça() + " | Velocidade: " + this.desafiado.getVelocidade());
            }else{
                this.desafiante.setForça(this.desafiante.getForça()+2);
                this.desafiado.setVelocidade(this.desafiado.getVelocidade()-1);
                System.out.println("Desafiante força: " + this.desafiante.getForça() + " | Velocidade: " + this.desafiante.getVelocidade());
            }
            //Idade=====================================
            if(this.desafiado.getIdade()> this.desafiante.getIdade()){
                this.desafiado.setExperiencia(this.desafiado.getExperiencia()+3);
                this.desafiado.setForça(this.desafiado.getForça()-1);
                this.desafiado.setVelocidade(this.desafiado.getVelocidade()-1);
                System.out.println("Desafiado: força: " + this.desafiado.getForça() + " | Velocidade: " + this.desafiado.getVelocidade()+ " | Experiencia: " + this.desafiado.getExperiencia());
            }else{
                this.desafiante.setExperiencia(this.desafiante.getExperiencia()+3);
                this.desafiante.setForça(this.desafiante.getForça()-1);
                this.desafiante.setVelocidade(this.desafiante.getVelocidade()-1);
                System.out.println("Desafiante força: " + this.desafiante.getForça() + " | Velocidade: " + this.desafiante.getVelocidade() + " | Experiencia: " + this.desafiante.getExperiencia());
            }
            //Peso=========================================
            if(this.desafiado.getPeso()> this.desafiante.getPeso()){
                this.desafiado.setForça(this.desafiado.getForça()+1);
                this.desafiado.setVelocidade(this.desafiado.getVelocidade()-1);
                System.out.println("Desafiado: força: " + this.desafiado.getForça() + " | Velocidade: " + this.desafiado.getVelocidade());
            }else{
                this.desafiante.setForça(this.desafiante.getForça()+1);
                this.desafiante.setVelocidade(this.desafiante.getVelocidade()-1);
                System.out.println("Desafiante força: " + this.desafiante.getForça() + " | Velocidade: " + this.desafiante.getVelocidade());
            }
            //sorte ==============================================
            Random sortel1 = new Random();
            int sorte1 = sortel1.nextInt(3);
            this.desafiado.setSorte(sorte1);
            
            Random sortel2 = new Random();
            int sorte2 = sortel2.nextInt(3);
            this.desafiante.setSorte(sorte2);
            System.out.println("========== Resultado =========");
            
            int somaDesafiado = this.desafiado.getForça() + this.desafiado.getVelocidade() + this.desafiado.getExperiencia() + this.desafiado.getSorte();
            int somaDesafiante = this.desafiante.getForça() + this.desafiante.getVelocidade() + this.desafiante.getExperiencia() + this.desafiante.getSorte();

                if(somaDesafiado == somaDesafiante){
                    System.out.println("Empatou");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                }else if(somaDesafiado > somaDesafiante){
                    System.out.println("Vitoria para " + this.desafiado.getNome());
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                }else{
                    System.out.println("Vitoria para " + this.desafiante.getNome());
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    }
        }else{
        System.out.println("A luta não pode acontecer");
        }
    }
    

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    
}
