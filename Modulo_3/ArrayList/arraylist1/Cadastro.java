package arraylist1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Pessoa> pessoas = new ArrayList<>();

            while (true) {
                System.out.println("=============================");
                System.out.println("Menu:");
                System.out.println("1. Inserir dados");
                System.out.println("2. Alterar dados");
                System.out.println("3. Excluir");
                System.out.println("4. Imprimir todos os dados");
                System.out.println("5. Sair do programa");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite a data de nascimento: ");
                        String dataNasc = scanner.nextLine();
                        Pessoa novaPessoa = new Pessoa(nome, cpf, dataNasc);
                        pessoas.add(novaPessoa);
                        System.out.println("Dados da pessoa inseridos com sucesso.");
                        break;

                    case 2:
                        System.out.print("Digite o índice da pessoa a ser alterada: ");
                        int indiceAlterar = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceAlterar >= 0 && indiceAlterar < pessoas.size()) {
                            Pessoa pessoaParaAlterar = pessoas.get(indiceAlterar);
                            System.out.print("Digite o novo nome: ");
                            pessoaParaAlterar.setNome(scanner.nextLine());
                            System.out.print("Digite o novo CPF: ");
                            pessoaParaAlterar.setCpf(scanner.nextLine());
                            System.out.print("Digite a nova data de nascimento: ");
                            pessoaParaAlterar.setDataNasc(scanner.nextLine());
                            System.out.println("Dados da pessoa alterados com sucesso.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o índice da pessoa a ser excluída: ");
                        int indiceExcluir = scanner.nextInt();
                        scanner.nextLine();
                        if (indiceExcluir >= 0 && indiceExcluir < pessoas.size()) {
                            pessoas.remove(indiceExcluir);
                            System.out.println("Pessoa excluída com sucesso.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                        break;

                    case 4:
                        System.out.println("Lista de pessoas:");
                        for (int i = 0; i < pessoas.size(); i++) {
                            System.out.println("Índice " + i + ": " + pessoas.get(i));
                        }
                        break;

                    case 5:
                        System.out.println("Encerrando o programa.");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }
    }
}