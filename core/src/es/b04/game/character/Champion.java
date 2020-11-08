package es.b04.game.character;

import es.b04.game.hud.IButton;

import java.util.ArrayList;
import java.util.List;

public class Champion {
    private static int id;
    private List<String> texture;
    private String name;
    private int level;
    private int levelMax;
    private int rare;
    private int dmg;
    private double accuracy;
    private double attackSpeed;
    private double criticProb;
    private double dodgeProb;
    private Attack attackP;
    private Attack attackS;
    private boolean onSquad;

    public Champion(List<String> texture, String name, int level, int rare, int dmg, double accuracy,
                    double attackSpeed, double criticProb, double dodgeProb, Attack attackP, Attack attackS, boolean onSquad) {
        this.texture = new ArrayList<>(texture);
        this.name = name;
        this.level = level;
        this.levelMax = level * 10;
        this.rare = rare;
        this.dmg = dmg;
        this.accuracy = accuracy;
        this.attackSpeed = attackSpeed;
        this.criticProb = criticProb;
        this.dodgeProb = dodgeProb;
        this.attackP = attackP;
        this.attackS = attackS;
        this.onSquad = onSquad;
    }

    public Champion() {
        this.texture = new ArrayList<>();
        this.name = "";
        this.level = 1;
        this.levelMax = 10;
        this.rare = 1;
        this.dmg = 0;
        this.accuracy = 0.0;
        this.attackSpeed = 0.0;
        this.criticProb = 0.0;
        this.dodgeProb = 0.0;
        this.attackP = new Attack();
        this.attackS = new Attack();
        this.onSquad = false;
    }

    public Champion(Champion copy) {
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
        this.attackP = copy.attackP;
        this.attackS = copy.attackS;
        this.onSquad = copy.onSquad;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Champion.id = id;
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

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
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

    public double getDodgeProb() {
        return dodgeProb;
    }

    public void setDodgeProb(double dodgeProb) {
        this.dodgeProb = dodgeProb;
    }

    public Attack getAttackP() {
        return attackP;
    }

    public void setAttackP(Attack attackP) {
        this.attackP = attackP;
    }

    public Attack getAttackS() {
        return attackS;
    }

    public void setAttackS(Attack attackS) {
        this.attackS = attackS;
    }

    public boolean isOnSquad() {
        return onSquad;
    }

    public void setOnSquad(boolean onSquad) {
        this.onSquad = onSquad;
    }

    public IButton toButton(float x, float y){
        return new IButton(this,x,y);
    }


}
