package Interfaces;

import static java.awt.Color.gray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelOpcoes extends JPanel {
    private JButton btnNovo;
    private JButton btnPesquisar;
    private JPanel painelFormularioContato;
    private JPanel painelPesquisa;

    public PainelOpcoes() {
        setBackground(gray);
        setLayout(null);

        btnNovo = new JButton("Novo");
        btnPesquisar = new JButton("Pesquisar");

        btnNovo.setBounds(10, 30, 100, 30);
        btnPesquisar.setBounds(10, 70, 100, 30);

        add(btnNovo);
        add(btnPesquisar);

        // Inicialmente, deixe ambos os painéis invisíveis
        painelFormularioContato = new FormularioContato();
        painelFormularioContato.setBounds(120, 10, 400, 300);
        painelFormularioContato.setVisible(false);
        add(painelFormularioContato);

        painelPesquisa = new PainelPesquisa();
        painelPesquisa.setBounds(120, 10, 400, 300);
        painelPesquisa.setVisible(false);
        add(painelPesquisa);

        // Adicione um ouvinte de ação para o botão "Novo"
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternar a visibilidade do painel de formulário de contato
                painelFormularioContato.setVisible(true);
                painelPesquisa.setVisible(false);
            }
        });

        // Adicione um ouvinte de ação para o botão "Pesquisar"
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternar a visibilidade do painel de pesquisa
                painelFormularioContato.setVisible(false);
                painelPesquisa.setVisible(true);
            }
        });
    }

    public JButton getBtnNovoContato() {
        return btnNovo;
    }

    public JButton getBtnPesquisarContatos() {
        return btnPesquisar;
    }
}
