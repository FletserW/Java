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
    private String modelo;
    private String cor;
    private float ponta;
    private int carga;
    private boolean tampada;
    
    
    public Caneta(String modelo, String cor, float ponta, int carga, boolean tampada){
        this.modelo = modelo;
        this.cor = cor;
        this.ponta = ponta;
        this.carga = carga;
        this.tampada = tampada;
            
    }
    
    
    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getCor(){
        return this.cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public float getPonta(){
        return this.ponta;
    }
    public void setPonta(float ponta){
        this.ponta = ponta;
    }
    public int getCarga(){
        return this.carga;
    }
    public void setCarga(int carga){
        this.carga = carga;
    }
    public boolean getTampada(){
        return this.tampada;
    }
    public void setTampada(boolean tampada){
        this.tampada = tampada;
    }
    
    
    
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
public void destampar(){
    this.tampada = false;
}

} 


