package es.b04.game.dataBase;


import es.b04.game.character.Attack;
import es.b04.game.character.Champion;
import es.b04.game.log.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection conn;

    /**
     * Metodo de conecxión a la BD
     * @param db direción de la BD
     * @throws DBException gestor de excepciones de la la BD
     */
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

    /**
     * Metodo de desconecxión de la BD
     * @throws DBException gestor de excepciones de la la BD
     */
    public void disconnection() throws DBException{
        try {
            conn.close();
        } catch (SQLException e) {
            throw new DBException("No se pudo desconectar la base de datos", e);
        }
    }

    /**
     * Metodo que guarda usuarios recien registrados
     * @param u usuario recien creado
     * @throws DBException gestor de excepciones de la la BD
     */
    public void storeNewUser(User u) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (id, name, pass, email, gender, " +
                "age, icon) VALUES (?, ?, ?, ?, ?, ?, ?)")){

            stmt.setString(1, u.getId());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getPass());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getGender());
            stmt.setInt(6, u.getAge());
            stmt.setString(7, u.getIcon());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("No se pudo guardar el usuario en la base de datos", e);
        }
    }

    /**
     * Metodo que actuliza la informacion del User
     * @param u User que se desea actualizar
     * @throws DBException gestor de excepciones de la la BD
     */
    public void updateUser(User u) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE user SET name=?, pass=?, email=?, gender=?, " +
                "age=?, level=?, expMax=?, expProgress=?, gold=?, autoClick=?, icon=?, stage=?, stageLevel=?" +
                " WHERE id=?")) {

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
            stmt.setInt(12, u.getStage());
            stmt.setInt(13, u.getStageLevel());

            stmt.setString(14, u.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("No se pudo actualizar el usuario en la base de datos", e);
        }
    }

    /**
     * Metodo de guardado de un nuevo Champion
     * @param c Champion a guadar
     * @param idUser id del User a quien pertence el Champion
     * @throws DBException gestor de excepciones de la la BD
     */
    public void storeNewChampion(Champion c, String idUser) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO champion (id, name, levelMax, " +
                "rare, dmg, accuracy, attackSpeed, criticProb, dodgeProb, attackP_id, attackS_id, onSquad," +
                "id_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")){

            stmt.setString(1, c.getId());
            stmt.setString(2, c.getName());
            stmt.setInt(3, c.getLevelMax());
            stmt.setInt(4, c.getRare());
            stmt.setInt(5, c.getDmg());
            stmt.setDouble(6, c.getAccuracy());
            stmt.setDouble(7, c.getAttackSpeed());
            stmt.setDouble(8, c.getCriticProb());
            stmt.setDouble(9, c.getDodgeProb());
            stmt.setString(10, c.getAttackP().getId());
            stmt.setString(11, c.getAttackS().getId());
            stmt.setBoolean(12, c.isOnSquad());
            stmt.setString(13, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("No se pudo guardar el campeon en la base de datos", e);
        }
    }

    /**
     * Metodo que actualiza la informacion del Champion
     * @param c Champion a actualizar
     * @param idUser id del User a quien pertence el Champion
     * @throws DBException gestor de excepciones de la la BD
     */
    public void updateChampion(Champion c, String idUser) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE champion SET level=?, dmg=?, accuracy=?, " +
                "attackSpeed=?, criticProb=?, dodgeProb=?, onSquad=? WHERE id=? and id_user=?")) {

            stmt.setInt(1, c.getLevel());
            stmt.setInt(2, c.getDmg());
            stmt.setDouble(3, c.getAccuracy());
            stmt.setDouble(4, c.getAttackSpeed());
            stmt.setDouble(5, c.getCriticProb());
            stmt.setDouble(6, c.getDodgeProb());
            stmt.setBoolean(7, c.isOnSquad());

            stmt.setString(8, c.getId());
            stmt.setString(9, idUser);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("No se pudo actualizar el campeon en la base de datos", e);
        }
    }

    public Champion getNewChampion(){
        return new Champion();
    }

    /**
     * Metodo que actualiza todos los datos del usuario incluido el inventario(Champion)
     * @param u User del que se desea actualizar la información
     * @throws DBException gestor de excepciones de la la BD
     */
    public void uptadeAllUserData(User u) throws DBException {
        updateUser(u);
        for (Champion c: u.getInventory()) {
            updateChampion(c, u.getId());
        }
    }

    /**
     * Metodo que devuelve una lista con el nombre de todos los usuarios guardados
     * @return Lista de Strings
     * @throws DBException gestor de excepciones de la la BD
     */

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

    /**
     * Metodo que elimina toda la informacion relacionada con el User
     * @param u User que se desea eliminar
     * @throws DBException gestor de excepciones de la la BD
     */
    public void deleteUser(User u) throws DBException{
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id=?")) {
            stmt.setString(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Error al eliminar un usuario de la base de datos", e);
        }
    }

    /**
     * Metodo que extrae toda la info de un usuario de la BD
     * @param name nombre de usuario
     * @return User logeado
     * @throws DBException gestor de excepciones de la la BD
     */
    public User getUser(String name) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE name=?")) {
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            User user = new User(rs.getString("id"), rs.getString("name"),
                    rs.getString("pass"), rs.getString("email"),rs.getString("gender"),
                    rs.getInt("age"), rs.getInt("level"), rs.getInt("expMax"),
                    rs.getInt("expProgress"), rs.getInt("gold"), rs.getInt("autoClick"),
                    rs.getString("icon"), new ArrayList<Champion>(), new ArrayList<Champion>(),
                    rs.getInt("stage"), rs.getInt("stageLevel"));

            List<List<Champion>> champions = getUserChampions(user.getId());
            user.setSquad(champions.get(0));
            user.setInventory(champions.get(1));

            return user;
        } catch (SQLException e) {
            throw new DBException("Error obteniendo el usuario", e);
        }
    }

    /**
     * Metodo que extrae todos los champions de un usuario de la BD
     * @param id_user id del usuario del que se quiere obtener los champions
     * @return lista con la lista squad y la lista inventory
     * @throws DBException Metodo que extrae toda la info de un usuario de la BD
     */
    public List<List<Champion>> getUserChampions(String id_user) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM champion WHERE id_user=?")) {
            stmt.setString(1, id_user);

            ResultSet rs = stmt.executeQuery();

            List<List<Champion>> champions = new ArrayList<>();
            List<Champion> squad = new ArrayList<>();
            List<Champion> inventory = new ArrayList<>();

            while(rs.next()) {
                Champion champ = new Champion(rs.getString("id"), new ArrayList<String>(),
                        rs.getString("name"), rs.getInt("level"),
                        rs.getInt("rare"), rs.getInt("dmg"), rs.getInt("accuracy"),
                        rs.getInt("attackSpeed"), rs.getInt("criticProb"),
                        rs.getInt("dodgeProb"), new Attack(), new Attack(), rs.getBoolean("onSquad"));

                inventory.add(champ);

                if (champ.isOnSquad()){
                    squad.add(champ);
                }
            }

            champions.add(squad);
            champions.add(inventory);

            return champions;
        } catch (SQLException e) {
            throw new DBException("Error obteniendo el usuario", e);
        }
    }

    public Champion getChampion(String id, String name) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM champion WHERE id=? and name=?")) {
            stmt.setString(1, id);
            stmt.setString(2, name);

            ResultSet rs = stmt.executeQuery();

            Champion champ = new Champion(rs.getString("id"), new ArrayList<String>(),
                    rs.getString("name"), rs.getInt("level"), rs.getInt("rare"),
                    rs.getInt("dmg"), rs.getInt("accuracy"), rs.getInt("attackSpeed"),
                    rs.getInt("criticProb"), rs.getInt("dodgeProb"), new Attack(), new Attack(),
                    rs.getBoolean("onSquad"));

            return champ;
        } catch (SQLException e) {
            throw new DBException("Error obteniendo el usuario", e);
        }
    }

    public Boolean isPassOk(String name, String pass) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT pass FROM user WHERE name=?")) {
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            if(pass.equals(rs.getString("pass"))){
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new DBException("Error obteniendo el usuario", e);
        }
    }
}
