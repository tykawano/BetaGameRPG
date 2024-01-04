package Entitys;

import main.GamePanel;

import java.awt.*;

public abstract class Entity {
    GamePanel gp;
    public int worldX;
    public int worldY;
    public int speed;
    public Rectangle rectangle;
    String direction;
    public int animationTick;
    public int animationIndex;
    public int animationSpeed;
    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

}
