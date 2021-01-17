package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.character.Champion;
import es.b04.game.hud.IButton;
import es.b04.game.hud.ProgressBar;
import es.b04.game.log.User;
import es.b04.game.utility.AssetEnum;
import es.b04.game.utility.CustomFont;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Raid extends ScreenAdapter {
    private MainGame game;
    private SpriteBatch batch;
    private Stage stage;
    private ProgressBar lvlBar;
    private User userL;
    private Texture background;
    private BitmapFont fontDung70;
    private BitmapFont fontDung50;
    private AssetManager assetManager;
    private int totalDmg;
    private int raidLevel;
    private int totalRaidHp;
    private float leftProgess;
    private float rightProgress;
    private float upProgress;
    private float bottonLeft;
    private float bottonRight;
    private float raidTime = 20.f;
    private ProgressBar eBLeft;
    private ProgressBar eBRight;
    private ProgressBar eBUp;
    private ProgressBar eBLeftBot;
    private ProgressBar eBRightBot;
    private boolean mercenarioUlt;
    private boolean pesteUlt;
    private boolean magoUlt;
    private boolean pirataUlt;
    private float dmgBoost;
    private IButton exitRaid;
    private DecimalFormat timeFormat = new DecimalFormat("#.00");
    private static final Logger logger = LogManager.getLogger(Raid.class);

    public Raid(MainGame game){
        this.game = game;
        this.assetManager = game.getAssetManager();
        this.userL = game.getUser();

    }
    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        totalRaidHp = 10000 * userL.getRaidLevel();
        enemy();
        lvlBar = new ProgressBar("hpbar2.png", "expbar.png", userL.getExpMax(),
                userL.getExpProgress(), 430, 850, 264, 35);
        Gdx.input.setInputProcessor(stage);
        exitRaid = new IButton("auto.png", "auto2.png", 1850, 200);
        stage.addActor(exitRaid);
        background = assetManager.get(AssetEnum.RAIDBCK.getAsset());
        fontDung70 = new CustomFont(70,255,255,255,3.0f,0,
                2.5f,Color.BLACK).getCustomFont();
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,
                1.5f,Color.BLACK).getCustomFont();
        team();
        dmgBoost = 10.f;
        raidLevel = userL.getRaidLevel();
        getTotalDmg();
        leftProgess = totalRaidHp/5;
        rightProgress = totalRaidHp/5;
        upProgress = totalRaidHp/5;
        bottonLeft = totalRaidHp/5;
        bottonRight = totalRaidHp/5;
        logger.info("Modo raid iniciado");
        exitRaid.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                game.setScreen(game.getScreens().get(0));
                raidTime = 20.f;
                mercenarioUlt = false;
                pesteUlt = false;
                magoUlt = false;
                pirataUlt = false;
            }
        });
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        clearScreen();
        timer();
        batch.begin();
        renderText();
        eBRight.draw(batch, rightProgress, totalRaidHp/5);
        eBLeft.draw(batch, leftProgess, totalRaidHp/5);
        eBUp.draw(batch, upProgress, totalRaidHp/5);
        eBLeftBot.draw(batch, bottonLeft, totalRaidHp/5);
        eBRightBot.draw(batch, bottonRight, totalRaidHp/5);
        stage.draw();
        endRaid();
        lvlBar.draw(batch, userL.getExpProgress(),userL.getExpMax());

        batch.end();
    }
    public void renderText(){
        //Fondo
        batch.draw(background, 0, 0);

        //User
        fontDung70.draw(batch,userL.getName(),430,1005);
        fontDung70.draw(batch,Integer.toString(userL.getGold()),430,943);
        fontDung70.draw(batch,Integer.toString(userL.getRaidLevel()),1670,1020);
        fontDung70.draw(batch,timeFormat.format(raidTime),990,1000);
        if (userL.getLevel() >= 10){
            fontDung50.draw(batch,Integer.toString(userL.getLevel()),364,877);
        }else{
            fontDung50.draw(batch,Integer.toString(userL.getLevel()),376,877);
        }
    }
    public void timer(){
        raidTime -= Gdx.graphics.getRawDeltaTime();
        if(raidTime < 0 ){
            game.setScreen(game.getScreens().get(0));
            raidTime = 20.f;
            mercenarioUlt = false;
            pesteUlt = false;
            magoUlt = false;
            pirataUlt = false;
        }
    }
    public void team(){
        int countX = 0;
        for(final Champion c : userL.getSquad()){
           final IButton championB = new IButton(c, 100 + countX, 160);
           championB.addListener(new ActorGestureListener(){
               @Override
               public void tap(InputEvent event, float x, float y, int count, int button) {
                   super.tap(event, x, y, count, button);
                   if(c.getName().equals("Mercenario") && !mercenarioUlt){
                        raidTime += 10;
                        mercenarioUlt = true;
                   }
                   if(c.getName().equals("MPeste") && !pesteUlt){
                        upProgress -= upProgress*0.5;
                        pesteUlt = true;
                   }
                   if(c.getName().equals("Mago") && !magoUlt){
                       leftProgess -= c.getDmg()*2;
                       if(leftProgess < 0){
                           leftProgess = 0;
                       }
                       rightProgress -= c.getDmg()*2;
                       if(rightProgress < 0){
                           leftProgess = 0;
                       }
                       upProgress -= c.getDmg()*2;
                       if(upProgress < 0){
                           upProgress = 0;
                       }
                       bottonLeft -= c.getDmg()*2;
                       if(bottonLeft < 0){
                           bottonLeft = 0;
                       }
                       bottonRight -= c.getDmg()*2;
                       if(bottonRight < 0){
                           bottonRight = 0;
                       }
                       magoUlt = true;
                   }
                   if(c.getName().equals("Pirata") && !pirataUlt){
                        userL.setGold(userL.getGold() + 500);
                        raidTime += 4;
                        pirataUlt = true;
                   }
               }
           });
           stage.addActor(championB);
           countX += 170;
        }

    }
    public void enemy(){
        final IButton eLeft = new IButton("ShopIten.png", "ShopIten2.png", 736, 541);
        eLeft.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(leftProgess <= 0){
                    eLeft.invalidate();
                    leftProgess = 0;
                }
                else{
                    leftProgess -= getTotalDmg();
                    if(leftProgess <= 0){
                        leftProgess = 0;
                    }
                }
            }
        });
        eBLeft = new ProgressBar("hpbar2.png", "hpbar1.png", totalRaidHp/5,
                leftProgess, 736, 491, 264, 35 );
        final IButton eRight = new IButton("ShopIten.png", "ShopIten2.png", 1502, 541);
        eRight.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(rightProgress <= 0){
                    eRight.invalidate();
                    rightProgress = 0;
                }
                else {
                    rightProgress -= getTotalDmg();
                    if(rightProgress <= 0){
                        rightProgress = 0;
                    }
                }

            }
        });
        eBRight = new ProgressBar("hpbar2.png", "hpbar1.png", totalRaidHp/5,
                totalRaidHp/5, 1502, 491, 264, 35 );
        final IButton eUp = new IButton("ShopIten.png", "ShopIten2.png", 1118, 673);
        eUp.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(upProgress <= 0){
                    eUp.invalidate();
                    upProgress = 0;
                }
                else{
                    upProgress -= getTotalDmg();
                    if(upProgress <= 0){
                        upProgress = 0;
                    }
                }

            }
        });
        eBUp = new ProgressBar("hpbar2.png", "hpbar1.png", totalRaidHp/5,
                totalRaidHp/5, 1118, 623, 264, 35 );
        final IButton eLeftBot = new IButton("ShopIten.png", "ShopIten2.png", 954, 261);
        eLeftBot.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(bottonLeft <= 0){
                    bottonLeft = 0;
                    eLeftBot.invalidate();
                }
                else{
                    bottonLeft -= getTotalDmg();
                    if(bottonLeft <= 0){
                        bottonLeft = 0;
                    }
                }
            }
        });
        eBLeftBot = new ProgressBar("hpbar2.png", "hpbar1.png", totalRaidHp/5,
                totalRaidHp/5, 954, 211, 264, 35 );
        final IButton eRightBot= new IButton("ShopIten.png", "ShopIten2.png", 1333, 261);
        eRightBot.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(bottonRight <= 0){
                    bottonRight = 0;
                    eRightBot.invalidate();
                }
                else{
                    bottonRight -= getTotalDmg();
                    if(bottonRight <= 0){
                        bottonRight = 0;
                    }
                }
            }
        });
        eBRightBot = new ProgressBar("hpbar2.png", "hpbar1.png", totalRaidHp/5,
                totalRaidHp/5, 1333, 211, 264, 35 );
        stage.addActor(eLeft);
        stage.addActor(eRight);
        stage.addActor(eUp);
        stage.addActor(eLeftBot);
        stage.addActor(eRightBot);


    }

    public void endRaid(){
        if(leftProgess == 0 && rightProgress == 0 && bottonRight == 0 && bottonLeft == 0 && upProgress == 0){
            userL.setGold(userL.getGold() + 25000 * userL.getRaidLevel());
            userL.setRaidLevel(userL.getRaidLevel() + 1);
            game.setScreen(game.getScreens().get(0));
            raidTime = 20.f;
            mercenarioUlt = false;
            pesteUlt = false;
            magoUlt = false;
            pirataUlt = false;

        }
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

    public void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
