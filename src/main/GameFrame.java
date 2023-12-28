package main;

import javax.swing.*;
import java.io.IOException;

public class GameFrame extends JFrame{
    public GameFrame() throws IOException {
        setup();
    }

    private void setup() throws IOException {
        setTitle("Beta Dungeon Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        GamePanel game = new GamePanel();
        add(game);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
