public class ContaPoupanca extends ContaBancaria {
	private int diasRendimento;

	public ContaPoupanca() {
	}

	public ContaPoupanca(String nomeCliente, int numeroConta, double saldo, int diasRendimento) {
		super(nomeCliente, numeroConta, saldo);
		this.diasRendimento = diasRendimento;
	}

	public int getDiasRendimento() {
		return diasRendimento;
	}

	public void setDiasRendimento(int diasRendimento) {
		this.diasRendimento = diasRendimento;
	}

	public void calcularNovoSaldo(double taxaRendimento) {
		double rendimentos = getSaldo() * (taxaRendimento / 100) * (diasRendimento / 365);
		depositar(rendimentos);
	}
}
