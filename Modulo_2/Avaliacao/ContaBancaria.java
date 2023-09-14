public abstract class ContaBancaria implements Imprimivel {
    private int numConta;
    private double saldo;

    public ContaBancaria(int numConta, double saldo) {
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean sacar(double valor);

    public abstract void depositar(double valor);

    public void mostrarDados() {
        System.out.println("Numero da conta: " + getNumConta());
        System.out.println("Saldo: " + getSaldo());
    }
}
