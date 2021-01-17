package es.b04.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.log.Login;
import es.b04.game.main.MainGame;

import javax.swing.*;

public class DesktopLauncher {

	private static final String dbPath = "dungeonClicker.db";

	public static void main (String[] arg) throws DBException {

		DBManager db = new DBManager();
		db.connection(dbPath);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login();
			}
		});

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("icon/dragonMini.png", Files.FileType.Classpath);
		config.title = "Dungeon Clicker";
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = true;

		while (!Login.close);

		if (Login.close){
			new LwjglApplication(new MainGame(), config);
		}
	}
}
