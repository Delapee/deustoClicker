package es.b04.game.log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    public Register(){
        setTitle("Ventana de Registro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,450);

        //Superior
        JPanel sup = new JPanel(new FlowLayout());
        sup.add(new JLabel("Ventana de Registro DeustoClick"));


        //Medio
        JPanel cen = new JPanel(new GridLayout(3,2,1,1));
        JPanel cen1 = new JPanel(new FlowLayout());
        JPanel cen2 = new JPanel(new FlowLayout());
        JPanel cen3 = new JPanel(new FlowLayout());
        JPanel cen4 = new JPanel(new FlowLayout());
        JPanel cen5 = new JPanel(new FlowLayout());
        JPanel cen6 = new JPanel(new FlowLayout());

        cen1.add(new JLabel("Nombre de Usuario"));
        cen2.add(new JLabel("Direccion e-mail"));
        cen3.add(new JLabel("Contraseña"));
        cen4.add(new JLabel("Repetir Contraseña"));
        cen5.add(new JLabel("Sexo"));
        cen6.add(new JLabel("Edad"));

        JTextField usuario = new JTextField(20);
        JTextField mail = new JTextField(20);
        JTextField contra = new JTextField(20);
        JTextField contraR = new JTextField(20);
        JTextField sexo = new JTextField(20);
        JTextField edad = new JTextField(20);

        cen1.add(usuario);
        cen2.add(mail);
        cen3.add(contra);
        cen4.add(contraR);
        cen5.add(sexo);
        cen6.add(edad);

        cen.add(cen1);
        cen.add(cen2);
        cen.add(cen3);
        cen.add(cen4);
        cen.add(cen5);
        cen.add(cen6);


        //Inferior
        JPanel inf = new JPanel(new FlowLayout());
        JButton cancelar = new JButton("Cancelar");
        JButton registrar = new JButton("Registrarse");
        inf.add(cancelar);
        inf.add(registrar);

        //Asig final
        add(BorderLayout.PAGE_START,sup);
        add(BorderLayout.CENTER,cen);
        add(BorderLayout.PAGE_END,inf);


        //Action Listener

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Login();
                    }
                });
            }
        });

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Falta el linkeo con la base de datos

            }
        });


        setVisible(true);
    }
}
