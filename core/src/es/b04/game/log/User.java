package es.b04.game.log;

import es.b04.game.character.Champion;

import java.util.ArrayList;

public class User {
    protected static int id;
    protected String name;
    protected String pass;
    protected String email;
    protected String gender;
    protected int age;
    protected int level;
    protected int expMax;
    protected int expProgress;
    protected int gold;
    protected int autoClick;
    protected String icon;
    protected ArrayList<Champion> squad;
    protected ArrayList<Champion> inventory;

    public User(String name, String pass, String email, String gender, int age, int level, int expMax, int expProgress,
                int gold, int autoClick, String icon, ArrayList<Champion> squad, ArrayList<Champion> inventory) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.level = level;
        this.expMax = expMax;
        this.expProgress = expProgress;
        this.gold = gold;
        this.autoClick = autoClick;
        this.icon = icon;
        this.squad = new ArrayList<Champion>(squad);
        this.inventory = new ArrayList<Champion>(inventory);
    }

    public User() {
        this.name = "";
        this.pass = "";
        this.email = "";
        this.gender = "";
        this.age = 1;
        this.level = 1;
        this.expMax = 800;
        this.expProgress = 0;
        this.gold = 0;
        this.autoClick = 0;
        this.icon = "";
        this.squad = new ArrayList<Champion>();
        this.inventory = new ArrayList<Champion>();
    }

    public User(User copy) {
        this.name = copy.name;
        this.pass = copy.pass;
        this.email = copy.email;
        this.gender = copy.gender;
        this.age = copy.age;
        this.level = copy.level;
        this.expMax = copy.expMax;
        this.expProgress = copy.expProgress;
        this.gold = copy.gold;
        this.autoClick = copy.autoClick;
        this.icon = copy.icon;
        this.squad = new ArrayList<Champion>(copy.squad);
        this.inventory = new ArrayList<Champion>(copy.inventory);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAutoClick() {
        return autoClick;
    }

    public void setAutoClick(int autoClick) {
        this.autoClick = autoClick;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<Champion> getSquad() {
        return squad;
    }

    public void setSquad(ArrayList<Champion> squad) {
        this.squad = squad;
    }

    public ArrayList<Champion> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Champion> inventory) {
        this.inventory = inventory;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", edad=" + age +
                ", level=" + level +
                ", expMax=" + expMax +
                ", expProgress=" + expProgress +
                ", gold=" + gold +
                ", autoClick=" + autoClick +
                ", icon=" + icon +
                ", squad=" + squad +
                ", inventory=" + inventory +
                '}';
    }
}