package es.b04.game.log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private boolean check = false;

    public boolean getCheck(){
        return check;
    }

    public Register(){
        setTitle("Ventana de Registro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,350);
        setVisible(true);
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( screenSize.width - this.getSize().width ) / 2, ( screenSize.height - this.getSize().height ) /2  );

        //Superior
        JPanel sup = new JPanel(new FlowLayout());
        sup.add(new JLabel("Ventana de Registro DeustoClick"));

        //Medio
        JPanel cen = new JPanel(new GridLayout(3,2,1,1));
        cen.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
        JPanel cen1 = new JPanel(new GridLayout(2,1,1,1));
        cen1.setBorder(BorderFactory.createEmptyBorder(20,10,10,20));
        JPanel cen2 = new JPanel(new GridLayout(2,1,1,1));
        cen2.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        JPanel cen3 = new JPanel(new GridLayout(2,1,1,1));
        cen3.setBorder(BorderFactory.createEmptyBorder(10,10,10,20));
        JPanel cen4 = new JPanel(new GridLayout(2,1,1,1));
        cen4.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        JPanel cen5 = new JPanel(new GridLayout(2,1,1,1));
        cen5.setBorder(BorderFactory.createEmptyBorder(10,10,20,20));
        JPanel cen6 = new JPanel(new GridLayout(2,1,1,1));
        cen6.setBorder(BorderFactory.createEmptyBorder(10,20,20,10));

        final JTextField usuario = new JTextField(20);
        final JTextField mail = new JTextField(20);
        final JPasswordField contra = new JPasswordField(20);
        final JPasswordField contraR = new JPasswordField(20);
        final JComboBox<String> sexo = new JComboBox<String>();
        sexo.addItem("Hombre");
        sexo.addItem("Mujer");
        sexo.addItem("Otro");
        final SpinnerNumberModel edadModel = new SpinnerNumberModel(18, 1, 150, 1);
        final JSpinner edad = new JSpinner(edadModel);


        cen1.add(new JLabel("Nombre de Usuario"));
        cen2.add(new JLabel("Direccion e-mail"));
        cen3.add(new JLabel("Contraseña"));
        cen4.add(new JLabel("Repetir Contraseña"));
        cen5.add(new JLabel("Sexo"));
        cen6.add(new JLabel("Edad"));

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
                setVisible(false);


            }
        });

        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Falta el linkeo con la base de datos
                boolean todoOk = true;

                if (usuario.getText().equals("")){
                    usuario.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else{
                    usuario.setBorder(new LineBorder(Color.BLACK));
                }

                if (mail.getText().equals("") && !mail.getText().contains("@")){
                    mail.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else{
                    String email = mail.getText();
                    String[] mailParts = email.split("@");
                    if (mailParts.length != 2){
                        mail.setBorder(new LineBorder(Color.RED, 2));
                        todoOk = false;
                    }else if(!mailParts[1].contains(".") ){
                        mail.setBorder(new LineBorder(Color.RED, 2));
                        todoOk = false;
                    } else {
                        mail.setBorder(new LineBorder(Color.BLACK));
                    }

                }

                if (String.valueOf(contra.getPassword()).equals("")){
                    contra.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else {
                    contra.setBorder(new LineBorder(Color.BLACK));
                }

                if (!String.valueOf(contra.getPassword()).equals(String.valueOf(contraR.getPassword()))){
                    contraR.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else if (String.valueOf(contraR.getPassword()).equals("")){
                    contraR.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else {
                    contraR.setBorder(new LineBorder(Color.BLACK));
                }

                if (todoOk){
                    User u = new User(usuario.getText(), String.valueOf(contraR.getPassword()),
                                      mail.getText(), String.valueOf(sexo.getSelectedItem()), (Integer) edad.getValue());
                    check = true;
                    dispose();
                }

            }
        });
    }
}
