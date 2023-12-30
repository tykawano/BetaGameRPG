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

    private final GamePanel gp;
    private final KbInputs kb;
    private final MouseInputs mouse;
    private final PlayerAnimationsSetter setter;
    public final int raw_Player_Image_X = 37*3;
    public final int raw_Player_Image_Y = 24*3;
    public final int raw_Player_Image_Width = 14*3;
    public final int raw_Player_Image_Height = 21*3;
    public int playerScreenX;
    public int playerScreenY;
    private int playerAction = idleDown;
    private BufferedImage[][] animations;
    public boolean vertMovement;
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
        playerScreenX = (gp.pixelWidth/2) - raw_Player_Image_X - (raw_Player_Image_Width/2);
        playerScreenY = (gp.pixelHeight/2) - raw_Player_Image_Y - (raw_Player_Image_Height/2);
        speed = 5;
        direction = "down";
        animationTick = 0;
        animationIndex = 0;
        animationSpeed = 10;
    }

    public void update(){
        if(kb.isDownPressed() || kb.isRightPressed() || kb.isUpPressed() || kb.isLeftPressed()){
            if(kb.isUpPressed() && playerAction != walkUp){
                if(!vertMovement){
                    animationTick = 0;
                    animationIndex = 0;
                }
                vertMovement = true;
                direction = "up";
                worldY -= speed;
                playerAction = walkUp;
            }
            else if(kb.isUpPressed() && playerAction == walkUp){
                worldY -= speed;
            }

            else if (kb.isDownPressed() && playerAction != walkDown) {
                if(!vertMovement){
                    animationTick = 0;
                    animationIndex = 0;
                }
                vertMovement = true;
                direction = "down";
                worldY += speed;
                playerAction =  walkDown;
            }
            else if (kb.isDownPressed() && playerAction == walkDown) {
                worldY += speed;
            }

            if(kb.isLeftPressed() && playerAction != walkLeft){
                if(!vertMovement){
                    animationTick = 0;
                    animationIndex = 0;
                }
                vertMovement = true;
                direction = "left";
                worldX -= speed;
                playerAction =  walkLeft;
            }
            else if (kb.isLeftPressed() && playerAction == walkLeft) {
                worldX -= speed;
            }

            if(kb.isRightPressed() && playerAction != walkRight){
                if(!vertMovement){
                    animationTick = 0;
                    animationIndex = 0;
                }
                vertMovement = true;
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
                vertMovement = false;
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleUp;
            }
            if (direction.equals("down") && playerAction != idleDown) {
                vertMovement = false;
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleDown;
            }
            if (direction.equals("left") && playerAction != idleLeft) {
                vertMovement = false;
                animationTick = 0;
                animationIndex = 0;
                playerAction = idleLeft;
            }
            if (direction.equals("right") && playerAction != idleRight) {
                vertMovement = false;
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
        g2.drawImage(animations[playerAction][animationIndex],playerScreenX,playerScreenY,null);
    }


}
