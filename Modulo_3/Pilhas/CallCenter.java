package Modulo_3.Pilhas;
import java.util.Scanner;
import java.util.LinkedList;

public class CallCenter {
    public static void main (String[] args){
        try (Scanner ler = new Scanner( System.in)) {
            LinkedList<String> lista = new LinkedList<String>();
            int op = 0;
            String nome;
            String numero;
            while(op != 3){
                System.out.println("=============================");
                System.out.println("1 - Inserir contato:");
                System.out.println("2 - Proximo contato:");
                System.out.println("3 - Sair.");
                System.out.println("Escolha uma opção: ");
                op = ler.nextInt();
                ler.nextLine();
                switch (op) {
                    case 1:
                        System.out.println("insira nome: ");
                        nome = ler.nextLine();
                        System.out.println("insira numero: ");
                        numero = ler.nextLine();
                        lista.addLast("nome: "+ nome +"| numero: " + numero);
                        break;
                    case 2:
                        if(!lista.isEmpty()){
                        System.out.println(lista.getFirst());
                        lista.removeFirst();
                        }else{
                        System.out.println("lista vazia!");
                        }
                    default:
                        System.out.println("Programa Finalizado.");
                    break;
                }
            }
        }
    }
}

