public class Cachorro{
    private String nome;
    private int idade;
    private double peso;
    private String raca;
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setIdade(int idade){
        this.idade=idade;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setPeso(double peso){
        this.peso=peso;
    }
    public double getPeso(){
        return this.peso;
    }
    public void setRaca(String raca){
        this.raca=raca;
    }
    public String getRaca(){
        return this.peso;
    }
    public void imprimirDados(){
        System.out.println("===Dados do Cachorro===");
        System.out.println("Nome: "+this.getNome());
        System.out.println("Idade: "+this.getIdade);
        System.out.println("Peso: "+this.getPeso);
        System.out.println("Raca: "+this.getRaca);
    }
    public void latir(){
        System.out.println("AU! AU!");
    }
}