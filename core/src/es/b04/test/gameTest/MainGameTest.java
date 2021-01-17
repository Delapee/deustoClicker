package es.b04.test.gameTest;

import com.badlogic.gdx.Screen;
import es.b04.game.log.User;
import es.b04.game.main.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MainGameTest {
    private User user;
    private MainGameScreen gameScreen;
    private GameMenuScreen menuScreen;
    private Raid raidScreen;
    private SquadMenuScreen squadScreen;
    private List<Screen> screensOP;

    @Before
    public void setUp(MainGame game){
        this.user = game.getUser();
        gameScreen = new MainGameScreen(game);
        menuScreen = new GameMenuScreen(game);
        raidScreen = new Raid(game);
        squadScreen = new SquadMenuScreen(game);
        screensOP = game.getScreens();
    }

    @Test
    public void getScreens() {
        assertEquals(gameScreen, screensOP.get(0));
        assertEquals(menuScreen, screensOP.get(1));
        assertEquals(raidScreen, screensOP.get(2));
        assertEquals(squadScreen, screensOP.get(3));
    }

    @Test
    public void getUser(MainGame game) {
        assertEquals(user, game.getUser());
    }
}