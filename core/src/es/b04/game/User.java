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
    protected int exp;
    protected int gold;
    protected int autoClick;
    protected ArrayList<Champion> squad;
    protected ArrayList<Champion> inventory;

    public User(String name, String pass, String email, String gender, int edad, int level, int exp, int gold,
                int autoClick, ArrayList<Champion> squad, ArrayList<Champion> inventory) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.gender = gender;
        this.edad = edad;
        this.level = level;
        this.exp = exp;
        this.gold = gold;
        this.autoClick = autoClick;
        this.squad = new ArrayList<>(squad);
        this.inventory = new ArrayList<>(inventory);
    }

    public User() {
        this.name = "";
        this.pass = "";
        this.email = "";
        this.gender = "";
        this.edad = 1;
        this.level = 1;
        this.exp = 0;
        this.gold = 0;
        this.autoClick = 0;
        this.squad = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public User(User copia) {
        this.name = copia.name;
        this.pass = copia.pass;
        this.email = copia.email;
        this.gender = copia.gender;
        this.edad = copia.edad;
        this.level = copia.level;
        this.exp = copia.exp;
        this.gold = copia.gold;
        this.autoClick = copia.autoClick;
        this.squad = new ArrayList<>(copia.squad);
        this.inventory = new ArrayList<>(copia.inventory);
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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
                ", exp=" + exp +
                ", gold=" + gold +
                ", autoClick=" + autoClick +
                ", squad=" + squad +
                ", inventory=" + inventory +
                '}';
    }
}