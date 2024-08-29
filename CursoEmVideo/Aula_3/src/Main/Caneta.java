/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author reido
 */
public class Caneta {
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    protected boolean tampada;
    
void status(){
    System.out.println("Modelo: " + this.modelo);
    System.out.println("Uma caneta " + this.cor);
    System.out.println("Ponta: " + this.ponta);
    System.out.println("Carga: " + this.carga);
    System.out.println("Tampada: " + this.tampada);
}
    
public void rabiscar(){
    if(tampada == true){
    System.out.println("Erro não posso rabiscar");
    }else{
        System.out.println("Rabiscado");
    }
}
public void tampar(){
    this.tampada = true;
}
private void destampar(){
    this.tampada = false;
}

} 


