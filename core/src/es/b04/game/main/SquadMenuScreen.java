package es.b04.game.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.character.Champion;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.hud.ProgressBar;
import es.b04.game.utility.AssetEnum;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;
import es.b04.game.utility.CustomFont;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SquadMenuScreen extends ScreenAdapter {
    private static DBManager db = new DBManager();
    private Texture tittleBackground;
    private SpriteBatch batch;
    private final MainGame game;
    private final AssetManager assetManager;
    private Stage stage;
    private User userl;
    private IButton acept,equip,upgrade, sell, pageL, pageR;
    private static final Logger logger = LogManager.getLogger(SquadMenuScreen.class);
    private ProgressBar lvlBar;
    private int inspect;
    private List<IButton> champButtons;
    private int page;

    private BitmapFont fontDung50;

    public SquadMenuScreen(MainGame game) {
        super();
        this.game = game;
        this.assetManager = game.getAssetManager();
        inspect = 0;
    }

    @Override
    public void show() {
        super.show();
        try {
            db.uptadeAllUserData(userl);
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (inspect < 15){
            page = 1;
            inspect = 0;
        }
        else if (inspect < 30){
            page = 2;
            inspect = 15;
        }
        else {
            page = 3;
            inspect = 30;
        }

        // Basicos
        tittleBackground = new Texture("BackgroundSquad.png");
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,
                1.5f, Color.BLACK).getCustomFont();
        userl = game.getUser();

        lvlBar = new ProgressBar("hpbar2.png", "expbar.png", userl.getExpMax(),
                userl.getExpProgress(), 140, 810, 264, 35);
        loadInventoryButtons();
        loadChampButtons();
        logger.info("Personajes cargados correctamente.");
        Gdx.input.setInputProcessor(stage);
        stage.addActor(acept);
        stage.addActor(equip);
        stage.addActor(upgrade);
        stage.addActor(sell);
        stage.addActor(pageR);
        stage.addActor(pageL);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(tittleBackground, 0, 0);
        renderChampions();
        stage.act(delta);
        renderText();
        lvlBar.draw(batch, userl.getExpProgress(),userl.getExpMax());
        stage.draw();
        batch.end();
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

    // Carga de Personajes
    public void loadChampButtons(){
        final int nRow = 3, nColum = 5;
        int cont = inspect;

        champButtons = new ArrayList<>();

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColum; j++) {
                if (cont < userl.getInventory().size()) {
                    champButtons.add(userl.getInventory().get(cont).toButton(490 + 195 * j, 646 - 244 * i));
                    cont++;
                }else{
                    champButtons.add(new IButton("asdf.png","asdf.png",490 + 195 * j, 646 - 244 * i));
                }
            }
        }

        for (int i = 0; i < 15; i++) {
            final int finalNum = i;
            champButtons.get(i).addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int count, int button) {
                    super.tap(event, x, y, count, button);
                    inspect = finalNum;
                }
            });
        }

        for (int i = 0; i < 15; i++) {
            stage.addActor(champButtons.get(i));
        }

    }

    // Carga de Hud
    public void loadInventoryButtons(){
        acept = new IButton("boton/b_aceptarN.png","boton/b_aceptarP.png",53,
                195);
        equip = new IButton("boton/b_equiparN.png","boton/b_equiparP.png",1490, 280);
        upgrade = new IButton("boton/b_mejorarN.png","boton/b_mejorarP.png",1490, 195);
        sell = new IButton("boton/b_venderN.png","boton/b_venderP.png",775, 100);
        pageL = new IButton("flecha/arrowr_n.png","flecha/arrowr_p.png",500, 100);
        pageR = new IButton("flecha/arrowl_n.png","flecha/arrowl_p.png",1225, 100);

        acept.addListener(new ActorGestureListener(){

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 0;
                game.setScreen( game.getScreens().get(0));
            }
        });

        equip.addListener(new ActorGestureListener(){

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (userl.getInventory().get(inspect).isOnSquad()){
                    userl.getSquad().remove(userl.getInventory().get(inspect));
                    userl.getInventory().get(inspect).setOnSquad(false);
                }else if (userl.getSquad().size() < 4 && inspect < userl.getInventory().size()){
                    userl.getSquad().add(userl.getInventory().get(inspect));
                    userl.getInventory().get(inspect).setOnSquad(true);
                }
            }
        });

        upgrade.addListener(new ActorGestureListener(){

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (userl.getGold() >= userl.getInventory().get(inspect).getUpgradeGold()){
                    userl.setGold(userl.getGold()-userl.getInventory().get(inspect).getUpgradeGold());
                    userl.getInventory().get(inspect).upgrade();
                }
            }
        });

        sell.addListener(new ActorGestureListener(){

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (userl.getInventory().size() > 0) {
                    if (!userl.getInventory().get(inspect).isOnSquad()) {
                        userl.getInventory().remove(inspect);
                        game.setScreen( game.getScreens().get(2));
                    }
                }
            }
        });

        pageL.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(userl.getInventory().size() >= 15 & inspect >= 15){
                    inspect -= 15;
                    game.setScreen( game.getScreens().get(2));
                }

            }
        });

        pageR.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if(userl.getInventory().size() > 15){
                    inspect += 15;
                    game.setScreen( game.getScreens().get(2));
                }
            }
        });

    }

    // Metodos de Renderizacion
    public void renderChampions(){
        int cont = 0,row = 0, colum = 0;

        // Renderizado del Squad
        while (cont < userl.getSquad().size()){
            batch.draw(new Texture(userl.getSquad().get(cont).getTexture().get(0)),70 + 185*colum,530 - 233*row);
            switch (cont) {
                case 0:
                case 2:
                    colum++;
                    break;
                case 1:
                    colum--;
                    row++;
                    break;
            }
            cont++;
        }

        cont = 15*(page - 1);
        final int nRow = 3, nColum = 5;
        String rare = "";
        // Renderizar Rarezas
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nColum; j++) {

                try {
                    switch (userl.getInventory().get(cont).getRare()){
                        case 1:
                            rare = "rarezas/1.png";
                            break;
                        case 2:
                            rare = "rarezas/2.png";
                            break;
                        case 3:
                            rare = "rarezas/3.png";
                            break;
                        case 4:
                            rare = "rarezas/4.png";
                            break;
                        case 5:
                            rare = "rarezas/5.png";
                            break;
                    }
                    batch.draw(new Texture(rare),491 + 195 * j, 645 - 244 * i);
                    cont++;
                }catch (Exception e){

                }

            }
        }

    }

    public void renderText(){
        final  int rowAling = 1680;
        // Renderizado del User
        fontDung50.draw(batch, userl.getName(), 150, 943);
        fontDung50.draw(batch, Integer.toString(userl.getGold()), 150, 885);
        fontDung50.draw(batch, Integer.toString(userl.getLevel()), 104, 828,0,Align.center,false);

        // Renderizado de los stats texto
        if(inspect < userl.getInventory().size()) {
            fontDung50.draw(batch, userl.getInventory().get(inspect).getName(), 1680, 920,0, Align.center,false);
            batch.draw(new Texture(userl.getInventory().get(inspect).getTexture().get(2)),1545,688);
            fontDung50.draw(batch, "LVL " + userl.getInventory().get(inspect).getLevel(), 1630, 665);
            fontDung50.draw(batch, Integer.toString(userl.getInventory().get(inspect).getDmg()), rowAling, 605);
            fontDung50.draw(batch, Double.toString(userl.getInventory().get(inspect).getAttackSpeed()), rowAling, 555);
            fontDung50.draw(batch, Integer.toString(userl.getInventory().get(inspect).getAccuracy()), rowAling, 507);
            fontDung50.draw(batch, "" + userl.getInventory().get(inspect).getCriticProb(), rowAling, 460);
            fontDung50.draw(batch, Integer.toString(userl.getInventory().get(inspect).getDodgeProb()), rowAling, 410);
        }
    }
}
