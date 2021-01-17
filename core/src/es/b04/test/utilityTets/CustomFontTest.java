package es.b04.test.utilityTets;

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
        assertEquals("1_dung.ttf",fontDung70.getFontDir());
    }

    @Test
    public void testGetSize(){
        assertEquals(70, fontDung70.getSize());
    }

    @Test
    public void testGetR(){
        assertEquals(1, fontDung70.getR(), 0);
    }

    @Test
    public void testGetG(){
        assertEquals(1, fontDung70.getG(), 0);
    }

    @Test
    public void testGetB(){
        assertEquals(1, fontDung70.getB(), 0);
    }

    @Test
    public void testGetA(){
        assertEquals(3.0f, fontDung70.getA(), 0);
    }

    @Test
    public void testGetBorderWidth(){
        assertEquals(2.5f, fontDung70.getBorderWidth(), 0);
    }

    @Test
    public void testGetBorderColor(){
        assertEquals(Color.BLACK, fontDung70.getBorderColor());
    }

}