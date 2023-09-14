 public class Carro {
    private String modelo, marca;
    private int velocidade;
    
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setMarca (String marca){
        this.marca=marca;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    public int getVelocidade(){
        return this.velocidade;
    }
    public void acelerar(){
        setVelocidade(getVelocidade()+10);
    }
    public void freiar(){
        setVelocidade(getVelocidade()-10);
    }
    public void parar(){
        setVelocidade(0);
    }
    public boolean verificarVelocidade(double limite){
        return velocidade > limite;
    }
    public void imprimir(){
        System.out.println("Velocidade: "+velocidade);
    }
}