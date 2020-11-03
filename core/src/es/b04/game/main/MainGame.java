package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import es.b04.game.character.Champion;
import es.b04.game.utility.CustomMouse;
import es.b04.game.log.User;

import java.util.ArrayList;

public class MainGame extends Game {
	private CustomMouse customMouse;
	private final AssetManager assetManager = new AssetManager();
	private User user;

	public AssetManager getAssetManager() {
		return assetManager;
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
		customMouse.getMousePosition();
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
		customMouse = new CustomMouse("cursor.png");
		user = new User();
		loadUserA();
		this.setScreen(new GameMenuScreen(this));

	}


	public User getUser() {
		return user;
	}

	// CARGAR USER PRUEBA
	public void loadUserA(){
		user.setName("UserPrueba");
		user.setGold(8000000);
		user.setLevel(1);
		user.setExpMax(10000);
		user.setExpProgress(200);

		Champion c1 = new Champion();
		Champion c2 = new Champion();
		Champion c3 = new Champion();
		Champion c4 = new Champion();

		ArrayList<Champion> squad = new ArrayList<>();
		squad.add(c1);
		squad.add(c2);
		squad.add(c3);
		squad.add(c4);

		user.setSquad(squad);

	}

}
