package Background;

import Utils.LoadSave;
import Utils.Tools;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TileManager extends SuperTileManager {
    BaseLevelData home;
    LoadSave loadSave;
    Tile[] baseTileSet;
    ArrayList<Textures> textureList;
    BufferedImage[] shadowSet;
    BufferedImage[] stairSet;
    BufferedImage[] plantSet;
    BufferedImage[] propsSet;
    BufferedImage[] wallSet;
    public TileManager(GamePanel gp) throws IOException {
        this.setUpDefault(gp);
        map = home.setupMap();
        this.loadInAssets();
        this.putIntTextures();
    }

    public void displayTextures(Graphics g2){
        for (int i = 0; i < textureList.size(); i++) {
            Textures textureCurr = textureList.get(i);
            int y_draw_from_player = textureCurr.getWorldY() - gp.player.getWorldY() + gp.player.getPlayerScreenY() + gp.player.getRaw_Player_Image_Y();
            int x_draw_from_player = textureCurr.getWorldX() - gp.player.getWorldX() + gp.player.getPlayerScreenX() + gp.player.getRaw_Player_Image_X();
            g2.drawImage(textureCurr.getImage(),x_draw_from_player,y_draw_from_player,null);
        }
    }

    private void putInTextureHelper(BufferedImage image, int worldX, int worldY){
        Textures newTexture = new Textures(image, worldX, worldY);
        textureList.add(newTexture);
    }

    public void displayTileArray(Graphics2D g2){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int worldHeightPixel = gp.size * i;
                int worldWidthPixel = gp.size * j;
                int y_draw_from_player = worldHeightPixel - gp.player.getWorldY() + gp.player.getPlayerScreenY() + gp.player.getRaw_Player_Image_Y();
                int x_draw_from_player = worldWidthPixel - gp.player.getWorldX() + gp.player.getPlayerScreenX() + gp.player.getRaw_Player_Image_X();
                int currNum = map[i][j];
                g2.drawImage(baseTileSet[currNum].getTileImage(),x_draw_from_player,y_draw_from_player,null);
            }
        }
    }
    public void draw(Graphics2D g2){
        displayTileArray(g2);
        displayTextures(g2);
    }

    public void setUpDefault(GamePanel gp){
        this.gp = gp;
        this.tools = new Tools();
        home = new BaseLevelData();
        textureList = new ArrayList<>();
        mapTileCol = 20;
        mapTileRow = 36;
        mapPixelHeight = mapTileCol*gp.size;
        mapPixelWidth = mapTileRow*gp.size;
    }
    public void putIntTextures(){
        putInAlter();
        putInPark();
    }
    private void putInAlter(){
        // perimeter of walls horizontal
        putInTextureHelper(wallSet[2],15*gp.size + 25, 0);
        putInTextureHelper(wallSet[2],21*gp.size - 25, 0);
        putInTextureHelper(wallSet[0],15*gp.size + 25,gp.size);
        putInTextureHelper(wallSet[0],20*gp.size - 25,gp.size);

        // grass tiles for under the stone
        putInTextureHelper(baseTileSet[10].getTileImage(),20*gp.size, gp.size);
        putInTextureHelper(baseTileSet[10].getTileImage(),17*gp.size, gp.size);

        // grass tiles that fill up the alters top
        putInTextureHelper(baseTileSet[31].getTileImage(),16*gp.size, gp.size);
        putInTextureHelper(baseTileSet[20].getTileImage(),16*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[19].getTileImage(),17*gp.size, 0);
        putInTextureHelper(baseTileSet[41].getTileImage(),17*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[17].getTileImage(),18*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[36].getTileImage(),19*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[16].getTileImage(),20*gp.size, 0);
        putInTextureHelper(baseTileSet[27].getTileImage(),20*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[33].getTileImage(),21*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[16].getTileImage(),21*gp.size, gp.size);

        // half tiles covering the outside
        putInTextureHelper(baseTileSet[10].getTileImage(),15*gp.size, gp.size);
        putInTextureHelper(baseTileSet[10].getTileImage(),15*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[10].getTileImage(),22*gp.size, gp.size);
        putInTextureHelper(baseTileSet[10].getTileImage(),22*gp.size, 2*gp.size);

        // stone tiles for the items
        putInTextureHelper(baseTileSet[99].getTileImage(),18*gp.size, gp.size);
        putInTextureHelper(baseTileSet[99].getTileImage(),19*gp.size, gp.size);
        putInTextureHelper(baseTileSet[98].getTileImage(),17*gp.size, gp.size);
        putInTextureHelper(baseTileSet[100].getTileImage(),20*gp.size, gp.size);

        // left and right vertical perimeter connector pieces
        putInTextureHelper(wallSet[7],22*gp.size + 23, gp.size/2 - 26);
        putInTextureHelper(wallSet[8],15*gp.size + 25, gp.size/2 - 24);

        // horizontal for top connection for perimeter
        putInTextureHelper(wallSet[9], (16*gp.size), 0);
        putInTextureHelper(wallSet[9], (19*gp.size), 0);

        // stairs
        putInTextureHelper(stairSet[3],18*gp.size,3*gp.size);

        // shadows for bush
        putInTextureHelper(shadowSet[5],21*gp.size + gp.quarterTile,gp.halfTile);
        // shadows for bush
        putInTextureHelper(shadowSet[6],16*gp.size + gp.quarterTile,gp.halfTile);

        // bush top right and left
        putInTextureHelper(plantSet[5],21*gp.size,0);
        putInTextureHelper(plantSet[6],16*gp.size,0);

        // grass blades around stone
        putInTextureHelper(plantSet[18],18*gp.size,gp.quarterTile + 10);
        putInTextureHelper(plantSet[9],17*gp.size,gp.size + gp.halfTile);
        putInTextureHelper(plantSet[15],19*gp.size,gp.size + gp.halfTile);
    }

    private void putInPark(){

        // corners
        putInTextureHelper(wallSet[10],10*gp.size + gp.halfTile + gp.quarterTile,8*gp.size - gp.quarterTile);
        putInTextureHelper(wallSet[11],26*gp.size,8*gp.size - gp.quarterTile);

        putInTextureHelper(wallSet[12],10*gp.size + gp.halfTile + gp.quarterTile,13*gp.size);
        putInTextureHelper(wallSet[12],23*gp.size + gp.quarterTile,13*gp.size);

        // vertical wall elements
        putInTextureHelper(wallSet[8],10*gp.size + gp.halfTile + gp.quarterTile,8*gp.size);
        putInTextureHelper(wallSet[8],10*gp.size + gp.halfTile + gp.quarterTile,10*gp.size);

        putInTextureHelper(wallSet[8],26*gp.size ,8*gp.size);
        putInTextureHelper(wallSet[8],26*gp.size ,10*gp.size);

        // horizontal wall elements
        putInTextureHelper(wallSet[9],13*gp.size,8*gp.size - gp.quarterTile);
        putInTextureHelper(wallSet[9],16*gp.size,8*gp.size - gp.quarterTile);
        putInTextureHelper(wallSet[9],19*gp.size,8*gp.size - gp.quarterTile);
        putInTextureHelper(wallSet[9],22*gp.size,8*gp.size - gp.quarterTile);
        putInTextureHelper(wallSet[9],23*gp.size,8* gp.size - gp.quarterTile);
        putInTextureHelper(wallSet[13],13*gp.size,13*gp.size - gp.quarterTile + 6);
        putInTextureHelper(wallSet[13],16*gp.size,13*gp.size - gp.quarterTile + 6);
        putInTextureHelper(wallSet[13],19*gp.size,13*gp.size - gp.quarterTile + 6);
        putInTextureHelper(wallSet[13],22*gp.size,13*gp.size - gp.quarterTile + 6);

        // shadows
        putInTextureHelper(shadowSet[36],17*gp.size,9*gp.size + gp.quarterTile);
        putInTextureHelper(shadowSet[12],23*gp.size + 3,8*gp.size + gp.halfTile + 5);
        putInTextureHelper(shadowSet[30],22*gp.size + 3,11*gp.size - 10);
        putInTextureHelper(shadowSet[30],14*gp.size + 6,11*gp.size + gp.quarterTile + 3);
        putInTextureHelper(shadowSet[19],16*gp.size,8*gp.size + 12);
        putInTextureHelper(shadowSet[13],18*gp.size - gp.quarterTile,8*gp.size);
        putInTextureHelper(shadowSet[1],23*gp.size + gp.quarterTile,8*gp.size);
        putInTextureHelper(shadowSet[1],10*gp.size + gp.quarterTile,11*gp.size + gp.halfTile);
        putInTextureHelper(shadowSet[2],24*gp.size + gp.halfTile,11*gp.size + gp.halfTile);
        putInTextureHelper(shadowSet[2],11*gp.size + gp.halfTile,8*gp.size + gp.quarterTile);
        putInTextureHelper(shadowSet[24],21*gp.size + 10,12*gp.size + gp.quarterTile);
        putInTextureHelper(shadowSet[25],15*gp.size + 10,12*gp.size + gp.quarterTile);

        // spawner in middle
        putInTextureHelper(propsSet[32],17*gp.size,9*gp.size + gp.quarterTile);

        // pillars
        putInTextureHelper(propsSet[13],23*gp.size,8*gp.size);
        putInTextureHelper(propsSet[15],22*gp.size,10*gp.size + gp.halfTile);
        putInTextureHelper(propsSet[14],16*gp.size,8*gp.size - gp.halfTile);
        putInTextureHelper(propsSet[15],14*gp.size,11*gp.size);

        // trees
        putInTextureHelper(plantSet[1],23*gp.size,5*gp.size + gp.quarterTile);
        putInTextureHelper(plantSet[2],24*gp.size + gp.quarterTile,9*gp.size);
        putInTextureHelper(plantSet[1],10*gp.size,9*gp.size - gp.quarterTile);
        putInTextureHelper(plantSet[2],11*gp.size + gp.quarterTile,6*gp.size - gp.quarterTile);

        // benches
        putInTextureHelper(propsSet[22],17*gp.size + gp.halfTile,7*gp.size + gp.halfTile);

        // signs
        putInTextureHelper(propsSet[5],21*gp.size,12*gp.size - gp.quarterTile);
        putInTextureHelper(propsSet[6],15*gp.size,12*gp.size - gp.quarterTile);
    }
    public void loadInAssets() throws IOException {
        loadSave = new LoadSave();
        baseTileSet = loadSave.loadTileSet(138,gp.size,"GrassSet.png","StoneSet.png");
        wallSet = loadSave.loadWallSet(14,"WallSet.png","curve1.png");
        shadowSet = loadSave.loadShadowSet(38,"ShadowSet1.png", "ShadowSet2.png");
        stairSet = loadSave.loadStairSet(8,"StairSet.png");
        plantSet = loadSave.loadPlantSet(25,"PlantSet.png");
        propsSet = loadSave.loadPropSet(48,"PropsSet.png");
    }
}

