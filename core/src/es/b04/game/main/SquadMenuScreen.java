package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.utility.AssetEnum;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;

public class SquadMenuScreen extends ScreenAdapter {
    private Texture tittleBackground;
    private SpriteBatch Batch;
    private final MainGame game;
    private final AssetManager assetManager;
    private Stage stage;
    private User userl;

    public SquadMenuScreen(MainGame game) {
        super();
        this.game = game;
        this.assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        super.show();

        tittleBackground = new Texture("BackgroundSquad.png");
        Batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        userl = game.getUser();

        IButton acept = new IButton("B1.png","B2.png",53,
                195, (ScreenAdapter) game.getScreens().get(0), game);

        IButton equip = new IButton("B1.png","B2.png",1490, 280);
        IButton upgrade = new IButton("B1.png","B2.png",1490, 195);

        Gdx.input.setInputProcessor(stage);
        stage.addActor(acept);
        stage.addActor(equip);
        stage.addActor(upgrade);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Batch.begin();
        Batch.draw(tittleBackground, 0, 0);
        renderChampions();
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

    // Metodos de Renderizacion
    public void renderChampions(){

        // Renderizado del Squad
        Batch.draw((Texture) assetManager.get(AssetEnum.PIRATE.getAsset()),70,530);
        Batch.draw(new Texture("pirate.png"),255,530);
        Batch.draw(new Texture("pirate.png"),70,297);
        Batch.draw(new Texture("pirate.png"),255,297);

        // Rendereizado del Inventario

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                Batch.draw(new Texture("pirate.png"),488 + 196*j,646 - 244*i);
            }
        }

    }

}
