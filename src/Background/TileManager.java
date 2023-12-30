package Background;

import Utils.Tools;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TileManager extends SuperTileManager {
    GamePanel gp;
    Tools tools;
    BufferedImage originalImageGrass, originalImageStone, originalImageShadow_1, originalImageShadow_2, originalImageStair, originalImagePlant, originalImageProp, originalImageWall;
    Tile[] baseTileSet;
    BufferedImage[] shadowSet;
    BufferedImage[] stairSet;
    BufferedImage[] plantsSet;
    BufferedImage[] propsSet;
    BufferedImage[] wallSet;
    public TileManager(GamePanel gp) throws IOException {
        this.gp = gp;
        this.setUpDefault();
        tools = new Tools();
        map = setupMap();
        baseTileSet = new Tile[138];
        this.loadTiles();
        this.loadShadows();
    }
    public void setUpDefault(){
        mapTileCol = 20;
        mapTileRow = 36;
        mapPixelHeight = mapTileCol*gp.size;
        mapPixelWidth = mapTileRow*gp.size;
    }

    public void loadShadows() throws IOException {
        // Shadows load
        originalImageShadow_1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/ShadowSet1.png")));
        originalImageShadow_2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/ShadowSet2.png")));
        float opacityValue = 0.3f;
        originalImageShadow_1 = tools.changeImageOpacity(originalImageShadow_1, opacityValue);
        originalImageShadow_2 = tools.changeImageOpacity(originalImageShadow_2, opacityValue);
        shadowSet = new BufferedImage[38];

        // large tree
        shadowSet[0] = setTextureSubImage(originalImageShadow_1,0,0,134,152);
        // medium tree
        shadowSet[1] = setTextureSubImage(originalImageShadow_1,134,0,121,151);
        //small tree
        shadowSet[2] = setTextureSubImage(originalImageShadow_1,255,0,123,151);
        // bush 1
        shadowSet[3] = setTextureSubImage(originalImageShadow_1,0,151,61,67);
        // bush 2
        shadowSet[4] = setTextureSubImage(originalImageShadow_1,61,151,66,70);
        // bush 3
        shadowSet[5] = setTextureSubImage(originalImageShadow_1,127,151,70,71);
        // bush 4
        shadowSet[6] = setTextureSubImage(originalImageShadow_1,197,151,69,77);
        // bush 5
        shadowSet[7] = setTextureSubImage(originalImageShadow_1,266,151,57,81);
        // bush 6
        shadowSet[8] = setTextureSubImage(originalImageShadow_1,323,151,66,75);

        // transparent block
        shadowSet[9] = setTextureSubImage(originalImageShadow_2,0,0,71,64);
        // chest
        shadowSet[10] = setTextureSubImage(originalImageShadow_2,71,0,62,61);
        // large crate
        shadowSet[11] = setTextureSubImage(originalImageShadow_2,133,0,66,64);
        // medium ruin pillar
        shadowSet[12] = setTextureSubImage(originalImageShadow_2,199,0,60,60);
        // bench front
        shadowSet[13] = setTextureSubImage(originalImageShadow_2,259,0,96,60);
        // bench facing left
        shadowSet[14] = setTextureSubImage(originalImageShadow_2,355,0,64,63);
        // prayer statue
        shadowSet[15] = setTextureSubImage(originalImageShadow_2,446,54,37,39);
        // door closed
        shadowSet[16] = setTextureSubImage(originalImageShadow_2,29,125,47,29);
        // chest open
        shadowSet[17] = setTextureSubImage(originalImageShadow_2,97,94,38,31);
        // small crate
        shadowSet[18] = setTextureSubImage(originalImageShadow_2,163,98,31,27);
        // big ruin pillar
        shadowSet[19] = setTextureSubImage(originalImageShadow_2,228,114,36,43);
        // coffin side
        shadowSet[20] = setTextureSubImage(originalImageShadow_2,288,95,67,25);
        // bench facing right
        shadowSet[21] = setTextureSubImage(originalImageShadow_2,393,115,25,44);
        // lamp
        shadowSet[22] = setTextureSubImage(originalImageShadow_2,453,129,28,26);
        // door open
        shadowSet[23] = setTextureSubImage(originalImageShadow_2,29,194,45,25);
        // sign right
        shadowSet[24] = setTextureSubImage(originalImageShadow_2,102,176,26,16);
        // sign left
        shadowSet[25] = setTextureSubImage(originalImageShadow_2,100,240,26,16);
        // barrel
        shadowSet[26] = setTextureSubImage(originalImageShadow_2,163,165,30,26);
        // vase 1
        shadowSet[27] = setTextureSubImage(originalImageShadow_2,165,232,23,19);
        // vase 2
        shadowSet[28] = setTextureSubImage(originalImageShadow_2,164,299,28,16);
        // vase 3
        shadowSet[29] = setTextureSubImage(originalImageShadow_2,166,363,22,17);
        // small ruin pillar
        shadowSet[30] = setTextureSubImage(originalImageShadow_2,227,196,31,25);
        // coffin front
        shadowSet[31] = setTextureSubImage(originalImageShadow_2,288,166,35,46);
        // large grave tombstone
        shadowSet[32] = setTextureSubImage(originalImageShadow_2,225,257,35,23);
        // grave cross
        shadowSet[33] = setTextureSubImage(originalImageShadow_2,231,319,30,24);
        // small grave tombstone
        shadowSet[34] = setTextureSubImage(originalImageShadow_2,289,260,32,20);
        // stone cube
        shadowSet[35] = setTextureSubImage(originalImageShadow_2,288,318,39,34);
        // stone spawner
        shadowSet[36] = setTextureSubImage(originalImageShadow_2,353,269,97,72);
        // broken well
        shadowSet[37] = setTextureSubImage(originalImageShadow_2,420,365,58,43);
    }

    private BufferedImage setTextureSubImage(BufferedImage originalImage, int x,int y, int width, int height){
        BufferedImage scaledImage;
        originalImage = originalImage.getSubimage(x,y,width,height);
        scaledImage = tools.scaleImage(originalImage,width*2,height*2);

        return scaledImage;
    }

    public int[][] setupMap(){

        return new int[][]{
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,65,50,50,71,48,70},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,52,43,42,43,42,42,58},
                {70,51,48,47,49,46,46,47,49,64,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,42,42,61,63,43,42,66},
                {56,67,59,50,43,42,42,42,42,42,58,61,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,70,43,66,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,42,50,58,50,66,67,51,43,50,60,42,42,67,59,50,51,43,71,65,50,51,62,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,51,66,55,54,54,63,55,54,54,54,54,56,68,57,54,54,56,67,59,50,62,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,50,64,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,60,71,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,43,53,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,68,50,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,42,45,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,65,43,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,42,62,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,44,51,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,43,53,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,52,42,42,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,59,71,49,49,48,47,64,46,46,46,47,46,46,46,64,49,48,70,43,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,65,43,59,58,50,43,51,42,67,51,58,43,59,57,43,42,58,59,42,66,10,10,10,10,10,10,10,10},
                {42,10,10,10,10,10,10,51,58,66,10,10,10,10,10,10,10,43,50,70,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {43,42,42,42,42,43,50,66,62,10,10,10,10,10,10,10,10,51,51,59,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,50,50,51,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,59,43,43,42,42,42,42,42,42,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,43,42,42,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
        };
    }
//12, 18
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
        g2.drawImage(shadowSet[0],0,0,null);
    }

    public void loadTiles() throws IOException {
        originalImageGrass = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/GrassSet.png")));

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

        originalImageStone = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/StoneSet.png")));

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

