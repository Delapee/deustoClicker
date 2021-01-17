package es.b04.game.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Vector3;

public class CustomMouse {
    private String cursorImg;
    private Cursor cursor;
    private Vector3 mousePosition;
    private OrthographicCamera camera;


    public CustomMouse(String originalImg) {
        this.cursorImg = originalImg;
        this.cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal(cursorImg)), 0, 0);
        this.mousePosition = new Vector3();
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public String getCursorImg() {
        return cursorImg;
    }

    public void setCursorImg(String cursorImg) {
        this.cursorImg = cursorImg;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }


    public Vector3 getMousePosition() {
        mousetrack();
        return mousePosition;
    }

    public void setMousePosition(Vector3 mousePosition) {
        this.mousePosition = mousePosition;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public void mouseAct(){
        Gdx.graphics.setCursor(cursor);
    }

    public void mousetrack(){
        camera.update();
        mousePosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(mousePosition);
    }

}
