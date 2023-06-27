public class Banco {
    public static void main(String[] args) {
        ContaBancaria contaP = new ContaPoupanca(100, 500, 10);
        ContaBancaria contaC = new ContaCorrente(150, 700, 300);

        contaP.depositar(500.0);
        contaC.depositar(1000.0);

        // Conta Poupança
        if (contaP.sacar(800.0))
            System.out.println("Valor depositado com sucesso");
        else
            System.out.println("Saldo insuficiente!");

        // Conta Corrente
        if (contaC.sacar(1800.0))
            System.out.println("Valor depositado com sucesso");
        else
            System.out.println("Saldo insuficiente!");

        contaP.mostrarDados();
        contaC.mostrarDados();
    }
}
