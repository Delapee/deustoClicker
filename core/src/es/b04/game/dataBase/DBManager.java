package es.b04.game.dataBase;


import es.b04.game.log.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection conn;

    public void connection(String  db) throws DBException{
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + db);
        } catch (ClassNotFoundException e) {
            throw new DBException("No se pudo cargar el driver de la base de datos", e);
        } catch (SQLException e) {
            throw new DBException("No se pudo conectar la base de datos", e);
        }
    }

    public void disconnection() throws DBException{
        try {
            conn.close();
        } catch (SQLException e) {
            throw new DBException("No se pudo desconectar la base de datos", e);
        }
    }

    public void storeNewUser(User u) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (id, name, pass, email, gender, " +
                "age, level, expMax, expProgress, gold, autoClick, icon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")){

            stmt.setString(1, u.getId());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getPass());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getGender());
            stmt.setInt(6, u.getAge());
            stmt.setInt(7, u.getLevel());
            stmt.setInt(8, u.getExpMax());
            stmt.setInt(9, u.getExpProgress());
            stmt.setInt(10, u.getGold());
            stmt.setInt(11, u.getAutoClick());
            stmt.setString(12, u.getIcon());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("No se pudo guardar el usuario en la base de datos", e);
        }
    }

    public List<String> getAllUserNames() throws DBException{
        List<String> usersNames = new ArrayList<String>();

        try (Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT name FROM user");

            while (rs.next()) {
                usersNames.add(rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new DBException("Error al obtener los nombres de usuarios de la base de datos", e);
        }

        return usersNames;
    }

    public User getLoginUser(String name, String pass){


        return new User();
    }

    public void deleteUser(User u) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id=?")) {
            stmt.setString(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Error al eliminar un usuario de la base de datos", e);
        }
    }

    public void updateUser(User u) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE user SET name=?, pass=?, email=?, gender=?, " +
                "age=?, level=?, expMax=?, expProgress=?, gold=?, autoClick=?, icon=? WHERE id=?")) {

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPass());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getGender());
            stmt.setInt(5, u.getAge());
            stmt.setInt(6, u.getLevel());
            stmt.setInt(7, u.getExpMax());
            stmt.setInt(8, u.getExpProgress());
            stmt.setInt(9, u.getGold());
            stmt.setInt(10, u.getAutoClick());
            stmt.setString(11, u.getIcon());

            stmt.setString(12, u.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("No se pudo actualizar el usuario en la base de datos", e);
        }
    }



}
