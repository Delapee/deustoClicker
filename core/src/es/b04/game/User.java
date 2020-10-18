package es.b04.game;

import java.util.ArrayList;

public class User {
    protected static int id;
    protected String name;
    protected String pass;
    protected String email;
    protected String gender;
    protected int edad;
    protected int level;
    protected int expMax;
    protected int expProgress;
    protected int gold;
    protected int autoClick;
    protected ArrayList<Champion> squad;
    protected ArrayList<Champion> inventory;

    public User(String name, String pass, String email, String gender, int edad, int level, int expMax, int expProgress,
                int gold, int autoClick, ArrayList<Champion> squad, ArrayList<Champion> inventory) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.gender = gender;
        this.edad = edad;
        this.level = level;
        this.expMax = expMax;
        this.expProgress = expProgress;
        this.gold = gold;
        this.autoClick = autoClick;
        this.squad = squad;
        this.inventory = inventory;
    }

    public User() {
        this.name = "";
        this.pass = "";
        this.email = "";
        this.gender = "";
        this.edad = 1;
        this.level = 1;
        this.expMax = 800;
        this.expProgress = 0;
        this.gold = 0;
        this.autoClick = 0;
        this.squad = new ArrayList<Champion>();
        this.inventory = new ArrayList<Champion>();
    }

    public User(User copy) {
        this.name = copy.name;
        this.pass = copy.pass;
        this.email = copy.email;
        this.gender = copy.gender;
        this.edad = copy.edad;
        this.level = copy.level;
        this.expMax = copy.expMax;
        this.expProgress = copy.expProgress;
        this.gold = copy.gold;
        this.autoClick = copy.autoClick;
        this.squad = copy.squad;
        this.inventory = copy.inventory;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
                ", edad=" + edad +
                ", level=" + level +
                ", expMax=" + expMax +
                ", expProgress=" + expProgress +
                ", gold=" + gold +
                ", autoClick=" + autoClick +
                ", squad=" + squad +
                ", inventory=" + inventory +
                '}';
    }
}