package es.b04.game.hud;

public class Quest {
    private int objetive;
    private int actual;
    private String description;
    private boolean complete;
    private int goldReward;
    private int expReward;
    private int questCode;

    public Quest(int objetive, int actual, String description, boolean complete, int goldReward, int expReward, int questCode) {
        this.objetive = objetive;
        this.actual = actual;
        this.description = description;
        this.complete = complete;
        this.goldReward = goldReward;
        this.expReward = expReward;
        this.questCode = questCode;
    }

    public Quest() {
        this.objetive = 1;
        this.actual = 0;
        this.description = "";
        this.complete = false;
        this.goldReward = 0;
        this.expReward = 0;
        this.questCode = 0;
    }

    public Quest(Quest c) {
        this.objetive = c.objetive;
        this.actual = c.actual;
        this.description = c.description;
        this.complete = c.complete;
        this.goldReward = c.goldReward;
        this.expReward = c.expReward;
        this.questCode = c.questCode;
    }

    @Override
    public String toString() {
        return this.description + "\n" + this.actual + "/" + this.objetive;
    }

    public int getObjetive() {
        return objetive;
    }

    public void setObjetive(int objetive) {
        this.objetive = objetive;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public void setGoldReward(int goldReward) {
        this.goldReward = goldReward;
    }

    public int getExpReward() {
        return expReward;
    }

    public void setExpReward(int expReward) {
        this.expReward = expReward;
    }

    public int getQuestCode() {
        return questCode;
    }

    public void setQuestCode(int questCode) {
        this.questCode = questCode;
    }

    public void checkComplete(){
        if (this.objetive == this.actual) this.setComplete(true);
    }


}
