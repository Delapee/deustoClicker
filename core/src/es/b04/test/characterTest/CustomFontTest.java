package es.b04.test.characterTest;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import es.b04.game.utility.CustomFont;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomFontTest {

    CustomFont fontDung70;

    @Before
    public void setUp(){
        fontDung70 = new CustomFont(70,255,255,255,3.0f,0,
                2.5f, Color.BLACK);
    }

    @Test
    public void tesGetFonts() {
        assertEquals("core/assets/fonts/1_dung.ttf",fontDung70.getFontDir());
    }

    @Test
    public void testGetCustomFont() {
        assertEquals(BitmapFont.class,fontDung70.getCustomFont().getClass());
    }
}