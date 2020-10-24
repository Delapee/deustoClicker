package es.b04.game.character;

public class Champion {
    protected static int id;
    protected int level;
    protected String name;
    protected int expMax;
    protected int expProgress;
    protected Attack attackP;
    protected Attack attackS;
    protected int dmg;
    protected double accuracy;
    protected double attackSpeed;
    protected double criticProb;
    protected double dodgeProb;
    protected String sprite;

    public Champion(int level, String name, int expMax, int expProgress, Attack attackP, Attack attackS,
                    int dmg, double accuracy, double attackSpeed, double criticProb, double dodgeProb, String sprite) {
        this.level = level;
        this.name = name;
        this.expMax = expMax;
        this.expProgress = expProgress;
        this.attackP = attackP;
        this.attackS = attackS;
        this.dmg = dmg;
        this.accuracy = accuracy;
        this.attackSpeed = attackSpeed;
        this.criticProb = criticProb;
        this.dodgeProb = dodgeProb;
        this.sprite = sprite;
    }
    public Champion(Champion copia) {
        this.level = copia.level;
        this.name = copia.name;
        this.expMax = copia.expMax;
        this.expProgress = copia.expProgress;
        this.attackP = copia.attackP;
        this.attackS = copia.attackS;
        this.dmg = copia.dmg;
        this.accuracy = copia.accuracy;
        this.attackSpeed = copia.attackSpeed;
        this.criticProb = copia.criticProb;
        this.dodgeProb = copia.dodgeProb;
        this.sprite = copia.sprite;
    }
    public Champion() {
        this.level = 1;
        this.name = "";
        this.expMax = 800;
        this.expProgress = 0;
        this.attackP = new Attack();
        this.attackS = new Attack();
        this.dmg = 1;
        this.accuracy = 1.0;
        this.attackSpeed = 1.0;
        this.criticProb = 0.0;
        this.dodgeProb = 0.0;
        this.sprite = "";
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Champion.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpMax() {
        return expMax;
    }

    public void setExpMax(int expMax) {
        this.expMax = expMax;
    }

    public int getExpProgress() {
        return expProgress;
    }

    public void setExpProgress(int expProgress) {
        this.expProgress = expProgress;
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

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", expMax=" + expMax +
                ", expProgress=" + expProgress +
                ", attackP=" + attackP +
                ", attackS=" + attackS +
                ", dmg=" + dmg +
                ", accuracy=" + accuracy +
                ", attackSpeed=" + attackSpeed +
                ", criticProb=" + criticProb +
                ", dodgeProb=" + dodgeProb +
                ", sprite=" + sprite +
                '}';
    }
}
