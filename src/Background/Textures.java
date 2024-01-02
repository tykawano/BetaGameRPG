package Background;

import java.awt.image.BufferedImage;

public class Textures {
    public int worldX;
    public int worldY;
    BufferedImage image;
    boolean collision = false;
    public Textures(BufferedImage image, int worldX, int worldY){
        this.image = image;
        this.worldY = worldY;
        this.worldX = worldX;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public BufferedImage getImage() {
        return image;
    }
}
