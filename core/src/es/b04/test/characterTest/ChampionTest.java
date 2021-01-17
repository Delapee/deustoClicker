package es.b04.test.characterTest;

import es.b04.game.character.Champion;
import es.b04.game.hud.IButton;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChampionTest {

    private Champion testChamp;
    @Before
    public void setUp(){
        ArrayList<String> sChampion = new ArrayList<>();
        sChampion.add("pirate.png");
        sChampion.add("pirate.png");
        testChamp = new Champion(sChampion,"El PIRATA",1,1,100,10,15,33,15,false);
    }

    @Test
    public void testUpgradeGold() {
        assertEquals(1800,testChamp.getUpgradeGold());
    }

    @Test
    public void testUpgrade() {
        testChamp.upgrade();
        assertEquals(2, testChamp.getLevel());
        assertEquals((int)(100 * 1.5), testChamp.getDmg());
        assertEquals((int)(10 * 1.5), testChamp.getAccuracy());
        assertEquals(15 * 1.5, testChamp.getAttackSpeed(), 0);
        assertEquals(33 * 1.5, testChamp.getCriticProb(),0);
        assertEquals((int)(15 * 1.5), testChamp.getDodgeProb(),0);
    }
}