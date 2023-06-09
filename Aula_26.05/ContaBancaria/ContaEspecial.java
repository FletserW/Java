public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial() {

    }

    public ContaEspecial(String nomeCliente, int numeroConta, double saldo, double limite) {
        super(nomeCliente, numeroConta, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void sacar(double valor) {
        double saldoTotal = getSaldo() + limite;
        if (saldoTotal >= valor) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente. Saque nao realizado.");
        }
    }
}