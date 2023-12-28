package Background;

import Utils.Tools;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    BufferedImage originalImageGrass, originalImageStone;
    Tile[] baseTileSet;
    int[][] map;
    public final int mapTileCol = 20;
    public final int mapTileRow = 36;
    public final int mapPixelHeight = 20*64;
    public final int mapPixelWidth = 36*64;
    public TileManager(GamePanel gp) throws IOException {
        this.gp = gp;
        map = setupMap();
        baseTileSet = new Tile[138];
        this.loadTiles();
    }

    public int[][] setupMap(){

        return new int[][]{
                {97,67,137,28,89,95,45,100,111,29,55,88,135,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
        };
    }

    public void displayTileArray(Graphics2D g2){
        int height = 0;
        int width;
        for (int i = 0; i < map.length; i++) {
            width = 0;
            for (int j = 0; j < map[i].length; j++) {
                int currNum = map[i][j];
                g2.drawImage(baseTileSet[currNum].getTileImage(),width,height,null);
                width += gp.size;
            }
            height += gp.size;
        }
    }


    public void draw(Graphics2D g2){
        displayTileArray(g2);
    }

    public void loadTiles() throws IOException {
        Tools tools = new Tools();
        originalImageGrass = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/TX Tileset Grass.png")));

        BufferedImage temp;
        int index = 10;
        for (int i = 0; i < originalImageGrass.getHeight(); i+=32) {
            for (int j = 0; j < originalImageGrass.getWidth(); j+=32) {
                temp = originalImageGrass.getSubimage(j,i,32,32);
                temp = tools.scaleImage(temp, gp.size,gp.size);
                baseTileSet[index] = new Tile(temp, "Grass");
                index++;
            }
        }

        originalImageStone = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/TX Tileset Stone Ground.png")));

        for (int i = 0; i < originalImageStone.getHeight(); i+=32) {
            for (int j = 0; j < originalImageStone.getWidth(); j+=32) {
                temp = originalImageStone.getSubimage(j,i,32,32);
                temp = tools.scaleImage(temp, gp.size,gp.size);
                baseTileSet[index] = new Tile(temp, "Stone");
                index++;
            }
        }


    }



}

