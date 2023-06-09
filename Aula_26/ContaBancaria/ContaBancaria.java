public class ContaBancaria{
	private	String nomeCliente;
	private	int numeroConta;
	private double saldo;
	
	public ContaBancaria(){
	}
	
	public ContaBancaria(String nomeCliente, int numeroConta, double saldo){
		this.nomeCliente=nomeCliente;
		this.numeroConta=numeroConta;
		this.saldo=saldo;
	}	
	
	public void setNomeCliente(String nomeCliente){
		this.nomeCliente=nomeCliente;
	}
	public String getNomeCliente(){
		return this.nomeCliente;
	}
	public void setNumeroConta(int numeroConta){
		this.numeroConta=numeroConta;
	}
	public int getNumeroConta(){
		return this.numeroConta;
	}
	public void setSaldo(double saldo){
		this.saldo=saldo;
	}
	public double getSaldo(){
		return this.saldo;
	}
	public double depositar(double valor){
		setSaldo(getSaldo()+valor);
	}
	public void sacar(double valor){
		if (this.getSaldo() >= valor) {
			setSaldo(getSaldo()-valor);
			System.out.println("Saque realizado com sucesso!");
		}else{
		 	System.out.println("Saldo insuficiente");
		}
	}
	public void imprimirExtrato(){
		System.out.println("Nome: "+this.getNomeCliente());
		System.out.println("Número da Conta: "+this.getNumeroConta());
		System.out.println("Saldo Atual: "+this.getSaldo());
	}				
															
				 						 	
