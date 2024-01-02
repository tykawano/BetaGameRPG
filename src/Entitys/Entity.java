package Entitys;

import java.awt.*;

public abstract class Entity {
    public int worldX;
    public int worldY;
    public int speed;
    public Rectangle rectangle;
    String direction;
    public int animationTick;
    public int animationIndex;
    public int animationSpeed;

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

}
