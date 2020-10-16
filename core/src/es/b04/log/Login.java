package es.b04.log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login(){
        JButton cancelar = new JButton("Cancelar");
        JButton iniciar = new JButton("Iniciar sesion");

        JLabel user = new JLabel("Usuario");
        JLabel pass = new JLabel("Contraseña");

        JTextField usuario = new JTextField();
        JPasswordField contrasena = new JPasswordField();

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new VentanaInicio();
                    }
                });
            }
        });

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hay que implementarlo
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new GridLayout(4, 1, 5, 5));
        panelUsuario.setBorder(BorderFactory.createEmptyBorder(20,20,5,20));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2, 5, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(5,20,20,20));


        panelUsuario.add(user);
        panelUsuario.add(usuario);
        panelUsuario.add(pass);
        panelUsuario.add(contrasena);

        panelBotones.add(cancelar);
        panelBotones.add(iniciar);

        mainPanel.add(panelUsuario);
        mainPanel.add(panelBotones);

        this.add(mainPanel);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Login");
        this.setSize(400, 250);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }

}
