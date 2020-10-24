package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainGameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private static final int GRID_CELL = 32;
    private ShapeRenderer shapeRenderer;

    public void drawGrid(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (int x = 0; x < Gdx.graphics.getWidth(); x += GRID_CELL) {
            for (int y = 0; y < Gdx.graphics.getHeight(); y += GRID_CELL) {
                shapeRenderer.rect(x,y, GRID_CELL, GRID_CELL);
            }
        }
        shapeRenderer.end();
    }

    @Override
    public void show() {
        super.show();
    }



    @Override
    public void render(float delta) {

    }
}
