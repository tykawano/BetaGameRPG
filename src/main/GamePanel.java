package main;

import Background.TileManager;
import Entitys.Player;
import Inputs.KbInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GamePanel extends JPanel implements Runnable{

    public final int originalSize = 32;
    public final int size = originalSize*2; //scaled: 64
    public final int colNum = 10;
    public final int rowNum = 18;
    public final int pixelHeight = colNum*size; // Height: 640 px
    public final int pixelWidth = rowNum*size; // Width: 1152 px
    public final int halfTile = size/2;
    private final int fps = 90;


    // Inputs
    public KbInputs keys;
    public MouseInputs mouse;
    // game thread
    public Thread gameThread;

    // objects
    public TileManager manager;
    public Player player;
    public GamePanel() throws IOException {
        this.setup();
        this.manager = new TileManager(this);
        this.player = new Player(this,keys,mouse);
        this.startThread();
    }
    @Override
    public void run() {
        double nanoTime_Per_Second = 1000000000.0 / fps;
        double delta = 0;
        double lastFrame = System.nanoTime();
        double currTime;

        double time = 0;
        int count = 0;
        while (gameThread != null){
            currTime = System.nanoTime();
            delta += (currTime - lastFrame) / nanoTime_Per_Second;
            time += (currTime - lastFrame);
            lastFrame = currTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                count++;
            }

            if(time >= 1000000000){
                if(count != fps){
                    System.out.println("FPS: " + count);
                }
                count = 0;
                time -= 1000000000;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        manager.draw(g2);
        for (int i = 0; i < pixelHeight; i+=size) {
            for (int j = 0; j < pixelWidth; j+=size) {
                g2.drawRect(j,i,size,size);
            }
        }
        player.draw(g2);


        g2.dispose();
    }
    public void update(){
        player.update();
    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    private void setup(){
        // general panel setup
        setPreferredSize(new Dimension(pixelWidth + 1,pixelHeight + 1));
        setBackground(Color.gray);
        setDoubleBuffered(true);

        // Inputs
        keys = new KbInputs();
        this.addKeyListener(keys);
        mouse = new MouseInputs();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.setFocusable(true);
    }
}
