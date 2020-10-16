package es.b04.log;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login(){
        JButton cancelar = new JButton("Cancelar");
        JButton iniciar = new JButton("Iniciar sesion");

        JLabel user = new JLabel("Usuario");
        JLabel pass = new JLabel("Contraseña");

        JTextField usuario = new JTextField();
        JPasswordField contrasena = new JPasswordField();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout(new GridLayout(4, 1, 5, 5));


        panelUsuario.add(user);
        panelUsuario.add(usuario);
        panelUsuario.add(pass);
        panelUsuario.add(contrasena);

        mainPanel.add(panelUsuario);

        this.add(mainPanel);







        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Login");
        this.setSize(500, 200);
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
