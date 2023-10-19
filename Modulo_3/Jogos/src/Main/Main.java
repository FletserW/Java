package Main;

import Interfaces.TelaControle;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TelaControle()::criarTela);
    }
}
