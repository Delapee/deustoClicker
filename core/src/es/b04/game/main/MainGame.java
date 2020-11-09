package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import es.b04.game.character.Champion;
import es.b04.game.utility.CustomMouse;
import es.b04.game.log.User;

import java.util.ArrayList;
import java.util.List;

public class MainGame extends Game {
	private CustomMouse customMouse;
	private final AssetManager assetManager = new AssetManager();
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
		customMouse = new CustomMouse("cursor.png");
		user = new User();
		loadUserA();
		this.setScreen(new GameMenuScreen(this));
		screens = new ArrayList<>();
		MainGameScreen gameScreen = new MainGameScreen(this);
		GameMenuScreen menuScreen = new GameMenuScreen(this);
		SquadMenuScreen squadScreen = new SquadMenuScreen(this);
		screens.add(gameScreen);
		screens.add(menuScreen);
		screens.add(squadScreen);

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

		ArrayList<String> sChampion = new ArrayList<>();
		sChampion.add("pirate.png");
		sChampion.add("pirate.png");

		Champion c1 = new Champion(sChampion,"El PIRATA",1,1,100,0.7,0.5,0.3,0.5,null,null,false);
		Champion c2 = new Champion(sChampion,"El PERRATA",2,1,120,1.7,1.5,5.3,3.5,null,null,false);
		Champion c3 = new Champion(sChampion,"El TONTITO",1,1,100,2.7,1.5,2.3,1.5,null,null,false);
		Champion c4 = new Champion(sChampion,"El CURATOR",2,1,120,3.7,1.5,1.3,2.5,null,null,false);
		Champion c5 = new Champion(sChampion,"El PINOS",1,1,100,4.7,2.5,3.3,1.3,null,null,false);

		ArrayList<Champion> invent = new ArrayList<>();
		invent.add(c1);
		invent.add(c2);
		invent.add(c3);
		invent.add(c4);
		invent.add(c5);

		user.setInventory(invent);

	}

}
