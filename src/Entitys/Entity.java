package Entitys;

import java.awt.*;

public abstract class Entity {
    public int worldX;
    public int worldY;
    public int speed;
    public Rectangle rectangle;
    String direction;
    int spriteCounter = 0;
    int spritePhaseDown = 0;
    int spritePhaseUp = 0;
    int spritePhaseRight = 0;
    int spritePhaseLEft = 0;


    public void draw(Graphics2D g2){

    }


}
