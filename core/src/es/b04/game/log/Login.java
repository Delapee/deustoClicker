package es.b04.game.log;

import es.b04.game.adminTables.UserViewer;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

    public static volatile boolean close = false;
    public static volatile boolean isAdmin = false;
    public static volatile User userPlaying;
    private DBManager db;
    private static final Logger logger = LogManager.getLogger(Login.class);

    public Login(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        db = new DBManager();

        JButton resgistro = new JButton("Registrarse");
        final JButton iniciar = new JButton("Iniciar sesion");

        final JLabel user = new JLabel("Usuario");
        final JLabel pass = new JLabel("Contraseña");

        final JTextField usuario = new JTextField();
        final JPasswordField contrasena = new JPasswordField();


        resgistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new Register();
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
                    try {
                        if (db.isPassOk(usuario.getText(), String.valueOf(contrasena.getPassword()))){
                            userPlaying = db.getUser(usuario.getText());
                            if (usuario.getText().equals("admin")){
                                isAdmin = true;
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
                            }else{
                                close = true;
                                logger.info("Inicio de sesion realizada correctamente");
                            }
                            dispose();
                        }else{
                            usuario.setBorder(new LineBorder(Color.RED, 2));
                            contrasena.setBorder(new LineBorder(Color.RED, 2));
                        }
                    } catch (DBException dbException) {
                        dbException.printStackTrace();
                        logger.error("Error al iniciar sesion.");

                    }
                }
            }
        });

        KeyAdapter enterKey = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    iniciar.doClick();
                }
            }
        };

        usuario.addKeyListener(enterKey);
        contrasena.addKeyListener(enterKey);

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

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
