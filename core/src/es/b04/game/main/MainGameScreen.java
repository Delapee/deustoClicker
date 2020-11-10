package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.character.Champion;
import es.b04.game.utility.AssetEnum;
import es.b04.game.hud.CEnemy;
import es.b04.game.utility.CustomFont;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;
import es.b04.game.hud.ProgressBar;

import java.text.DecimalFormat;

public class MainGameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private User userL;
    private Stage stage;
    private CEnemy cEnemy;
    private MainGame game;
    private float time = 15.f;
    private DecimalFormat timeFormat = new DecimalFormat("#.00");
    private BitmapFont fontDung70;
    private BitmapFont fontDung50;
    private final AssetManager assetManager;
    private Texture background;
    private int totalDmg;
    private int levelStage = 1;
    private int fase = 1;
    private final int dmgAvg = 150;
    private final int touchAvg = 7;
    private int faseM = 5 * levelStage;
    private int hpAlgorithm;
    private ProgressBar enemyHpBar;

    public MainGameScreen(MainGame game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
        userL = game.getUser();
        userL.setLevel(4);
        hpAlgorithm = (dmgAvg*touchAvg*game.getUser().getLevel() + levelStage)*faseM;
    }

    @Override
    public void show() {
        super.show();
        //Texture hpbarMod = new Texture("hpbar1.png");
        //hpbarBack = new Texture("hpbar2.png");
        //hpbar = new NinePatch(new TextureRegion(hpbarMod,264, 35));
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        cEnemy = new CEnemy("C1.png","C2.png",hpAlgorithm,10,50);
        IButton squadButton = new IButton("B1.png","B2.png",280,
                37, (ScreenAdapter) game.getScreens().get(2), game);
        enemyHpBar = new ProgressBar("hpbar2.png", "hpbar1.png", (float)cEnemy.getMaxhelth(),
                (float)cEnemy.getHealth(), 730, 590, 264, 35);
        Gdx.input.setInputProcessor(stage);
        background = assetManager.get(AssetEnum.GAMEBCK.getAsset());

        stage.addActor(squadButton);
        stage.addActor(cEnemy);

        // Declaracion de las Fuentes
        fontDung70 = new CustomFont(70,255,255,255,3.0f,0,
                2.5f,Color.BLACK).getCustomFont();
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,
                1.5f,Color.BLACK).getCustomFont();

        cEnemy.addListener( new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);

                cEnemy.setHealth(cEnemy.getHealth() - getTotalDmg());
                System.out.println(getTotalDmg());

                enemyHp();
            }
        });

    }

    public void enemyHp(){
        hpAlgorithm = (dmgAvg*touchAvg + levelStage)*faseM;
        if(cEnemy.getHealth() <= 0 && levelStage == 6){
            userL.setGold(userL.getGold() + cEnemy.getGoldXClick()*100);
            userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpXClick());
            fase++;
            cEnemy.setHealth(hpAlgorithm);
            cEnemy.setMaxhelth(hpAlgorithm);
            time = 12f;
            levelStage = 1;
        }
        else if(cEnemy.getHealth() <= 0 && levelStage == 5){
            levelStage++;
            time = 12f;
            userL.setGold(userL.getGold() + cEnemy.getGoldXClick());
            userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpXClick());
            cEnemy.setHealth(hpAlgorithm * 2);
            cEnemy.setMaxhelth(hpAlgorithm*2);
        }
        else if (cEnemy.getHealth() <= 0){
            userL.setGold(userL.getGold() + cEnemy.getGoldXClick());
            userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpXClick());
            cEnemy.setHealth(hpAlgorithm);
            cEnemy.setMaxhelth(hpAlgorithm);
            time = 12f;
            levelStage ++;
        }
    }
    public void timer(){
        time -= Gdx.graphics.getRawDeltaTime();
        if(time < 0 ){
            time = 12f;
            levelStage = 1;
            cEnemy.setHealth(hpAlgorithm);
            cEnemy.setMaxhelth(hpAlgorithm);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        clearScreen();
        timer();
        batch.begin();
        renderText();
        stage.draw();
        enemyHpBar.draw(batch, cEnemy.getHealth(), cEnemy.getMaxhelth());
        System.out.println(enemyHpBar.comp());
        //finalHpBar.draw(batch);
       // batch.draw(hpbarBack, 730, 580);
      //  hpbar.draw(batch, 730, 580, ((float)cEnemy.getHealth()/(float)cEnemy.getMaxhelth()) *264, 35);

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
        batch.draw(background, 0, 0);

        //User
        fontDung70.draw(batch,userL.getName(),430,1005);
        fontDung70.draw(batch,Integer.toString(userL.getGold()),430,943);
        if (userL.getLevel() >= 10){
            fontDung50.draw(batch,Integer.toString(userL.getLevel()),364,877);
        }else{
            fontDung50.draw(batch,Integer.toString(userL.getLevel()),376,877);
        }
        fontDung70.draw(batch,userL.getExpProgress() + "/" + userL.getExpMax(),430,877);
        fontDung70.draw(batch,timeFormat.format(time),1289,1010);

        // Clicker
        fontDung70.draw(batch,Integer.toString(cEnemy.getHealth()),730,550);
        fontDung70.draw(batch,fase +"-"+levelStage,738,800);
    }
    public int getTotalDmg(){
        totalDmg = 0;
        for(Champion c : userL.getSquad()){
            totalDmg += c.getDmg();
            System.out.println(totalDmg);
        }
        return totalDmg;
    }
}
