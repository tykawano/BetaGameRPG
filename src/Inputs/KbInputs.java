package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KbInputs implements KeyListener {
    private boolean upPressed, downPressed, leftPressed, rightPressed, keyPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = true;
        }
        else if (code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        else if (code == KeyEvent.VK_A||code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        else if (code == KeyEvent.VK_D||code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        } else {
            keyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        else if (code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        else if (code == KeyEvent.VK_A||code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        else if (code == KeyEvent.VK_D||code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }
}
