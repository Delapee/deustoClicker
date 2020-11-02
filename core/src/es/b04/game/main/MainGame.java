package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import es.b04.game.hud.CustomMouse;

public class MainGame extends Game {
	private CustomMouse customMouse;
	private final AssetManager assetManager = new AssetManager();

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
		this.setScreen(new GameMenuScreen(this));

	}

	public Vector2 getMousePosition(){
		return new Vector2(Gdx.input.getX(), Gdx.input.getY());
	}

	public float getMousePositionX(){
		return Gdx.input.getX();
	}

	public float getMousePositionY(){
		return Gdx.input.getY();
	}
}
