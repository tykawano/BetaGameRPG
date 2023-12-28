package Entitys;

import Inputs.KbInputs;
import Inputs.MouseInputs;
import main.GamePanel;

import java.awt.*;

public class Player extends Entity{

    private GamePanel gp;
    private KbInputs kb;
    private MouseInputs mouse;
    public int playerScreenX;
    public int playerScreenY;
    public Player(GamePanel gp, KbInputs kb, MouseInputs mouse){
        this.gp = gp;
        this.kb = kb;
        this.mouse = mouse;
        this.defaultPlayerMovement();
    }

    public void defaultPlayerMovement(){
        worldX = 500;
        worldY = 500;
        playerScreenX = (gp.pixelWidth/2) - gp.halfTile;
        playerScreenY = (gp.pixelHeight/2) - gp.halfTile;
        speed = 5;
        direction = "down";
    }

    public void update(){
        if(kb.isDownPressed() || kb.isRightPressed() || kb.isUpPressed() || kb.isLeftPressed()){
            if(kb.isUpPressed()){
                System.out.println("pressed1");
                direction = "up";
                worldY -= speed;
            }
            if (kb.isDownPressed()) {
                System.out.println("pressed2");
                direction = "down";
                worldY += speed;
            }
            if(kb.isLeftPressed()){
                System.out.println("pressed3");
                direction = "left";
                worldX -= speed;
            }
            if(kb.isRightPressed()){
                System.out.println("pressed4");
                direction = "right";
                worldX += speed;
            }
        }


    }

    public void draw(Graphics2D g2){
        g2.fillRect(playerScreenX,playerScreenY,gp.size,gp.size);
    }


}
