public class ContaCorrente extends ContaBancaria {
    private float limite;

    public ContaCorrente(int numConta, double saldo, float limite) {
        super(numConta, saldo);
        this.limite = limite;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public boolean sacar(double valor){
        if(getSaldo()+getLimite()<= valor){
            setSaldo(getSaldo()-valor);
            return true;
        }else
            return false;
    }
    public void depositar(double valor){
        setSaldo(getSaldo()-valor);
    }
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Limite: "+getLimite());
    }
    
}
