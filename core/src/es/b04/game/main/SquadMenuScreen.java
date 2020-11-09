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
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import es.b04.game.character.Champion;
import es.b04.game.utility.AssetEnum;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;
import es.b04.game.utility.CustomFont;

import java.util.ArrayList;
import java.util.List;

public class SquadMenuScreen extends ScreenAdapter {
    private Texture tittleBackground;
    private SpriteBatch batch;
    private final MainGame game;
    private final AssetManager assetManager;
    private Stage stage;
    private User userl;
    private IButton acept,equip,upgrade;

    private int inspect;
    private List<IButton> champButtons;

    private BitmapFont fontDung50;

    public SquadMenuScreen(MainGame game) {
        super();
        this.game = game;
        this.assetManager = game.getAssetManager();
    }

    @Override
    public void show() {
        super.show();

        // Basicos
        tittleBackground = new Texture("BackgroundSquad.png");
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        fontDung50 = new CustomFont(50,255,255,255,1.0f,0,
                1.5f, Color.BLACK).getCustomFont();
        userl = game.getUser();


        loadInventoryButtons();
        loadChampButtons();

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
        batch.begin();
        batch.draw(tittleBackground, 0, 0);
        renderChampions();
        stage.act(delta);
        renderText();
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
        inspect = 0;
        final int nRow = 3, nColum = 5;
        int cont = 0;

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

        champButtons.get(0).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 0;
            }
        });

        champButtons.get(1).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 1;
            }
        });

        champButtons.get(2).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 2;
            }
        });

        champButtons.get(3).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 3;
            }
        });

        champButtons.get(4).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 4;
            }
        });

        champButtons.get(5).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 5;
            }
        });

        champButtons.get(6).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 6;
            }
        });

        champButtons.get(7).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 7;
            }
        });

        champButtons.get(8).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 8;
            }
        });

        champButtons.get(9).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 9;
            }
        });

        champButtons.get(10).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 10;
            }
        });

        champButtons.get(11).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 11;
            }
        });

        champButtons.get(12).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 12;
            }
        });

        champButtons.get(13).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 13;
            }
        });

        champButtons.get(14).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                inspect = 14;
            }
        });


        for (int i = 0; i < 15; i++) {
            stage.addActor(champButtons.get(i));
        }

    }

    // Carga de Hud
    public void loadInventoryButtons(){
        acept = new IButton("B1.png","B2.png",53,
                195, (ScreenAdapter) game.getScreens().get(0), game);
        equip = new IButton("B1.png","B2.png",1490, 280);
        upgrade = new IButton("B1.png","B2.png",1490, 195);

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

    }

    public void renderText(){
        final  int rowAling = 1680;
        // Renderizado del User
        fontDung50.draw(batch, userl.getName(), 150, 943);
        fontDung50.draw(batch, Integer.toString(userl.getGold()), 150, 885);
        fontDung50.draw(batch, Integer.toString(userl.getLevel()), 98, 827);
        fontDung50.draw(batch, userl.getExpProgress() + "/" + userl.getExpMax() , 150, 827);

        // Renderizado de los stats texto
        if(inspect < userl.getInventory().size()) {
            fontDung50.draw(batch, userl.getInventory().get(inspect).getName(), 1680, 920,0, Align.center,false);
            fontDung50.draw(batch, "LVL " + userl.getInventory().get(inspect).getLevel(), 1630, 665);
            fontDung50.draw(batch, "" + userl.getInventory().get(inspect).getDmg(), rowAling, 605);
            fontDung50.draw(batch, "" + userl.getInventory().get(inspect).getAttackSpeed(), rowAling, 555);
            fontDung50.draw(batch, "" + userl.getInventory().get(inspect).getAccuracy(), rowAling, 507);
            fontDung50.draw(batch, "" + userl.getInventory().get(inspect).getDodgeProb(), rowAling, 460);
            fontDung50.draw(batch, "" + userl.getInventory().get(inspect).getCriticProb(), rowAling, 410);
        }
    }
}
