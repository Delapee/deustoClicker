package es.b04.game.log;

import es.b04.game.character.Champion;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String pass;
    private String email;
    private String gender;
    private int age;
    private int level;
    private int expMax;
    private int expProgress;
    private int gold;
    private int autoClick;
    private String icon;
    private List<Champion> squad;
    private List<Champion> inventory;
    private int stage;
    private int stageLevel;

    public User(String name, String pass, String email, String gender, int age, int level, int expMax, int expProgress,
                int gold, int autoClick, String icon, ArrayList<Champion> squad, ArrayList<Champion> inventory,
                int stage, int stageLevel) {
        this.id = UUID.randomUUID().toString();
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
        this.stage = stage;
        this.stageLevel = stageLevel;

    }

    public User(String name, String pass, String email, String gender, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.level = 1;
        this.expMax = 1100;
        this.expProgress = 0;
        this.gold = 0;
        this.autoClick = 0;
        this.icon = "";
        this.squad = new ArrayList<Champion>(4);
        this.inventory = new ArrayList<Champion>();
        this.stage = 1;
        this.stageLevel = 1;
    }

    public User() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.pass = "";
        this.email = "";
        this.gender = "";
        this.age = 1;
        this.level = 1;
        this.expMax = 1100;
        this.expProgress = 0;
        this.gold = 0;
        this.autoClick = 0;
        this.icon = "";
        this.squad = new ArrayList<Champion>(4);
        this.inventory = new ArrayList<Champion>();
        this.stage = 1;
        this.stageLevel = 1;
    }

    public User(User copy) {
        this.id = copy.id;
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
        this.stage = copy.stage;
        this.stageLevel = copy.stageLevel;
    }

    public String getId() {
        return id;
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

    public List<Champion> getSquad() {
        return squad;
    }

    public void setSquad(List<Champion> squad) {
        this.squad = squad;
    }

    public List<Champion> getInventory() {
        return inventory;
    }

    public void setInventory(List<Champion> inventory) {
        this.inventory = inventory;
    }

    public void addChampionSquad(Champion c){
        squad.add(c);
    }

    public void removeChampionSquad(Champion c){
        squad.remove(c);
    }

    public void addChampionInventory(Champion c){
        inventory.add(c);
    }

    public void removeChampionInventory(Champion c){
        inventory.remove(c);
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStageLevel() {
        return stageLevel;
    }

    public void setStageLevel(int stageLevel) {
        this.stageLevel = stageLevel;
    }

}