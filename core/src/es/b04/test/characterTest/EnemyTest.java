package es.b04.test.characterTest;


import es.b04.game.character.Enemy;
import es.b04.game.hud.CEnemy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EnemyTest {

    private Enemy testEnemy;


    @Before
    public void setUp() {
        testEnemy = new Enemy();
    }

    @Test
    public void testGetLevel() {
        assertEquals(0 , testEnemy.getLevel(), 0);
    }

    @Test
    public void testGetName() {
        assertEquals("" , testEnemy.getName());
    }

    @Test
    public void testGetHealth() {
        assertEquals(0 , testEnemy.getHealth());
    }

    @Test
    public void testGetDmg() {
        assertEquals(0 , testEnemy.getDmg());
    }

    @Test
    public void testGetDef() {
        assertEquals(0 , testEnemy.getDef());
    }

    @Test
    public void testGetAccuracy() {
        assertEquals(0.0 , testEnemy.getAccuracy(), 0);
    }

    @Test
    public void testGetAttackSpeed() {
        assertEquals(0.0 , testEnemy.getAttackSpeed(), 0);
    }

    @Test
    public void testGetCriticProb() {
        assertEquals(0.0 , testEnemy.getCriticProb(), 0);
    }

    @Test
    public void testGetDodgeProb() {
        assertEquals(0.0 , testEnemy.getDodgeProb(), 0);
    }
}