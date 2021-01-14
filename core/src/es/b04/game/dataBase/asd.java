package es.b04.game.dataBase;

import java.util.UUID;

public class asd {

    public static void main(String[] args) throws DBException {
        DBManager db = new DBManager();
        /*String en = db.encode("admin");
        System.out.println(en);
        System.out.println(db.decode(en));*/
        db.connection("dungeonClicker.db");


        System.out.println(db.getChampionDrop("Pirata", 3));
        //System.out.println(db.getUser("asdas"));

        /*for (int i = 0; i < 16; i++) {
            System.out.println(UUID.randomUUID().toString());
        }*/
    }
}
