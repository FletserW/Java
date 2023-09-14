public class Funcionario extends Pessoa {
    private int matricula;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobrenome, int matricula, double salario) {
        super(nome, sobrenome);
        this.matricula = matricula;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("Salário inválido. O salário não pode ser negativo.");
        }
    }

    public double salarioPrimeiraParcela() {
        return salario * 0.6;
    }

    public double salarioSegundaParcela() {
        return salario * 0.4;
    }
}
