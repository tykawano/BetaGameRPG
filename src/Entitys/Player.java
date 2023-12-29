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
            if(kb.isUpPressed() && playerAction != walkUp){
                animationTick = 0;
                animationIndex = 0;
                direction = "up";
                worldY -= speed;
                playerAction = walkUp;
            }
            else if(kb.isUpPressed() && playerAction == walkUp){
                worldY -= speed;
            }

            if (kb.isDownPressed() && playerAction != walkDown) {
                animationTick = 0;
                animationIndex = 0;
                direction = "down";
                worldY += speed;
                playerAction =  walkDown;
            }
            else if (kb.isDownPressed() && playerAction == walkDown) {
                worldY += speed;
            }

            if(kb.isLeftPressed() && playerAction != walkLeft){
                animationTick = 0;
                animationIndex = 0;
                direction = "left";
                worldX -= speed;
                playerAction =  walkLeft;
            }
            else if (kb.isLeftPressed() && playerAction == walkLeft) {
                worldX -= speed;
            }

            if(kb.isRightPressed() && playerAction != walkRight){
                animationTick = 0;
                animationIndex = 0;
                direction = "right";
                worldX += speed;
                playerAction = walkRight;
            }
            else if (kb.isRightPressed() && playerAction == walkRight) {
                worldX += speed;
            }
        }
        else {
            if(direction.equals("up") && playerAction != idleUp){
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleUp;
            }
            if (direction.equals("down") && playerAction != idleDown) {
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleDown;
            }
            if (direction.equals("left") && playerAction != idleLeft) {
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleLeft;
            }
            if (direction.equals("right") && playerAction != idleRight) {
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleRight;
            }
        }
        updateAnimationContinuous();


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
    }


}
