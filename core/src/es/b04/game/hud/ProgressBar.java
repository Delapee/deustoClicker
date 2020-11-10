package es.b04.game.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ProgressBar {
    private Texture backgroundS;
    private Texture changingS;
    private float total;
    private float progress;
    private int x;
    private int y;
    private int width;
    private int height;

    public ProgressBar(String backgroundS, String changingS, float total, float progress, int x,
                       int y, int width, int height) {
        this.backgroundS = new Texture(backgroundS);
        this.changingS = new Texture(changingS);
        this.total = total;
        this.progress = progress;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(SpriteBatch batch, float p, float t){
        NinePatch changingFinal = new NinePatch(new TextureRegion(changingS, width, height));
        batch.draw(backgroundS, x, y);
        changingFinal.draw(batch, x, y, (p/t)*width, height);
    }
    public float comp(){
        return progress/total;
    }

    public Texture getBackgroundS() {
        return backgroundS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBackgroundS(Texture backgroundS) {
        this.backgroundS = backgroundS;
    }

    public Texture getChangingS() {
        return changingS;
    }

    public void setChangingS(Texture changingS) {
        this.changingS = changingS;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
