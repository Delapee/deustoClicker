package es.b04.game.hud;

public class CEnemy extends IButton{

    private int health;
    private int Maxhelth;
    private int goldDrop;
    private int expDrop;

    public CEnemy(String normal, String press, int health, int goldDrop, int expDrop) {
        super(normal, press, 720, 500);
        this.health = health;
        this.Maxhelth = health;
        this.goldDrop = goldDrop;
        this.expDrop = expDrop;
    }

    public CEnemy() {
        super("", "", 0, 0);
        this.health = 0;
        this.Maxhelth = 0;
        this.goldDrop = 0;
        this.expDrop = 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getMaxhelth() {
        return Maxhelth;
    }

    public void setMaxhelth(int maxhelth) {
        Maxhelth = maxhelth;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    public int getExpDrop() {
        return expDrop;
    }

    public void setExpDrop(int expDrop) {
        this.expDrop = expDrop;
    }

    public void update(int stage, int lvl){
        this.expDrop = (int) (100 * stage * (1 + 0.2 * (lvl-1)));
        this.goldDrop = (int) (100 * stage * (1 + 0.2 * (lvl-1)) * 4);
    }

}
