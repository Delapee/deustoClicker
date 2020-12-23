package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.hud.IButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameMenuScreen extends ScreenAdapter {
    private Texture tittleBackground;
    private SpriteBatch menuBatch;
    private final MainGame mainGame;
    private static final Logger logger = LogManager.getLogger(GameMenuScreen.class);
    private Stage stage;

    public GameMenuScreen(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    @Override
    public void show() {
        super.show();

        tittleBackground = new Texture("mainTittle.png");
        menuBatch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        IButton play = new IButton("B1.png","B2.png",Gdx.graphics.getWidth() / 2f,
                Gdx.graphics.getHeight() / 4f,Align.center, new LoadingScreen(mainGame), mainGame);
        IButton salir = new IButton("B1.png","B2.png",Gdx.graphics.getWidth() /
                2f, Gdx.graphics.getHeight() / 6f,Align.center);

        salir.addListener( new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                Gdx.app.exit();
            }

        });
        logger.info("Menu cargado correctamente.");
        stage.addActor(play);
        stage.addActor(salir);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuBatch.begin();
        menuBatch.draw(tittleBackground, 0, 0);
        menuBatch.end();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);

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
