package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.hud.CEnemy;
import es.b04.game.hud.CustomFont;
import es.b04.game.log.User;

public class MainGameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Texture img;
    private User userL;
    private Stage stage;
    private CEnemy cEnemy;

    private BitmapFont fontDung70;
    private BitmapFont fontDung50;


    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("backgroundOp.png");
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        Gdx.input.setInputProcessor(stage);

        cEnemy = new CEnemy("C1.png","C2.png",10,10,50);
        stage.addActor(cEnemy);


        cEnemy.addListener( new ActorGestureListener(){

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);

                cEnemy.setHealth(cEnemy.getHealth() - 1);

                if (cEnemy.getHealth() == 0){
                    userL.setGold(userL.getGold() + cEnemy.getGoldXClick());
                    userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpXClick());
                }

            }
        });


        // User de Prueba
        userL = new User();
        userL.setName("UserPrueba");
        userL.setGold(8000000);
        userL.setLevel(1);
        userL.setExpMax(10000);
        userL.setExpProgress(200);

        // Declaracion de las Fuentes
        fontDung70 = new CustomFont(70,255,255,255,3.0f,0,2.5f,Color.BLACK).getCustomFont();
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,1.5f,Color.BLACK).getCustomFont();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        clearScreen();

        batch.begin();

        renderText();
        checkClicker();


        stage.act(delta);
        stage.draw();
        batch.end();

    }
    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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


    // Metodos de Renderizado
    public void renderText(){

        //Fondo
        batch.draw(img, 0, 0);

        //User
        fontDung70.draw(batch,userL.getName(),430,1005);
        fontDung70.draw(batch,Integer.toString(userL.getGold()),430,943);
        if (userL.getLevel() >= 10){
            fontDung50.draw(batch,Integer.toString(userL.getLevel()),364,877);
        }else{
            fontDung50.draw(batch,Integer.toString(userL.getLevel()),376,877);
        }
        fontDung70.draw(batch,userL.getExpProgress() + "/" + userL.getExpMax(),430,877);

        // Clicker
        fontDung70.draw(batch,Integer.toString(cEnemy.getHealth()),730,550);


    }

    // Controlar el clicker
    public void checkClicker(){

        if (cEnemy.getHealth() == 0){

            cEnemy = new CEnemy("C1.png","C2.png",cEnemy.getMaxhelth() + 10,cEnemy.getGoldXClick() + 10,cEnemy.getExpXClick() + 10);

        }


    }

}
