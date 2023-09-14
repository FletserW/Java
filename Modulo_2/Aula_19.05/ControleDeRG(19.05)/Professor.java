public class Professor extends Funcionario {
    public Professor() {
    }

    public Professor(String nome, String sobrenome, int matricula, double salario) {
        super(nome, sobrenome, matricula, salario);
    }

    public double salarioPrimeiraParcela() {
        return getSalario();
    }

    public double salarioSegundaParcela() {
        return 0.0;
    }
}
