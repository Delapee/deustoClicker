package es.b04.game.hud;

public class CEnemy extends IButton{

    private int health;
    private int goldXClick;
    private int expXClick;

    public CEnemy(String normal, String press, int health, int goldXClick, int expXClick) {
        super(normal, press, 720, 500);
        this.health = health;
        this.goldXClick = goldXClick;
        this.expXClick = expXClick;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGoldXClick() {
        return goldXClick;
    }

    public void setGoldXClick(int goldXClick) {
        this.goldXClick = goldXClick;
    }

    public int getExpXClick() {
        return expXClick;
    }

    public void setExpXClick(int expXClick) {
        this.expXClick = expXClick;
    }


}
