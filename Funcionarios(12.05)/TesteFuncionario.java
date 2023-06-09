public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("João");
        funcionario.setSalario(2000.0);
        funcionario.setStatus("Ativo");

        if (funcionario.getStatus().equalsIgnoreCase("ativo") || funcionario.getStatus().equalsIgnoreCase("demitido")) {
            if (funcionario.verificarFuncionario())
                funcionario.bonifica(200.0);
            else
                System.out.println("O funcionário foi demitido.");
            funcionario.mostra();
        } else
            System.out.println("Status inválido");
    }
}
