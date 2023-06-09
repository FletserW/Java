public class ContaPoupanca extends ContaBancaria{
	private int diasRendimento;
	public ContaPoupanca(String nomeCliente, int numeroConta, double saldo){ 
		
	public void setDiasRendimento(int diasRendimento){
		this.diasRendimento=diasRendimento;
	}
	public int getDiasRendimento(){
		return this.diasRendimento 	 
	}
	
	
	public void calcularNovoSaldo(int taxa){
		setSaldo((getSaldo()+(taxa/100))*getDiasRendimento);
