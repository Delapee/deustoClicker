package es.b04.game.log;

import sun.rmi.runtime.Log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private boolean check = false;
    private Register r;

    public boolean getCheck(){
        return check;
    }

    public Register getR() {
        return r;
    }

    private Register creacionRegistro(){
        return r = new Register();
    }

    public Login(){
        JButton resgistro = new JButton("Registrarse");
        JButton iniciar = new JButton("Iniciar sesion");

        JLabel user = new JLabel("Usuario");
        JLabel pass = new JLabel("Contraseña");

        final JTextField usuario = new JTextField();
        final JPasswordField contrasena = new JPasswordField();

        resgistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        creacionRegistro();
                    }
                });
            }
        });

        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Hay que implementar la BD
                boolean todoOk = true;

                if (usuario.getText().equals("")){
                    usuario.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else {
                    usuario.setBorder(new LineBorder(Color.BLACK));
                }

                if (String.valueOf(contrasena.getPassword()).equals("")){
                    contrasena.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else{
                    contrasena.setBorder(new LineBorder(Color.BLACK));
                }

                if (todoOk){
                    check = true;
                    dispose();
                }
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

        panelBotones.add(resgistro);
        panelBotones.add(iniciar);

        mainPanel.add(panelUsuario);
        mainPanel.add(panelBotones);

        this.add(mainPanel);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Login");
        this.setSize(400, 250);
        this.setResizable(false);
        this.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( screenSize.width - this.getSize().width ) / 2, ( screenSize.height - this.getSize().height ) /2  );
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
