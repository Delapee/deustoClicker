package es.b04.game.character;

public class Attack {
    protected int buff;
    protected int debuff;
    protected int atkCode;
    protected int cd;
    protected boolean main;
    protected String sprite;

    public Attack(int buff, int debuff, int atkCode, int cd, boolean main, String sprite) {
        this.buff = buff;
        this.debuff = debuff;
        this.atkCode = atkCode;
        this.cd = cd;
        this.main = main;
        this.sprite = sprite;
    }

    public Attack() {
        this.buff = 0;
        this.debuff = 0;
        this.atkCode = 0;
        this.cd = 0;
        this.main = false;
        this.sprite = "";
    }

    public Attack(Attack copia) {
        this.buff = copia.buff;
        this.debuff = copia.debuff;
        this.atkCode = copia.atkCode;
        this.cd = copia.cd;
        this.main = copia.main;
        this.sprite = copia.sprite;
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

    public int getAtkCode() {
        return atkCode;
    }

    public void setAtkCode(int atkCode) {
        this.atkCode = atkCode;
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

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "buff=" + buff +
                ", debuff=" + debuff +
                ", atkCode=" + atkCode +
                ", cd=" + cd +
                ", main=" + main +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
