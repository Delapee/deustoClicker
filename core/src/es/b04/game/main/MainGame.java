package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import es.b04.game.character.Champion;
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
		user.setLevel(60);
		user.setExpMax(1000);
		user.setExpProgress(500);

		ArrayList<String> sPirate = new ArrayList<>();
		sPirate.add("champ/pira/pira_n.png");
		sPirate.add("champ/pira/pira_p.png");
		sPirate.add("champ/pira/pira_f.png");

		ArrayList<String> sMed = new ArrayList<>();
		sMed.add("champ/med/med_n.png");
		sMed.add("champ/med/med_p.png");
		sMed.add("champ/med/med_f.png");

		ArrayList<String> sWar = new ArrayList<>();
		sWar.add("champ/war/war_n.png");
		sWar.add("champ/war/war_p.png");
		sWar.add("champ/war/war_f.png");

		Champion c1 = new Champion(sPirate,"El PIRATA",1,1,100,10,15,33,15,null,null,false);
		Champion c2 = new Champion(sWar,"El PERRATA",2,1,120,12,25,43,25,null,null,false);
		Champion c3 = new Champion(sWar,"El TONTITO",1,1,100,21,25,13,35,null,null,false);
		Champion c4 = new Champion(sMed,"El CURATOR",2,1,120,33,45,23,45,null,null,false);
		Champion c5 = new Champion(sMed,"El PINOS",1,1,100,41,15,33,13,null,null,false);

		ArrayList<Champion> invent = new ArrayList<>();
		invent.add(c1);
		invent.add(c2);
		invent.add(c3);
		invent.add(c4);
		invent.add(c5);

		user.setInventory(invent);
		logger.info("user cargado");

	}

}
