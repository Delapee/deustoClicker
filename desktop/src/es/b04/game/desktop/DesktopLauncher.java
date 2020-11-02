package es.b04.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import es.b04.game.log.Login;
import es.b04.game.main.MainGame;
import es.b04.game.log.Register;

import javax.swing.*;

public class DesktopLauncher {
	private static Login l;

	public static void main (String[] arg) {

		l = new Login();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("asdf.png", Files.FileType.Classpath);
		config.title = "deustoClicker";
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = true;


		do {
			l.getCheck();

		}while (!l.getCheck() );
			new LwjglApplication(new MainGame(), config);

	}
}
