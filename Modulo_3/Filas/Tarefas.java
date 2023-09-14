package Modulo_3.Filas;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarefas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaDeTarefas = new ArrayList<>();

        while (true) {
            System.out.println("=============================");
            System.out.println("Opções:");
            System.out.println("1. Inserir tarefa na lista");
            System.out.println("2. Obter a próxima tarefa da lista");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Digite a tarefa a ser inserida: ");
                    String tarefa = scanner.nextLine();
                    listaDeTarefas.add(tarefa);
                    System.out.println("Tarefa inserida na lista.");
                    break;

                case 2:
                    if (!listaDeTarefas.isEmpty()) {
                        String proximaTarefa = listaDeTarefas.remove(0);
                        System.out.println("Próxima tarefa: " + proximaTarefa);
                    } else {
                        System.out.println("Lista de tarefas vazia.");
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}