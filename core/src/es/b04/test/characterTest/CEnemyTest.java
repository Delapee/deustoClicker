package es.b04.test.characterTest;

import es.b04.game.character.Champion;
import es.b04.game.hud.CEnemy;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CEnemyTest {

    private CEnemy testEnemy;


    @Before
    public void setUp() {
        testEnemy = new CEnemy();
    }


    @Test
    public void update() {
        testEnemy.update(1,1);
        assertEquals(100,testEnemy.getExpDrop());
        assertEquals(400,testEnemy.getGoldDrop());

        testEnemy.update(1,5);
        assertEquals(180,testEnemy.getExpDrop());
        assertEquals(720,testEnemy.getGoldDrop());

        testEnemy.update(2,1);
        assertEquals(100,testEnemy.getExpDrop());
        assertEquals(400,testEnemy.getGoldDrop());
    }
}