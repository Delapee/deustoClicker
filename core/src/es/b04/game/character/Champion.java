package es.b04.game.character;

import es.b04.game.hud.IButton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

public class Champion {
    private final String id;
    private List<String> texture;
    private String name;
    private int level;
    private int levelMax;
    private int rare;
    private int dmg;
    private int accuracy;
    private double attackSpeed;
    private double criticProb;
    private int dodgeProb;
    private boolean onSquad;

    public Champion(String id, List<String> texture, String name, int level, int rare, int dmg, int accuracy,
                    double attackSpeed, double criticProb, int dodgeProb, boolean onSquad) {
        this.id = id;
        this.texture = new ArrayList<>(texture);
        this.name = name;
        this.level = level;
        this.levelMax = rare * 10;
        this.rare = rare;
        this.dmg = dmg;
        this.accuracy = accuracy;
        this.attackSpeed = attackSpeed;
        this.criticProb = criticProb;
        this.dodgeProb = dodgeProb;
        this.onSquad = onSquad;
    }

    public Champion(List<String> texture, String name, int level, int rare, int dmg, int accuracy,
                    double attackSpeed, double criticProb, int dodgeProb, boolean onSquad) {
        this.id = UUID.randomUUID().toString();
        this.texture = new ArrayList<>(texture);
        this.name = name;
        this.level = level;
        this.levelMax = rare * 10;
        this.rare = rare;
        this.dmg = dmg;
        this.accuracy = accuracy;
        this.attackSpeed = attackSpeed;
        this.criticProb = criticProb;
        this.dodgeProb = dodgeProb;
        this.onSquad = onSquad;
    }

    public Champion() {
        this.id = UUID.randomUUID().toString();
        this.texture = new ArrayList<>();
        this.name = "";
        this.level = 1;
        this.levelMax = 10;
        this.rare = 1;
        this.dmg = 0;
        this.accuracy = 0;
        this.attackSpeed = 0;
        this.criticProb = 0.0;
        this.dodgeProb = 0;
        this.onSquad = false;
    }

    public Champion(Champion copy) {
        this.id = copy.id;
        this.texture = new ArrayList<>(copy.texture);
        this.name = copy.name;
        this.level = copy.level;
        this.levelMax = copy.levelMax;
        this.rare = copy.rare;
        this.dmg = copy.dmg;
        this.accuracy = copy.accuracy;
        this.attackSpeed = copy.attackSpeed;
        this.criticProb = copy.criticProb;
        this.dodgeProb = copy.dodgeProb;
        this.onSquad = copy.onSquad;
    }

    public String getId() {
        return id;
    }

    public List<String> getTexture() {
        return texture;
    }

    public void setTexture(List<String> texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(int levelMax) {
        this.levelMax = levelMax;
    }

    public int getRare() {
        return rare;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getCriticProb() {
        return criticProb;
    }

    public void setCriticProb(double criticProb) {
        this.criticProb = criticProb;
    }

    public int getDodgeProb() {
        return dodgeProb;
    }

    public void setDodgeProb(int dodgeProb) {
        this.dodgeProb = dodgeProb;
    }

    public boolean isOnSquad() {
        return onSquad;
    }

    public void setOnSquad(boolean onSquad) {
        this.onSquad = onSquad;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id='" + id + '\'' +
                ", texture=" + texture +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", levelMax=" + levelMax +
                ", rare=" + rare +
                ", dmg=" + dmg +
                ", accuracy=" + accuracy +
                ", attackSpeed=" + attackSpeed +
                ", criticProb=" + criticProb +
                ", dodgeProb=" + dodgeProb +
                ", onSquad=" + onSquad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        return level == champion.level &&
                levelMax == champion.levelMax &&
                rare == champion.rare &&
                dmg == champion.dmg &&
                champion.accuracy == accuracy &&
                Double.compare(champion.attackSpeed, attackSpeed) == 0 &&
                Double.compare(champion.criticProb, criticProb) == 0 &&
                champion.dodgeProb == dodgeProb &&
                onSquad == champion.onSquad &&
                Objects.equals(texture, champion.texture) &&
                Objects.equals(name, champion.name);
    }

    public void upgrade(){
        DecimalFormat df = new DecimalFormat("#.00");
        this.level++;
        this.dmg = (int) (this.dmg * 1.5);
        this.accuracy = (int) (this.accuracy * 1.5);
        this.attackSpeed = (double)Math.round((this.attackSpeed * 1.5 * 100d) / 100d);
        this.criticProb = (double)Math.round((this.criticProb * 1.5* 100d) / 100d);
        this.dodgeProb = (int) (this.dodgeProb * 1.5);
    }

    public int getUpgradeGold(){
        int result = 0;

        for (int i = 1; i < 7; i++) {
            result += 100 * this.level * (1 + 0.2 * (i-1)) * 2;
        }
        return result;
    }

    public IButton toButton(float x, float y){
        return new IButton(this,x,y);
    }


}
