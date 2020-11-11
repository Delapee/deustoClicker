package es.b04.game.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class MapSystem {
    private int level;
    private int stage;
    private Texture boss;
    private Texture pointer;
    private Texture levelImage;
    private List<Integer> valoresY;
    private List<Integer> valoresX;
    private int variance;


    public MapSystem(int level, int stage, String boss, String pointer, String levelImage) {
        this.level = level;
        this.stage = stage;
        this.boss = new Texture(boss);
        this.pointer = new Texture(pointer);
        this.levelImage = new Texture(levelImage);
        this.valoresY = new ArrayList<>();
        this.valoresX = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            valoresY.add((int)(Math.random()*200+75));
        }
        variance = 0;
    }
    public void draw(SpriteBatch batch, int newLevel){
        batch.draw(boss, 1650, 240);
        variance = 0;
        for (int i = 0; i <=4 ; i++) {
            batch.draw(levelImage, 1033+variance, valoresY.get(i));
            valoresX.add(1033+variance);
            variance += 124;
            if(variance == 0){
                variance = 124;
            }
        }
        if(newLevel != 6){
            batch.draw(pointer, valoresX.get(newLevel-1), valoresY.get(newLevel-1)+100);
        }
        else{
            batch.draw(pointer, 1655, 340);
        }

    }
}
