package es.b04.game.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import es.b04.game.hud.IButton;
import es.b04.game.log.User;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<IButton> itemList = new ArrayList<>(6);

    public Shop() {
        itemList.add(new IButton("ShopIten.png","ShopIten2.png",1650,850));
        itemList.add(new IButton("ShopIten.png","ShopIten2.png",1775,850));
        itemList.add(new IButton("ShopIten.png","ShopIten2.png",1775,700));
    }



    public void loadShop(Stage stage, final User user){

        // Comprar Champ
        itemList.get(0).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);

                if (user.getGold() >= 500){
                    user.setGold(user.getGold() - 500);
                    ArrayList<String> sChampion = new ArrayList<>();
                    sChampion.add("pirate.png");
                    sChampion.add("pirate.png");
                    user.addChampionInventory(new Champion(sChampion,"El Nuevo",1,randomChamp(user),100,41,15,33,13,null,null,false));
                    System.out.println(user.getInventory().get(user.getInventory().size()-1).getRare());
                }
            }
        });

        // Comprar Auticlick
        itemList.get(1).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (user.getGold() >= 500) {
                    user.setGold(user.getGold() - 500);
                    user.setAutoClick(user.getAutoClick() + 1);
                }
            }
        });

        // Iniciar Raid

        itemList.get(2).addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                if (user.getGold() >= 1500) {
                    user.setGold(user.getGold() - 500);



                }
            }
        });

        for (IButton iButton : itemList) {
            stage.addActor(iButton);
        }
    }

    public int randomChamp(User user){
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

}
