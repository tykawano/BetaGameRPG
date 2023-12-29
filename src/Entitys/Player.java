package Entitys;

import Inputs.KbInputs;
import Inputs.MouseInputs;
import Utils.PlayerAnimationsSetter;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static Utils.Constants.PlayerConstants.*;

public class Player extends Entity{

    private GamePanel gp;
    private KbInputs kb;
    private MouseInputs mouse;
    private PlayerAnimationsSetter setter;
    public int playerScreenX;
    public int playerScreenY;
    private int playerAction = idleDown;
    private int animationTick = 0;
    private int animationIndex = 0;
    private int animationSpeed = 10;
    private BufferedImage[][] animations;
    public Player(GamePanel gp, KbInputs kb, MouseInputs mouse) throws IOException {
        this.gp = gp;
        this.kb = kb;
        this.mouse = mouse;
        this.setter = new PlayerAnimationsSetter();
        this.defaultPlayer();
    }

    public void defaultPlayer(){
        animations = setter.getPlayerAnimations();
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
                playerAction = walkUp;
            }
            if (kb.isDownPressed()) {
                System.out.println("pressed2");
                direction = "down";
                worldY += speed;
                playerAction =  walkDown;
            }
            if(kb.isLeftPressed()){
                System.out.println("pressed3");
                direction = "left";
                worldX -= speed;
                playerAction =  walkLeft;
            }
            if(kb.isRightPressed()){
                System.out.println("pressed4");
                direction = "right";
                worldX += speed;
                playerAction =  walkRight;
            }
        }


    }

    private void updateAnimationContinuous(){
        animationTick++;
        if(animationTick >= animationSpeed){
            animationTick = 0;
            animationIndex++;
            if(animationIndex > GetPlayerActionFrame(playerAction)){
                animationIndex = 0;
            }
        }
    }

    public void draw(Graphics2D g2) throws InterruptedException {
        g2.drawImage(animations[playerAction][animationIndex],worldX,worldY,null);
        updateAnimationContinuous();
    }


}
