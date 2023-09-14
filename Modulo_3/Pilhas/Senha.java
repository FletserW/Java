package Modulo_3.Pilhas;

import java.util.LinkedList;
import java.util.Scanner;

public class Senha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        LinkedList<String> lista = new LinkedList<String>();
        String nome;
        int senha = 1;
        int op = 0;

        while (op != 3) {
            System.out.println("=============================");
            System.out.println("1 - Inserir nome:");
            System.out.println("2 - Atender:");
            System.out.println("3 - Tamanho da Fila");
            System.out.println("4 - Sair.");
            System.out.println("Digite uma das opções acima:");
            op = ler.nextInt();
            ler.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Insira nome:");
                    nome = ler.nextLine();
                    System.out.println("Prioridade (1 = sim / 2 = não):");
                    int key = ler.nextInt();
                    ler.nextLine(); 

                    if (key == 1) {
                        lista.addFirst("Nome: " + nome + " | Senha: " + senha);
                    } else {
                        lista.addLast("Nome: " + nome + " | Senha: " + senha);
                    }
                    senha += 1;
                    break;

                case 2:
                    if (!lista.isEmpty()) {
                        System.out.println("Atendendo: " + lista.getFirst());
                        lista.removeFirst();
                    } else {
                        System.out.println("Fila vazia!");
                    }
                    break; 

                case 3:
                    int tamlista = lista.size();
                    System.out.println("Número de itens na fila: " + tamlista);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        System.out.println("Programa Finalizado.");
    }
}
