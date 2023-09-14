public class UsaPessoa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Mário", "Lopes");
        Funcionario pessoa2 = new Funcionario("Lucas", "Mendes", 123, 2000.00);
        Professor pessoa3 = new Professor("Rafael", "Lira", 456, 1000.00);
        
        System.out.println("=========== Nomes Completos ==========");
        System.out.println("Nome completo pessoa1: " + pessoa1.nomeCompleto());
        System.out.println("Nome completo pessoa2: " + pessoa2.nomeCompleto());
        System.out.println("Nome completo pessoa3: " + pessoa3.nomeCompleto());
        System.out.println("============== Pessoa 2 ==============");
        System.out.println("Salário primeira parcela: R$ " + pessoa2.salarioPrimeiraParcela());
        System.out.println("Salário segunda parcela: R$ " + pessoa2.salarioSegundaParcela());
        System.out.println("============== Pessoa 3 ==============");
        System.out.println("Salário primeira parcela: R$ " + pessoa3.salarioPrimeiraParcela());
        System.out.println("Salário segunda parcela: R$ " + pessoa3.salarioSegundaParcela());
    }
}