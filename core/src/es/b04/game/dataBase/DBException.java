package es.b04.game.dataBase;

public class DBException extends Exception{

    private static final long serialVersionUID = -3387516993124229948L;

    public DBException(String message) {
        super(message);
    }

    public DBException(Throwable e) {
        super(e);
    }

    public DBException(String message, Throwable e) {
        super(message, e);
    }
}
