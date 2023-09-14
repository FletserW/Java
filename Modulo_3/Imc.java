package Modulo_3;
import java.util.Scanner;

public class Imc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de IMC (Índice de Massa Corporal)");
        System.out.print("Digite o peso em Kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite a altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = calcular(peso, altura);
        String classificacao = getClassificacao(imc);

        System.out.println("O seu IMC é: " + imc);
        System.out.println("Classificação: " + classificacao);
    }

    public static double calcular(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static String getClassificacao(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso ideal";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Levemente acima do peso";
        } else if (imc >= 30 && imc <= 34.9) {
            return "Obesidade (Grau 1)";
        } else if (imc >= 35 && imc <= 39.9) {
            return "Obesidade (Grau 2)";
        } else {
            return "Obesidade (Grau 3)";
        }
    }
}
