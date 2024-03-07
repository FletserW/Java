package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JMenuBar;

public class jLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textSenha;
	private JTextField textSenha_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jLogin frame = new jLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	public jLogin() {
		// Define a cor de fundo
        Color corDeFundo = new Color(0x6E8066);
        Color corDoBotao = new Color(0x97A989);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 462);
		contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel viewInicial = new JPanel();
		viewInicial.setBounds(312, 33, 308, 341);
		contentPane.add(viewInicial);
		viewInicial.setLayout(new CardLayout(0, 0));
		
		JPanel menu = new JPanel();
		viewInicial.add(menu, "name_7183515137600");
		menu.setBackground(new Color(110, 128, 102));
		menu.setLayout(null);
		
		JPanel cadastro = new JPanel();
		cadastro.setBackground(new Color(129, 148, 120));
		viewInicial.add(cadastro, "name_8705421423700");
		cadastro.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				cadastro.setVisible(true);
				
			}
		});
		btnCadastrar.setBounds(81, 159, 120, 50);
		menu.add(btnCadastrar);
		btnCadastrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCadastrar.setBackground(corDoBotao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(81, 248, 120, 50);
		menu.add(btnSair);
		btnSair.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSair.setBackground(corDoBotao);
		btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fechar o aplicativo
            }
        });
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(81, 77, 120, 50);
		menu.add(btnEntrar);
		btnEntrar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnEntrar.setBackground(corDoBotao);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNome.setBounds(10, 47, 60, 30);
		cadastro.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(84, 49, 170, 30);
		cadastro.add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(84, 103, 170, 30);
		cadastro.add(textEmail);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(84, 161, 170, 30);
		cadastro.add(textSenha);
		
		textSenha_2 = new JTextField();
		textSenha_2.setColumns(10);
		textSenha_2.setBounds(154, 218, 144, 30);
		cadastro.add(textSenha_2);
		
		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNome_1.setBounds(84, 111, 60, 30);
		cadastro.add(lblNome_1);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmail.setBounds(10, 101, 60, 30);
		cadastro.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senhar:");
		lblSenha.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblSenha.setBounds(10, 161, 60, 30);
		cadastro.add(lblSenha);
		
		JLabel lblSenha_2 = new JLabel("Confirme a senhar:");
		lblSenha_2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblSenha_2.setBounds(10, 216, 148, 30);
		cadastro.add(lblSenha_2);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCriar.setBackground(new Color(151, 169, 137));
		btnCriar.setBounds(24, 277, 120, 40);
		cadastro.add(btnCriar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro.setVisible(false);
				menu.setVisible(true);
				textNome.setText("");
				textEmail.setText("");
				textSenha.setText("");
				textSenha_2.setText("");
				
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCancelar.setBackground(new Color(151, 169, 137));
		btnCancelar.setBounds(166, 277, 120, 40);
		cadastro.add(btnCancelar);
		
		JPanel conectar = new JPanel();
		conectar.setBackground(new Color(129, 148, 120));
		viewInicial.add(conectar, "name_13511890820000");
		conectar.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(104, 101, 101, 22);
		conectar.add(menuBar);
		
		JLabel imgLogo = new JLabel("");
		imgLogo.setIcon(new ImageIcon("C:\\Users\\reido\\OneDrive\\Documents\\.TI\\My-Projetc\\Java\\TCC\\src\\img\\logo.png"));
		imgLogo.setBounds(0, 11, 302, 396);
		contentPane.add(imgLogo);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
