public class ContaPoupanca extends ContaBancaria {
    private float taxaDeOperacao;

    public ContaPoupanca(int numConta, double saldo, float taxaDeOperacao) {
        super(numConta, saldo);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    public float getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(float taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    public boolean sacar(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - (valor + taxaDeOperacao));
            return true;
        } else
            return false;
    }

    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
    }

    public void mostrarDados() {
        System.out.println("====== Conta Poupanca =====");
        super.mostrarDados();
        System.out.println("Taxa de Operacao: " + getTaxaDeOperacao());
    }
}
