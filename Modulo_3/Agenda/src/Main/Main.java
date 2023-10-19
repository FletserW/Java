package Main;

import javax.swing.*;
import Interfaces.FormularioContato;

public class Main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormularioContato().setVisible(true);
            }
        });
    }
}

