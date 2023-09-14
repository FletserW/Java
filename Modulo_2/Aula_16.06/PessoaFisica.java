public class PessoaFisica extends Pessoa{
    private long cpf;
    private int dataNasc;

    public PessoaFisica(){
        super(" ");
    }
    public PessoaFisica(String nome, long cpf, int dataNasc){
        super(nome);
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public int getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(int dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void imprimir(){
        System.out.println("CPF: "+this.getCpf());
        System.out.println("Data de nascimento: "+this.getDataNasc());
    }
    
}
