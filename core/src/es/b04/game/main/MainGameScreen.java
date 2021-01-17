package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.character.Champion;
import es.b04.game.character.MapSystem;
import es.b04.game.character.Shop;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.utility.AssetEnum;
import es.b04.game.hud.CEnemy;
import es.b04.game.utility.CustomFont;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;
import es.b04.game.hud.ProgressBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;

public class MainGameScreen extends ScreenAdapter {
    private static DBManager db = new DBManager();
    private SpriteBatch batch;
    private User userL;
    private Stage stage;
    private CEnemy cEnemy;
    private MainGame game;
    private float time = 15.f;
    private float timeAuto = 0.f;
    private float timeExpBoost = 60.f;
    private float timeGoldBoost = 60.f;
    private boolean autoOn;
    private DecimalFormat timeFormat = new DecimalFormat("#.00");
    private BitmapFont fontDung70;
    private BitmapFont fontDung50;
    private final AssetManager assetManager;
    private Texture background;
    private int totalDmg;
    private int levelStage = 1;
    private int fase = 1;
    private final int dmgAvg = 150;
    private final int touchAvg = 4;
    private int faseM = 5 * levelStage;
    private int hpAlgorithm;
    private ProgressBar enemyHpBar;
    private ProgressBar lvlBar;
    private MapSystem map;
    private Shop shop;
    private static final Logger logger = LogManager.getLogger(MainGameScreen.class);
    private IButton autoClicker;


    public MainGameScreen(MainGame game) {
        this.game = game;
        this.assetManager = game.getAssetManager();
        userL = game.getUser();
        hpAlgorithm = (int) (Math.pow((dmgAvg*touchAvg*game.getUser().getLevel() + levelStage),1.05)*faseM);
        autoClicker = new IButton("auto.png", "auto2.png", 1040, 500);

    }

    @Override
    public void show() {
        try {
            db.uptadeAllUserData(userL);
        } catch (DBException e) {
            e.printStackTrace();
        }
        super.show();
        logger.info("Juego contemplado.");
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        cEnemy = new CEnemy("C1.png","C2.png",hpAlgorithm,10,50);
        IButton squadButton = new IButton("boton/b_squadN.png","boton/b_squadP.png",250,
                37, (ScreenAdapter) game.getScreens().get(2), game);
        enemyHpBar = new ProgressBar("hpbar2.png", "hpbar1.png", (float)cEnemy.getMaxhelth(),
                (float)cEnemy.getHealth(), 730, 590, 264, 35);
        lvlBar = new ProgressBar("hpbar2.png", "expbar.png", userL.getExpMax(),
                userL.getExpProgress(), 430, 850, 264, 35);

        IButton salir = new IButton("boton/b_salirN.png","boton/b_salirN.png",1850, 20);

        salir.addListener( new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                try {
                    db.disconnection();
                } catch (DBException e) {
                    e.printStackTrace();
                }
                Gdx.app.exit();
            }

        });

        Gdx.input.setInputProcessor(stage);
        background = assetManager.get(AssetEnum.GAMEBCK.getAsset());
        shop = new Shop(game);
        shop.loadShop(stage, userL);

        stage.addActor(salir);
        stage.addActor(squadButton);
        stage.addActor(cEnemy);
        stage.addActor(autoClicker);



        // Declaracion de las Fuentes
        fontDung70 = new CustomFont(70,255,255,255,3.0f,0,
                2.5f,Color.BLACK).getCustomFont();
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,
                1.5f,Color.BLACK).getCustomFont();
        map = new MapSystem(levelStage, fase, "boss.png", "lvlpointer.png", "lvl.png");

        cEnemy.addListener( new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);

                cEnemy.setHealth(cEnemy.getHealth() - getTotalDmg());

                enemyHp();
            }
        });
        autoClicker.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(userL.getAutoClick() > 0 && !autoOn){
                    timeAuto = 15f;
                    userL.setAutoClick(userL.getAutoClick() -1);
                    autoOn = true;
                }
            }
        });
    }
    public void levelUp(){
        if(userL.getExpProgress() >= userL.getExpMax()){
            userL.setLevel(userL.getLevel() + 1);
            userL.setExpProgress(0);
        }
    }
    public void enemyHp(){
        hpAlgorithm = (int) (Math.pow((dmgAvg*touchAvg*game.getUser().getLevel() + levelStage),1.05)*faseM);
        if(cEnemy.getHealth() <= 0 && levelStage == 6){
            if(shop.isGoldBoost()){
                userL.setGold(userL.getGold() + cEnemy.getGoldDrop()*100*2);
            }
            userL.setGold(userL.getGold() + cEnemy.getGoldDrop()*100);
            if (shop.isExpBoost()){
                userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpDrop()*2);
            }
            userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpDrop());
            fase++;
            cEnemy.setHealth(hpAlgorithm);
            cEnemy.setMaxhelth(hpAlgorithm);
            time = 12f;
            levelStage = 1;
            map = new MapSystem(levelStage, fase, "boss.png", "lvlpointer.png", "lvl.png");
        }
        else if(cEnemy.getHealth() <= 0 && levelStage == 5){
            levelStage++;
            time = 12f;
            if(shop.isGoldBoost()){
                userL.setGold(userL.getGold() + cEnemy.getGoldDrop()*2);
            }
            userL.setGold(userL.getGold() + cEnemy.getGoldDrop());
            if (shop.isExpBoost()){
                userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpDrop()*2);
            }
            userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpDrop());
            cEnemy.setHealth(hpAlgorithm * 2);
            cEnemy.setMaxhelth(hpAlgorithm*2);

        }
        else if (cEnemy.getHealth() <= 0){
            if(shop.isGoldBoost()){
                userL.setGold(userL.getGold() + cEnemy.getGoldDrop()*2);
            }
            userL.setGold(userL.getGold() + cEnemy.getGoldDrop());
            if (shop.isExpBoost()){
                userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpDrop()*2);
            }
            userL.setExpProgress(userL.getExpProgress() + cEnemy.getExpDrop());
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
    public void autoClickAction(){
        timeAuto -= Gdx.graphics.getRawDeltaTime();
        cEnemy.setHealth(cEnemy.getHealth() - getTotalDmg());
        enemyHp();
        if(timeAuto <= 0){
            timeAuto = 0;
            autoOn = false;
        }
    }
    public void expBoostTimer(){
        timeExpBoost -= Gdx.graphics.getRawDeltaTime();
        if(timeExpBoost  <= 0){
            timeExpBoost  = 60;
            shop.setExpBoost(false);
        }
    }
    public void goldBoostTimer(){
        timeGoldBoost -= Gdx.graphics.getRawDeltaTime();
        if(timeGoldBoost <= 0){
            timeGoldBoost  = 60;
            shop.setGoldBoost(false);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        clearScreen();
        levelUp();
        timer();
        if(autoOn){
            autoClickAction();
        }
        if(shop.isExpBoost()){
            expBoostTimer();
        }
        if(shop.isGoldBoost()){
            goldBoostTimer();
        }
        batch.begin();
        renderText();
        stage.draw();
        renderSquad();
        enemyHpBar.draw(batch, cEnemy.getHealth(), cEnemy.getMaxhelth());
        lvlBar.draw(batch, userL.getExpProgress(),userL.getExpMax());
        map.draw(batch, levelStage);
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
        fontDung70.draw(batch,timeFormat.format(time),1289,1010);
        fontDung70.draw(batch,timeFormat.format(timeAuto),1289,950);
        fontDung70.draw(batch,timeFormat.format(timeExpBoost),750,950);
        fontDung70.draw(batch,timeFormat.format(timeGoldBoost),750,1000);
        // Clicker
        fontDung70.draw(batch,Integer.toString(cEnemy.getHealth()),730,550);
        fontDung70.draw(batch,fase +"-"+levelStage,738,800);
    }


    public void renderSquad(){
        int countX = 0;
        for(Champion c : userL.getSquad()){
            batch.draw(new Texture(c.getTexture().get(0)), 100 + countX, 160);
            countX += 170;
        }
    }

    public int getTotalDmg(){
        totalDmg = 0;
        for(Champion c : userL.getSquad()){
            totalDmg += c.getDmg();
        }
        return totalDmg;
    }
}
