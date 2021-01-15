package es.b04.game.adminTables;

import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.log.Login;
import es.b04.game.log.Register;
import es.b04.game.log.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserViewer extends JFrame implements WindowListener {

    private static final long serialVersionUID = 1619152556982152009L;

    private DBManager db;

    private UserListModel userListModel;
    private JList<User> userJList;
    private UserInfoPanel userInfoPanel;

    private JTable championTable;
    private ChampionTableModel championTableModel;

    private JLabel totalUsers;

    public UserViewer() throws DBException {
        db = new DBManager();
        db.connection("dungeonClicker.db");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(960, 600);
        setTitle("Vista de usuarios");

        addWindowListener(this);

        prepareMenuBar();
        prepareUserList();
        prepareMainPanel();
        loadUsers();

        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation( ( screenSize.width - this.getSize().width ) / 2,
                ( screenSize.height - this.getSize().height ) /2  );
    }

    private void prepareMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu optionsJMenu = new JMenu("Opciones");
        menuBar.add(optionsJMenu);

        JMenu toolsJMenu = new JMenu("Herramientas");
        menuBar.add(toolsJMenu);

        JMenuItem playItem = new JMenuItem("Jugar");
        optionsJMenu.add(playItem);

        JMenuItem playAsItem = new JMenuItem("Jugar como..");
        optionsJMenu.add(playAsItem);

        JMenuItem loginItem = new JMenuItem("Login");
        optionsJMenu.add(loginItem);

        JMenuItem registerItem = new JMenuItem("Registro");
        optionsJMenu.add(registerItem);

        JMenuItem exitItem = new JMenuItem("Salir");
        optionsJMenu.add(exitItem);

        JMenuItem userAddItem = new JMenuItem("Añadir Usuario");
        toolsJMenu.add(userAddItem);

        JMenuItem userDeleteItem = new JMenuItem("Eliminar Usuario");
        toolsJMenu.add(userDeleteItem);

        JMenuItem champAddItem = new JMenuItem("Añadir Campeon");
        toolsJMenu.add(champAddItem);

        JMenuItem champDeleteItem = new JMenuItem("Eliminar Campeon");
        toolsJMenu.add(champDeleteItem);


        loginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Login();
                    }
                });
                dispose();
            }
        });

        registerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                dispose();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

    }

    private void prepareUserList() {
        userListModel = new UserListModel();
        userJList = new JList<User>(userListModel);
        userJList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        JScrollPane constellationScrollPane = new JScrollPane(userJList);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        JPanel centeringPanel = new JPanel(new GridBagLayout());
        centeringPanel.add(new JLabel("Usuarios"));
        userPanel.add(centeringPanel, BorderLayout.NORTH);
        userPanel.add(constellationScrollPane, BorderLayout.CENTER);

        JPanel totalUsersPanel = new JPanel();
        JLabel totalUsersLabel = new JLabel("Usuarios: ");
        totalUsers = new JLabel();
        totalUsersPanel.add(totalUsersLabel);
        totalUsersPanel.add(totalUsers);

        userPanel.add(totalUsersPanel, BorderLayout.SOUTH);

        add(userPanel, BorderLayout.WEST);

        userJList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateUI();
            }
        });
    }

    private void updateUI() {
        if (userJList.getSelectedIndex() != -1) {
            User u = userJList.getSelectedValue();
            userInfoPanel.setUser(u);

            ((ChampionTableModel) championTable.getModel()).loadChampions(u.getInventory());
        } else {
            userInfoPanel.clear();
        }
    }

    private void prepareMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        userInfoPanel = new UserInfoPanel();
        mainPanel.add(userInfoPanel, BorderLayout.NORTH);

        championTableModel = new ChampionTableModel();
        championTable = new JTable(championTableModel);
        championTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane= new JScrollPane(championTable);
        mainPanel.add(scrollPane,BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void loadUsers() {
        try {
            int total = 0;

            for (User u : db.getAllUsers()) {
                userListModel.addElement(u);
                total += 1;
            }

            totalUsers.setText(String.valueOf(total));
        } catch (DBException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exit() {
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        exit();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
