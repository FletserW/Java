/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author reido
 */
public class ContaBanco {
    public int numConta;
    public String tipo;
    public String dono;
    public float saldo;  
    public boolean status;

    public ContaBanco(float saldo, boolean status) {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void estadoAtual(){
        System.out.println("-----------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
    }
    
    public void abrirConta(int numConta,String tipo, String dono){
        this.setStatus(true);
        this.setNumConta(numConta);
        this.setTipo(tipo);
        this.setDono(dono);
        if(tipo == "cc"){
            this.setSaldo(this.getSaldo()+50);
        }else{
            if(tipo == "cp"){
                this.setSaldo(this.getSaldo()+150);
            }else{
                System.out.println("Tipo de conta invalida");
            }
        }
        System.out.println("Conta aberta com exito");
    }
    
    public void fecharConta(){
        if(saldo > 0 || saldo < 0){
            System.out.println("Erro, saldo existente ou em debito");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada com exito");
        }
    }
    public void depositar(int valor){
        if(status){
            this.setSaldo(this.getSaldo()+valor);
        }else{
            System.out.println("Erro, conta esta fechada");
        }
    }
    public void sacar(int valor){
        if(status){
            if(saldo > valor){
                this.setSaldo(this.getSaldo()-valor);
                System.out.println("Valor sacado com exito");
            }else{
                System.out.println("Saldo insuficiente");
            }
        }else{
            System.out.println("Erro, conta fechada.");
        }
    }
    public void pagarMensal(){
        if(status){
            switch(tipo){
                case "cc":
                    if(saldo >= 12){
                        this.setSaldo(this.getSaldo() - 12);
                        System.out.println("Pago com exito");
                    }else{
                        System.out.println("Erro: Saldo Insuficiente.");
                    }
                    break;
                case "cp":
                    if (saldo >= 20) {
                        this.setSaldo(this.getSaldo() - 20);
                        System.out.println("Pago com exito");
                    } else {
                        System.out.println("Erro: Saldo Insuficiente.");
                    }
                    break;
                default:
                    System.out.println("Tipo de conta invalido");
            }
        }
    }
    
}
