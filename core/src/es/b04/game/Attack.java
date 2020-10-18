package es.b04.game;

public class Attack {
    protected int cd;
    protected boolean main;

    public Attack(int cd, boolean main) {
        this.cd = cd;
        this.main = main;
    }
    public Attack() {
        this.cd = 0;
        this.main = true;
    }
    public Attack( Attack copy) {
        this.cd = copy.cd;
        this.main = copy.main;
    }


}
