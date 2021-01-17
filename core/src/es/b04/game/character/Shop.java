package es.b04.game.character;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import es.b04.game.dataBase.DBException;
import es.b04.game.dataBase.DBManager;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;
import es.b04.game.main.MainGame;
import es.b04.game.main.MainGameScreen;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private DBManager db;
    private List<IButton> itemList = new ArrayList<>(6);
    private MainGame game;
    private boolean expBoost = false;
    private boolean goldBoost = false;
    public Shop(MainGame game) {
        itemList.add(new IButton("shop/ShopIten1_n.png","shop/ShopIten1_p.png",1620,850));
        itemList.add(new IButton("shop/ShopIten2_n.png","shop/ShopIten2_p.png",1775,850));
        itemList.add(new IButton("shop/ShopIten3_n.png","shop/ShopIten3_p.png",1620,700));
        itemList.add(new IButton("shop/ShopIten4_n.png","shop/ShopIten4_p.png",1775,700));
        itemList.add(new IButton("shop/ShopIten6_n.png","shop/ShopIten6_p.png",1620,550));
        this.game = game;
    }

    public boolean isExpBoost() {
        return expBoost;
    }

    public void setExpBoost(boolean expBoost) {
        this.expBoost = expBoost;
    }

    public boolean isGoldBoost() {
        return goldBoost;
    }

    public void setGoldBoost(boolean goldBoost) {
        this.goldBoost = goldBoost;
    }

    public void loadShop(Stage stage, final User user){
        db = new DBManager();

        // Comprar Champ
        itemList.get(0).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);

                if (user.getGold() >= 500){
                    user.setGold(user.getGold() - 500);
                    try {
                        Champion c = db.getChampionDrop(randomChampType(),randomChampRare(user));
                        user.addChampionInventory(c);
                        db.storeNewChampion(c, user.getId());
                        db.uptadeAllUserData(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                    System.out.println(user.getInventory().get(user.getInventory().size()-1).getRare());
                }
            }
        });

        // Comprar Autoclick
        itemList.get(1).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (user.getGold() >= 500) {
                    user.setGold(user.getGold() - 500);
                    user.setAutoClick(user.getAutoClick() + 1);
                    try {
                        db.uptadeAllUserData(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // Comprar boost exp
        itemList.get(2).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (user.getGold() >= 500) {
                    user.setGold(user.getGold() - 500);
                    expBoost = true;
                    try {
                        db.uptadeAllUserData(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        itemList.get(3).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (user.getGold() >= 500) {
                    user.setGold(user.getGold() - 500);
                    goldBoost = true;
                    try {
                        db.uptadeAllUserData(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // Iniciar Raid
        itemList.get(4).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (user.getGold() >= 1500) {
                    user.setGold(user.getGold() - 500);
                    game.setScreen(game.getScreens().get(3));
                    try {
                        db.uptadeAllUserData(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        for (IButton iButton : itemList) {
            stage.addActor(iButton);
        }
    }

    public int randomChampRare(User user){
        int random = (int)(Math.random()*100);
        if (user.getLevel() <= 9 ){
            if (random <= 80) return 1;
            else if (random <= 100) return 2;
        }else if(user.getLevel() <= 19 ){
            if (random <= 60) return 1;
            else if (random <= 95) return 2;
            else return 3;
        }else if(user.getLevel() <= 29 ){
            if (random <= 40) return 1;
            else if (random <= 80) return 2;
            else if (random <= 95) return 3;
            else return 4;
        }else if(user.getLevel() <= 39 ){
            if (random <= 30) return 1;
            else if (random <= 65) return 2;
            else if (random <= 85) return 3;
            else if (random <= 98) return 4;
            else return 5;
        }else if(user.getLevel() <= 49 ){
            if (random <= 20) return 1;
            else if (random <= 50) return 2;
            else if (random <= 80) return 3;
            else if (random <= 95) return 4;
            else return 5;
        }else{
            if (random <= 10) return 1;
            else if (random <= 35) return 2;
            else if (random <= 70) return 3;
            else if (random <= 90) return 4;
            else return 5;
        }
        return 0;
    }

    public String randomChampType(){
        int random = (int)(Math.random()*4);

        if (random == 0) return "Pirata";
        else if (random == 1) return "Mago";
        else if (random == 2) return "Mercenario";
        else if (random == 3) return "MPeste";
        else return "";
    }

}
