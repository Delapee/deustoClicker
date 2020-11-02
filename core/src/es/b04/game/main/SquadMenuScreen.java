package es.b04.game.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class SquadMenuScreen extends ScreenAdapter {
    private Texture tittleBackground;
    private SpriteBatch Batch;
    private final Game game;
    private Stage stage;

    public SquadMenuScreen(Game game) {
        super();
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        tittleBackground = new Texture("BackgroundSquad.png");
        Batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);



    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Batch.begin();
        Batch.draw(tittleBackground, 0, 0);
        Batch.end();



        stage.act(delta);
        stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }



    @Override
    public void hide() {
        super.hide();
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
    public void dispose() {
        super.dispose();
    }
}
