/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioContato extends JFrame {
    public FormularioContato() {
        setTitle("Formulário de Contato");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("AGENDA");
        titulo.setBounds(150, 5, 100, 20);
        
        JLabel lblContato = new JLabel("Contato:");
        lblContato.setBounds(20, 30, 100, 30);

        JTextField txtContato = new JTextField();
        txtContato.setBounds(120, 30, 200, 30);

        JLabel lblCelular = new JLabel("Celular:");
        lblCelular.setBounds(20, 70, 100, 30);

        JTextField txtCelular = new JTextField();
        txtCelular.setBounds(120, 70, 200, 30);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(20, 110, 100, 30);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(120, 110, 200, 30);

        JLabel lblGrupo = new JLabel("Grupo:");
        lblGrupo.setBounds(20, 150, 100, 30);

        String[] grupos = {"Amigos", "Família", "Trabalho"};
        JComboBox<String> comboGrupo = new JComboBox<>(grupos);
        comboGrupo.setBounds(120, 150, 200, 30);

        JLabel lblBloqueio = new JLabel("Bloqueio:");
        lblBloqueio.setBounds(20, 190, 100, 30);

        JRadioButton radioSim = new JRadioButton("Sim");
        radioSim.setBounds(120, 190, 80, 30);

        JRadioButton radioNao = new JRadioButton("Não");
        radioNao.setBounds(220, 190, 80, 30);

        ButtonGroup grupoOpcoes = new ButtonGroup();
        grupoOpcoes.add(radioSim);
        grupoOpcoes.add(radioNao);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 230, 100, 30);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dados salvos!");
            }
        });

        add(titulo);
        add(lblContato);
        add(txtContato);
        add(lblCelular);
        add(txtCelular);
        add(lblEmail);
        add(txtEmail);
        add(lblGrupo);
        add(comboGrupo);
        add(lblBloqueio);
        add(radioSim);
        add(radioNao);
        add(btnSalvar);
    }
}