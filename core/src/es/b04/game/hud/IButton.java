package es.b04.game.hud;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import es.b04.game.main.MainGame;
import es.b04.game.main.MainGameScreen;

public class IButton extends ImageButton {

    private String normal;
    private String press;
    private MainGame game;
    private float x;
    private float y;

    public IButton(String normal, String press, float x, float y){
        super(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(normal)))),
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(press)))));
        super.setPosition(x,y);
    }

    public IButton(String normal, String press, float x, float y, int align){
        super(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(normal)))),
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(press)))));
        super.setPosition(x,y,align);
    }

    public IButton(String normal, String press, float x, float y, final ScreenAdapter screen, final MainGame game) {
        super(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(normal)))),
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(press)))));
        super.setPosition(x,y);
        super.addListener( new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                game.setScreen(screen);
            }

        });
    }

    public IButton(String normal, String press, float x, float y, int align, final ScreenAdapter screen,
                   final MainGame game) {
        super(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(normal)))),
                new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal(press)))));
        super.setPosition(x,y,align);
        super.addListener( new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                game.setScreen(screen);
            }

        });
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }


}

