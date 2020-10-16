package es.b04.log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {

    public VentanaInicio(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("DeustoClicker");
        setSize(500, 300);
        setResizable(false);

        this.setLayout(new GridLayout(3, 2));

        JButton login = new JButton("Ya tienes cuenta?");
        JButton registro = new JButton("Registrate!!");
        JButton salir = new JButton("Salir");

        JPanel topSide = new JPanel(new FlowLayout());
        JPanel midSide = new JPanel(new FlowLayout());
        JPanel botSide = new JPanel(new FlowLayout());

        midSide.add(login);
        midSide.add(registro);
        botSide.add(salir);

        this.add(topSide);
        this.add(midSide);
        this.add(botSide);

        setVisible(true);

        //Actions
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login ventanaLogin = new Login();
                dispose();
            }
        });
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro ventanaRegistro = new Registro();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new VentanaInicio();
    }
}
