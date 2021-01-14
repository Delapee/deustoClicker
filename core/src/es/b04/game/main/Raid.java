package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private IButton exitRaid;
    private DecimalFormat timeFormat = new DecimalFormat("#.00");
    private float time = 30.f;
    private static final Logger logger = LogManager.getLogger(MainGameScreen.class);

    public Raid(MainGame game){
        this.game = game;
        this.assetManager = game.getAssetManager();
        userL = game.getUser();
    }
    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        lvlBar = new ProgressBar("hpbar2.png", "expbar.png", userL.getExpMax(),
                userL.getExpProgress(), 430, 850, 264, 35);
        Gdx.input.setInputProcessor(stage);
        exitRaid = new IButton("auto.png", "auto2.png", 300, 200);
        background = assetManager.get(AssetEnum.RAIDBCK.getAsset());
        fontDung70 = new CustomFont(70,255,255,255,3.0f,0,
                2.5f,Color.BLACK).getCustomFont();
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,
                1.5f,Color.BLACK).getCustomFont();
        //exitRaid.addListener(new ActorGestureListener())
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        clearScreen();
        batch.begin();
        renderText();
        stage.draw();
        lvlBar.draw(batch, userL.getExpProgress(),userL.getExpMax());
        batch.end();
    }
    public void renderText(){
        //Fondo
        batch.draw(background, 0, 0);

        //User
        fontDung70.draw(batch,userL.getName(),430,1005);

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

    private void clearScreen() {
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
