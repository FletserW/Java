public class Funcionario {
    private String nome;
    private double salario;
    private String status;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void bonifica(double valor) {
        salario += valor;
    }
    public boolean verificarFuncionario() {
        return status.equalsIgnoreCase("ativo");
    }
    public void mostra() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Nome: " + nome);
        System.out.println("Salário: " + salario);
        System.out.println("Status: " + status);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    }
}
