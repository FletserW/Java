public class TestaConta {
    public static void main(String[] args) {
        // Conta Bancária
        System.out.println("=-=-=-=-=-=-=-=-=-=-= Conta Bancaria =-=-=-=-=-=-=-=-=-=");
        ContaBancaria conta1 = new ContaBancaria("Joao", 1234, 1000.0);
        conta1.sacar(500.0);
        conta1.imprimirExtrato();
        conta1.depositar(200.0);
        System.out.println("Saldo da conta: " + conta1.getSaldo());

        // Conta Poupança
        System.out.println("=-=-=-=-=-=-=-=-=-=-= Conta Poupanca =-=-=-=-=-=-=-=-=-=");
        ContaPoupanca conta2 = new ContaPoupanca("Maria", 5678, 2000.0, 30);
        conta2.sacar(1000.0);
        conta2.imprimirExtrato();
        conta2.depositar(500.0);
        System.out.println("Saldo da conta poupanca: " + conta2.getSaldo());
        conta2.calcularNovoSaldo(2.5);
        System.out.println("Novo saldo da conta poupanca apos rendimentos: " + conta2.getSaldo());

        // Conta Especial
        System.out.println("=-=-=-=-=-=-=-=-=-=-= Conta Espacial =-=-=-=-=-=-=-=-=-=");
        ContaEspecial conta3 = new ContaEspecial("Ana", 9876, 3000.0, 1000.0);
        conta3.sacar(4000.0);
        conta3.imprimirExtrato();
        conta3.depositar(800.0);
        System.out.println("Saldo da conta especial: " + conta3.getSaldo());
    }
}