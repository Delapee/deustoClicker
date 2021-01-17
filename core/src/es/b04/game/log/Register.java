package es.b04.game.log;


import es.b04.game.adminTables.UserViewer;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame {

    public static final Pattern emailValidRegex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private DBManager db;
    final List<String> usersNames;

    public Register() throws DBException {
        db = new DBManager();
        usersNames = new ArrayList<>(db.getAllUserNames());

        setTitle("Dungeon Clicker");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("core/assets/icon/dragon.png"));
        setSize(500,350);
        setVisible(true);
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( screenSize.width - this.getSize().width ) / 2,
                ( screenSize.height - this.getSize().height ) /2  );

        //Superior
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Ventana de registro Dungeon Clicker"));

        //Medio
        JPanel cen = new JPanel(new GridLayout(3,2,1,1));

        JPanel cen1 = new JPanel(new GridLayout(2,1,1,1));
        cen1.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
        JPanel cen2 = new JPanel(new GridLayout(2,1,1,1));
        cen2.setBorder(BorderFactory.createEmptyBorder(20,10,10,20));
        JPanel cen3 = new JPanel(new GridLayout(2,1,1,1));
        cen3.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        JPanel cen4 = new JPanel(new GridLayout(2,1,1,1));
        cen4.setBorder(BorderFactory.createEmptyBorder(10,10,10,20));
        JPanel cen5 = new JPanel(new GridLayout(2,1,1,1));
        cen5.setBorder(BorderFactory.createEmptyBorder(10,20,10,10));
        JPanel cen6 = new JPanel(new GridLayout(2,1,1,1));
        cen6.setBorder(BorderFactory.createEmptyBorder(10,10,10,20));

        final JTextField user = new JTextField(20);
        final JTextField email = new JTextField(20);
        final JPasswordField pass = new JPasswordField(20);
        final JPasswordField passR = new JPasswordField(20);
        final JComboBox<String> gender = new JComboBox<>();
        gender.addItem("Hombre");
        gender.addItem("Mujer");
        gender.addItem("Otro");
        final SpinnerNumberModel ageModel = new SpinnerNumberModel(18, 1, 150, 1);
        final JSpinner age = new JSpinner(ageModel);


        cen1.add(new JLabel("Nombre de Usuario"));
        cen2.add(new JLabel("Direccion e-mail"));
        cen3.add(new JLabel("Contraseña"));
        cen4.add(new JLabel("Repetir Contraseña"));
        cen5.add(new JLabel("Sexo"));
        cen6.add(new JLabel("Edad"));

        cen1.add(user);
        cen2.add(email);
        cen3.add(pass);
        cen4.add(passR);
        cen5.add(gender);
        cen6.add(age);

        cen.add(cen1);
        cen.add(cen2);
        cen.add(cen3);
        cen.add(cen4);
        cen.add(cen5);
        cen.add(cen6);


        //Inferior
        JPanel bott = new JPanel(new FlowLayout());
        JButton cancel = new JButton("Cancelar");
        JButton register = new JButton("Registrarse");
        bott.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        bott.add(cancel);
        bott.add(register);

        //Asig final
        add(BorderLayout.PAGE_START,top);
        add(BorderLayout.CENTER,cen);
        add(BorderLayout.PAGE_END,bott);


        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginWindow();
                dispose();
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Verificación de que los dato ha sido bien introducido en cada campo
                boolean todoOk = true;

                if (user.getText().equals("")){
                    user.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else{
                    if (usersNames.contains(user.getText())){
                        user.setBorder(new LineBorder(Color.RED, 2));
                        todoOk = false;
                    }else{
                        user.setBorder(new LineBorder(Color.BLACK));
                    }
                }

                if (!validate(email.getText())){
                    email.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else{
                    email.setBorder(new LineBorder(Color.BLACK));
                }

                if (String.valueOf(pass.getPassword()).equals("")){
                    pass.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else {
                    pass.setBorder(new LineBorder(Color.BLACK));
                }

                if (String.valueOf(passR.getPassword()).equals("")){
                    passR.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else if (!String.valueOf(pass.getPassword()).equals(String.valueOf(passR.getPassword()))){
                    passR.setBorder(new LineBorder(Color.RED, 2));
                    todoOk = false;
                }else {
                    passR.setBorder(new LineBorder(Color.BLACK));
                }

                if (todoOk){
                    User u = new User(user.getText(), String.valueOf(pass.getPassword()),
                                      email.getText(), String.valueOf(gender.getSelectedItem()),
                            (Integer) age.getValue());
                    try {
                        db.storeNewUser(u);
                    } catch (DBException dbException) {
                        dbException.printStackTrace();
                    }
                    if (!Login.isAdmin){
                        loginWindow();
                    }else{
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    new UserViewer();
                                } catch (DBException dbException) {
                                    dbException.printStackTrace();
                                }
                            }
                        });
                    }
                    dispose();
                }

            }
        });
    }

    public static boolean validate(String email) {
        Matcher matcher = emailValidRegex.matcher(email);
        return matcher.find();
    }

    private void loginWindow(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
