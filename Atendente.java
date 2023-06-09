public class Atendente{
    private String nome;
    
    public void setName(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void imprimir(){
        System.out.println("===Dados do Atendente===");
        System.out.println("Nome: "+this.getNome());
    } 
}