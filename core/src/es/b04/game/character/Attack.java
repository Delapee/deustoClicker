package es.b04.game.character;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Attack {
    private final String id;
    private int buff;
    private int debuff;
    private int cd;
    private boolean main;
    private List<String> sprite;

    public Attack(int buff, int debuff, int atkCode, int cd, boolean main,  List<String> sprite) {
        this.id = UUID.randomUUID().toString();
        this.buff = buff;
        this.debuff = debuff;
        this.cd = cd;
        this.main = main;
        this.sprite = new ArrayList<>(sprite);
    }

    public Attack() {
        this.id = UUID.randomUUID().toString();
        this.buff = 0;
        this.debuff = 0;
        this.cd = 0;
        this.main = false;
        this.sprite = new ArrayList<>();
    }

    public Attack(Attack copy) {
        this.id = copy.id;
        this.buff = copy.buff;
        this.debuff = copy.debuff;
        this.cd = copy.cd;
        this.main = copy.main;
        this.sprite = new ArrayList<>(copy.sprite);
    }

    public String getId() {
        return id;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public int getDebuff() {
        return debuff;
    }

    public void setDebuff(int debuff) {
        this.debuff = debuff;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public  List<String> getSprite() {
        return sprite;
    }

    public void setSprite( List<String> sprite) {
        this.sprite = sprite;
    }

}
