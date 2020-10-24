package es.b04.game.character;

public abstract class Entity {
    protected double x;
    protected double y;
    protected int width;
    protected int length;
    protected String sprite;


    public Entity(double x, double y, int width, int length, String sprite) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
        this.sprite = sprite;
    }

    public Entity() {
        this.x = 0.0;
        this.y = 0.0;
        this.width = 0;
        this.length = 0;
        this.sprite = "";
    }

    public Entity(Entity copia) {
        this.x = copia.x;
        this.y = copia.y;
        this.width = copia.width;
        this.length = copia.length;
        this.sprite = copia.sprite;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }


    @Override
    public String toString() {
        return "Entity{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", length=" + length +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
