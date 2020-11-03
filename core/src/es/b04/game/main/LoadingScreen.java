package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import es.b04.game.utility.AssetEnum;

public class LoadingScreen extends ScreenAdapter {
    private static final float WORLD_WIDTH = Gdx.graphics.getWidth();
    private static final float WORLD_HEIGHT = Gdx.graphics.getHeight();
    private static final float PROGRESS_BAR_WIDTH = 400;
    private static final float PROGRESS_BAR_HEIGHT = 25;
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private Camera camera;
    private float progress = 0;
    private final MainGame game;

    public LoadingScreen(MainGame game) {
        super();
        this.game = game;

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        clearScreen();
        draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);
    }

    @Override
    public void show() {
        super.show();
        camera = new OrthographicCamera();
        camera.position.set(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, 0);
        camera.update();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();

        game.getAssetManager().load(AssetEnum.PLAY1.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.PLAY2.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.GAMEBCK.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.SQUADBCK.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.CENEMY1.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.CENEMY2.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.CURSOR.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.MAINTITTLE.getAsset(), Texture.class);
        game.getAssetManager().load(AssetEnum.PIRATE.getAsset(), Texture.class);
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
        shapeRenderer.dispose();
    }
    private void draw() {
        shapeRenderer.setProjectionMatrix(camera.projection);
        shapeRenderer.setTransformMatrix(camera.view);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect((WORLD_WIDTH - PROGRESS_BAR_WIDTH) / 2, (WORLD_HEIGHT - PROGRESS_BAR_HEIGHT / 2),
                progress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
        shapeRenderer.end();
    }
    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g,
                Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void update() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (game.getAssetManager().update()) {
            game.setScreen(new MainGameScreen(game));
        } else {
            progress = game.getAssetManager().getProgress();
        }
    }



}
