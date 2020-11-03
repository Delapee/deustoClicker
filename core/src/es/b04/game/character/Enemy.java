package es.b04.game.character;

import es.b04.game.utility.Entity;

public class Enemy extends Entity {
    private static int id;
    private double level;
    private String name;
    private int health;
    private Attack attackP;
    private Attack attackS;
    private int dmg;
    private int def;
    private double accuracy;
    private double attackSpeed;
    private double criticProb;
    private double dodgeProb;

    public Enemy(double x, double y, int width, int length, String sprite, double level, String name,
                 int health, Attack attackP, Attack attackS, int dmg, int def, double accuracy,
                 double attackSpeed, double criticProb, double dodgeProb) {
        super(x, y, width, length, sprite);
        this.level = level;
        this.name = name;
        this.health = health;
        this.attackP = attackP;
        this.attackS = attackS;
        this.dmg = dmg;
        this.def = def;
        this.accuracy = accuracy;
        this.attackSpeed = attackSpeed;
        this.criticProb = criticProb;
        this.dodgeProb = dodgeProb;
    }

    public Enemy() {
        super();
        this.level = 0;
        this.name = "";
        this.health = 0;
        this.attackP = new Attack();
        this.attackS = new Attack();
        this.dmg = 0;
        this.def = 0;
        this.accuracy = 0.0;
        this.attackSpeed = 0.0;
        this.criticProb = 0.0;
        this.dodgeProb = 0.0;
    }

    public Enemy(Enemy copia) {
        super(copia.x, copia.y, copia.width, copia.length, copia.sprite);
        this.level = copia.level;
        this.name = copia.name;
        this.health = copia.health;
        this.attackP = copia.attackP;
        this.attackS = copia.attackS;
        this.dmg = copia.dmg;
        this.def = copia.def;
        this.accuracy = copia.accuracy;
        this.attackSpeed = copia.attackSpeed;
        this.criticProb = copia.criticProb;
        this.dodgeProb = copia.dodgeProb;
    }


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Enemy.id = id;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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


    @Override
    public String toString() {
        return "Enemy{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", attackP=" + attackP +
                ", attackS=" + attackS +
                ", dmg=" + dmg +
                ", def=" + def +
                ", accuracy=" + accuracy +
                ", attackSpeed=" + attackSpeed +
                ", criticProb=" + criticProb +
                ", dodgeProb=" + dodgeProb +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", length=" + length +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
