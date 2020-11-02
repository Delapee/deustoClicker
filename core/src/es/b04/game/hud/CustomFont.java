package es.b04.game.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import java.io.File;
import java.util.ArrayList;

public class CustomFont {
    private static ArrayList<String> fonts;

    private int size;
    private float r;
    private float g;
    private float b;
    private float a;
    private String fontDir;
    private float borderWidth;
    private Color borderColor;

    public CustomFont(int size, int r, int g, int b, float a, int fontIndex, float borderWidth, Color borderColor) {
        this.size = size;
        this.r = r/255f;
        this.g = g/255f;
        this.b = b/255f;
        this.a = a;
        this.fontDir = takeFont(fontIndex);
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
    }

    public CustomFont() {
        this.size = 12;
        this.r = 0f;
        this.g = 0f;
        this.b = 0f;
        this.a = 1f;
        this.fontDir = "";
        this.borderWidth = 0;
        this.borderColor = Color.BLACK;
    }

    public CustomFont(CustomFont copy) {
        this.size = copy.size;
        this.r = copy.r;
        this.g = copy.g;
        this.b = copy.b;
        this.a = copy.a;
        this.fontDir = copy.fontDir;
        this.borderWidth = copy.borderWidth;
        this.borderColor = copy.borderColor;
    }

    public static ArrayList<String> getFonts() {
        return fonts;
    }

    public static void setFonts(ArrayList<String> fonts) {
        CustomFont.fonts = fonts;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public String getFontDir() {
        return fontDir;
    }

    public void setFontDir(String font) {
        this.fontDir = font;
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String toString() {
        return "CustomFont{" +
                "size=" + size +
                ", r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", a=" + a +
                ", fontDir='" + fontDir + '\'' +
                ", borderWidth=" + borderWidth +
                ", borderColor=" + borderColor +
                '}';
    }


    private String takeFont(int i){
        fonts = new ArrayList<String>();
        File dir = new File("core/assets/fonts");

        File[] files = dir.listFiles();

        if (files == null) throw new AssertionError();
        for (File file: files) {
            if (file.isFile() && (file.getName().endsWith(".ttf") || file.getName().endsWith(".fnt"))) {
                fonts.add("core/assets/fonts/" + file.getName());
            }
        }

        return fonts.get(i);
    }

    public BitmapFont getCustomFont(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontDir));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = new Color(r,g,b,a);
        parameter.borderWidth = borderWidth;
        parameter.borderColor = borderColor;
        return generator.generateFont(parameter);
    }
}
