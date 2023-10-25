package Main;

import javax.swing.JFrame;
import Interfaces.PainelOpcoes;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
    public Main() {
        setTitle("Agenda App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crie uma instância do PainelOpcoes e adicione-o como painel principal
        PainelOpcoes painelOpcoes = new PainelOpcoes();
        setContentPane(painelOpcoes);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Crie uma instância da classe principal AgendaApp
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}


