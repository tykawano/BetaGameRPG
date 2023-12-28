package Background;

import java.awt.image.BufferedImage;

public class Tile {
    String type;
    BufferedImage tileImage;
    boolean collision = false;
    public Tile(BufferedImage image, String type){
        this.tileImage = image;
        this.type = type;
    }

    public BufferedImage getTileImage() {
        return tileImage;
    }
}
