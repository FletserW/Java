public class PessoaFisica extends Pessoa{
    private double cpf;
    private int dataNasc;

    public PessoaFisica(){

    }
    public PessoaFisica(String nome, double cpf, int dataNasc){
        super(nome);
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }
    public double getCpf() {
        return cpf;
    }
    public void setCpf(double cpf) {
        this.cpf = cpf;
    }
    public int getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(int dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void imprimir(){
        System.out.println("CPF: "+this.getCpf);
        System.out.println("Data de nascimento: "+this.getDataNasc);
    }
    
}
