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


        //Medio
        JPanel cen = new JPanel(new GridLayout(3,3));




        //Inferior
        JPanel inf = new JPanel(new FlowLayout());
        JButton cancelar = new JButton("Cancelar");
        JButton registrar = new JButton("Registrarse");
        inf.add(cancelar);
        inf.add(registrar);

        //Asig final

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
