package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class MainGame extends Game {
	private static OrthographicCamera camera;
	private Vector3 mousePosition;



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

		//Skin personalizada del raton
		Pixmap pixmap = new Pixmap(Gdx.files.internal("cursor.png"));
		Cursor cursor = Gdx.graphics.newCursor(pixmap, 0, 0);
		Gdx.graphics.setCursor(cursor);

		//Trakeo de la possicion del raton
		camera.update();
		mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		MainGame.camera.unproject(mousePosition);
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


		mousePosition = new Vector3();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

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
