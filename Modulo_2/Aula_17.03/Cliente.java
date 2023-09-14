public class Cliente{
    private String nome;
    private String animal;
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setAnimal(String animal){
        this.animal=animal;
    }
    public String getAnimal(){
        return this.animal;
    }
    public void imprimirDados(){
        System.out.println("===Dados do Cliente===");
        System.out.println("Nome: "+this.getNome());
        System.out.println("Animal: "+this.getAnimal);
    }
}