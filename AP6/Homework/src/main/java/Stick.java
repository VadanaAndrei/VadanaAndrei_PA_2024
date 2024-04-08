import java.awt.*;
import java.io.Serializable;

public class Stick implements Serializable {
    Point location;
    boolean horizontal;

    public Stick(Point location, boolean horizontal) {
        this.location = location;
        this.horizontal = horizontal;
    }
}

