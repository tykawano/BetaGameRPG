package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerAnimationsSetter {
    BufferedImage[][] playerAnimations;
    public final int originalPlayerWidth = 64;
    public final int originalPlayerHeight = 65;
    public final int playerWidth = originalPlayerWidth*5;
    public final int playerHeight = originalPlayerHeight*5;
    public PlayerAnimationsSetter() throws IOException {
        this.loadPlayerAnimations();
    }

    // loads all-player animations to the 2d array "playerAnimations"
    public void loadPlayerAnimations() throws IOException {
        Tools tools = new Tools();
        BufferedImage animationSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("/PaidTest/With Sword/AllHero.png")));
        playerAnimations = new BufferedImage[25][12];
        boolean leftState = false;
        int height = 0;
        BufferedImage scale;

        for (int j = 0; j < playerAnimations.length; j++) {
            if(leftState){
                j = 18;
                leftState = false;
            }
            for (int k = 0; k < playerAnimations[j].length; k++) {
                if(j == 12){
                    loadLeftAnimations( animationSheet,tools, j);
                    k = playerAnimations[j].length;
                    leftState = true;
                }
                else {
                    scale = animationSheet.getSubimage(originalPlayerWidth*k,height,originalPlayerWidth,originalPlayerHeight);
                    playerAnimations[j][k] = tools.scaleImage(scale,playerWidth,playerHeight);
                }

            }
            if(!leftState){
                height += originalPlayerHeight;
            }
        }
    }

    // Helper method that loads all the left animations to the 2d array "playerAnimations"
    private void loadLeftAnimations( BufferedImage animationSheet,Tools tools, int j) throws IOException {
        BufferedImage idleRight = animationSheet.getSubimage(0,6*originalPlayerHeight,animationSheet.getWidth(),originalPlayerHeight);
        BufferedImage walkRight = animationSheet.getSubimage(0,7*originalPlayerHeight,animationSheet.getWidth(),originalPlayerHeight);
        BufferedImage runRight = animationSheet.getSubimage(0,8*originalPlayerHeight,animationSheet.getWidth(),originalPlayerHeight);
        BufferedImage rollRight = animationSheet.getSubimage(0,9*originalPlayerHeight,animationSheet.getWidth(),originalPlayerHeight);
        BufferedImage chopRight = animationSheet.getSubimage(0,10*originalPlayerHeight,animationSheet.getWidth(),originalPlayerHeight);
        BufferedImage slashRight = animationSheet.getSubimage(0,11*originalPlayerHeight,animationSheet.getWidth(),originalPlayerHeight);


        int heightIndex = j;
        flipAnimation(heightIndex, tools,idleRight);

        heightIndex++;
        flipAnimation(heightIndex,tools, walkRight);

        heightIndex++;
        flipAnimation(heightIndex,tools, runRight);

        heightIndex++;
        flipAnimation(heightIndex,tools, rollRight);

        heightIndex++;
        flipAnimation(heightIndex,tools, chopRight);

        heightIndex++;
        flipAnimation(heightIndex,tools, slashRight);

    }

    // Helper method that takes all frames of right animations and flips them to the left
    private void flipAnimation(int heightIndex, Tools tools, BufferedImage rightAnimation){
        BufferedImage scale;
        BufferedImage exactCharacter;
        for (int i = 0; i < playerAnimations[0].length; i++) {
            scale = rightAnimation.getSubimage(originalPlayerWidth*i,0,originalPlayerWidth,originalPlayerHeight);
            exactCharacter = scale.getSubimage()
            playerAnimations[heightIndex][i] = tools.scaleImage(scale, playerWidth, playerHeight);
        }
    }

    public BufferedImage[][] getPlayerAnimations() {
        return playerAnimations;
    }
}

