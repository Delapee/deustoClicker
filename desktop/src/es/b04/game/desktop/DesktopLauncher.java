package es.b04.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.log.Login;
import es.b04.game.main.MainGame;

public class DesktopLauncher {

	public static void main (String[] arg) throws DBException {
		boolean close = false;
		Login l = new Login();
		DBManager db = new DBManager();
		db.connection("dungeonClicker.db");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("icon/dragon.png", Files.FileType.Classpath);
		config.title = "Dungeon Clicker";
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = true;

		do {
			if (!l.isVisible()){
				close = true;
			}
			System.out.println();
			l.getCheck();
			System.out.println();
		}while (!l.getCheck() && !close);
		l.dispose();

		if (!close){
			new LwjglApplication(new MainGame(), config);
		}
	}
}
