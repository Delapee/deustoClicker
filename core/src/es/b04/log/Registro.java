package es.b04.log;

import javax.swing.*;
import java.awt.*;

public class Registro extends JFrame {

    public Registro(){
        setTitle("Ventana de Registro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,500);

        //Superior
        JPanel sup = new JPanel(new FlowLayout());
        sup.add(new JLabel("Ventana de Registro"));


        //Medio
        JPanel cen = new JPanel(new GridLayout(3,2));
        JPanel cen1 = new JPanel(new FlowLayout());
        JPanel cen2 = new JPanel(new FlowLayout());
        JPanel cen3 = new JPanel(new FlowLayout());
        JPanel cen4 = new JPanel(new FlowLayout());
        JPanel cen5 = new JPanel(new FlowLayout());
        JPanel cen6 = new JPanel(new FlowLayout());

        cen1.add(new JLabel("Usuario"));
        cen2.add(new JLabel("e-mail"));
        cen3.add(new JLabel("Contraseña"));
        cen4.add(new JLabel("R-Contraseña"));
        cen5.add(new JLabel("Sexo"));
        cen6.add(new JLabel("Edad"));

        JTextField usuario = new JTextField(15);
        JTextField mail = new JTextField(15);
        JTextField contra = new JTextField(15);
        JTextField contraR = new JTextField(15);
        JTextField sexo = new JTextField(15);
        JTextField edad = new JTextField(15);

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


        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Registro();
            }
        });

    }

}
