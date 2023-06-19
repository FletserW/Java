public class PessoaJuridica extends Pessoa{
    private double cnpj;
    private int insEstadual;
    private String nomef;
    private String razaoSocial;

    public PessoaJuridica(String nome, double cnpj, int insEstadual, String nomef, String razaoSocial) {
        super(nome);
        this.cnpj = cnpj;
        this.insEstadual = insEstadual;
        this.nomef = nomef;
        this.razaoSocial = razaoSocial;
    }
    public double getCnpj() {
        return cnpj;
    }
    public void setCnpj(double cnpj) {
        this.cnpj = cnpj;
    }
    public int getInsEstadual() {
        return insEstadual;
    }
    public void setInsEstadual(int insEstadual) {
        this.insEstadual = insEstadual;
    }
    public String getNomef() {
        return nomef;
    }
    public void setNomef(String nomef) {
        this.nomef = nomef;
    }
    public String getRazaoSocial() {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public void imprimir(){
        System.out.println("CNPJ: "+this.getCnpj());
        System.out.println("Inscrição Estadual: "+this.getInsEstadual());
    }
    
}
