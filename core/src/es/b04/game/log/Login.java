package es.b04.game.log;

import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.main.GameMenuScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private boolean check = false;
    private Register r;
    private DBManager db;
    private static final Logger logger = LogManager.getLogger(Login.class);
    public boolean getCheck(){
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Register getR() {
        return r;
    }

    private Register creacionRegistro() throws DBException {
        return r = new Register(this);
    }

    public Login(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        db = new DBManager();

        JButton resgistro = new JButton("Registrarse");
        JButton iniciar = new JButton("Iniciar sesion");

        JLabel user = new JLabel("Usuario");
        JLabel pass = new JLabel("Contraseña");

        final JTextField usuario = new JTextField();
        final JPasswordField contrasena = new JPasswordField();


        resgistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            creacionRegistro();
                        } catch (DBException dbException) {
                            dbException.printStackTrace();
                        }
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
                    /*
                    try {
                        if (db.isPassOk(usuario.getText(), String.valueOf(contrasena.getPassword()))){
                            User user = db.getUser(usuario.getText());
                            check = true;
                            setVisible(false);
                            logger.info("Inicio de sesion realizada correctamente");

                        }else{
                            contrasena.setBorder(new LineBorder(Color.RED, 2));
                            todoOk = false;

                        }
                    } catch (DBException dbException) {
                        dbException.printStackTrace();
                        logger.error("Error al iniciar sesion.");

                    }/*/
                    check = true;
                    setVisible(false);
                    //*/
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

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Dungeon Clicker");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("core/assets/icon/dragon.png"));
        this.setSize(400, 250);
        this.setResizable(false);
        this.setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( screenSize.width - this.getSize().width ) / 2,
                ( screenSize.height - this.getSize().height ) /2  );
    }
}
