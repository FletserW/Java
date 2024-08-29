/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula_6;

/**
 *
 * @author reido
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class LanguageSwitcher {

    private Properties messages;

    public LanguageSwitcher() {
        // Carrega o arquivo de propriedades padrão (inglês)
        loadProperties("messages_en_us.properties");
    }

    public void switchLanguage(String languageCode) {
        // Constrói o caminho do arquivo de propriedades com base no código do idioma
        String fileName = "messages_" + languageCode.toLowerCase() + ".properties";
        // Carrega o arquivo de propriedades correspondente
        loadProperties(fileName);
    }

    private void loadProperties(String fileName) {
        // Inicializa o objeto Properties
        messages = new Properties();
        try {
            // Carrega o arquivo de propriedades
            messages.load(new FileInputStream("resources/" + fileName));
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de propriedades: " + e.getMessage());
        }
    }

    public String getMessage(String key) {
        // Obtém a mensagem com base na chave especificada
        return messages.getProperty(key, "Chave não encontrada: " + key);
    }

    public static void main(String[] args) {
        LanguageSwitcher switcher = new LanguageSwitcher();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Exibe o menu de seleção de idioma
            System.out.println("Selecione o idioma:");
            System.out.println("1. Português (Brasil)");
            System.out.println("2. English (United States)");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (choice) {
                case 1:
                    switcher.switchLanguage("pt_br");
                    break;
                case 2:
                    switcher.switchLanguage("en_us");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    continue; // Volta para o início do loop
            }

            // Exemplo de uso das mensagens
            System.out.println(switcher.getMessage("welcome"));
            System.out.println(switcher.getMessage("prompt"));
        }
    }
}
