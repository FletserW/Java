package BaseSalarial;

public class TesteClasses {
    public static void main(String[] args) {
        // Teste da classe Fornecedor
        Fornecedor fornecedor = new Fornecedor("Fornecedor 1", "Rua A", "123456789", 5000.0, 2000.0);
        System.out.println("Saldo do fornecedor: " + fornecedor.obterSaldo());

        // Teste da classe Empregado
        Empregado empregado = new Empregado("Empregado 1", "Rua B", "987654321", 1, 3000.0, 10.0);
        System.out.println("Salário do empregado: " + empregado.calcularSalario());

        // Teste da classe Administrador
        Administrador administrador = new Administrador("Administrador 1", "Rua C", "543216789", 2, 4000.0, 15.0, 1000.0);
        System.out.println("Salário do administrador: " + administrador.calcularSalario());

        // Teste da classe Operario
        Operario operario = new Operario("Operario 1", "Rua D", "987654123", 3, 2000.0, 8.0, 500.0, 5.0);
        System.out.println("Salário do operario: " + operario.calcularSalario());

        // Teste da classe Vendedor
        Vendedor vendedor = new Vendedor("Vendedor 1", "Rua E", "789654123", 4, 2500.0, 10.0, 10000.0, 2.0);
        System.out.println("Salário do vendedor: " + vendedor.calcularSalario());
    }
}