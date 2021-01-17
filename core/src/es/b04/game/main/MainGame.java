package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import es.b04.game.character.Champion;
import es.b04.game.log.Login;
import es.b04.game.utility.CustomMouse;
import es.b04.game.log.User;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainGame extends Game {
	private CustomMouse customMouse;
	private final AssetManager assetManager = new AssetManager();
	private static final Logger logger = LogManager.getLogger(MainGame.class);
	private User user;
	private List<Screen> screens;

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void render() {
		super.render();
		customMouse.mouseAct();
		customMouse.getMousePosition();

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		return super.getScreen();
	}

	@Override
	public void create() {
		logger.debug("debug");
		logger.info("Juego creado");
		customMouse = new CustomMouse("cursor.png");
		user = new User(Login.userPlaying);
		logger.info("user cargado");
		this.setScreen(new GameMenuScreen(this));
		screens = new ArrayList<>();
		MainGameScreen gameScreen = new MainGameScreen(this);
		GameMenuScreen menuScreen = new GameMenuScreen(this);
		Raid raidScreen = new Raid(this);
		SquadMenuScreen squadScreen = new SquadMenuScreen(this);

		screens.add(gameScreen);
		screens.add(menuScreen);
		screens.add(squadScreen);
		screens.add(raidScreen);

	}


	public User getUser() {
		return user;
	}
}
