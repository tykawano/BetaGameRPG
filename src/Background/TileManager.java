package Background;

import Utils.Tools;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TileManager extends SuperTileManager {
    Tile[] baseTileSet;
    ArrayList<Textures> textureList;
    BufferedImage[] shadowSet;
    BufferedImage[] stairSet;
    BufferedImage[] plantSet;
    BufferedImage[] propsSet;
    BufferedImage[] wallSet;
    public TileManager(GamePanel gp) throws IOException {
        this.setUpDefault(gp);
        map = setupMap();
        this.loadTileSet();
        this.loadTextures();
        this.putIntTextures();
    }

    public void draw(Graphics2D g2){
        displayTileArray(g2);
        displayTextures(g2);
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
    public void putIntTextures(){
        putInAlter();
        putInPark();
    }
    public int[][] setupMap(){

        return new int[][]{
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,37,10,25,12,10,21,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,65,50,50,71,48,70},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,52,43,42,43,42,42,58},
                {70,51,48,47,49,46,46,47,49,64,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,42,42,61,63,43,42,66},
                {56,67,59,50,43,42,42,42,42,42,58,61,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,70,43,66,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,42,50,58,50,66,67,51,43,50,60,42,42,67,59,50,51,43,71,65,50,51,62,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,51,66,55,54,54,63,55,54,54,54,54,56,68,57,54,54,56,67,59,50,62,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,50,64,43,43,43,66,21,14,29,25,37,25,18,67,42,42,42,60,71,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,43,53,43,65,66,17,31,24,26,28,27,17,19,40,67,65,42,68,50,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,42,45,43,43,29,39,32,15,22,31,21,23,41,28,39,42,42,65,43,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,42,62,43,43,71,10,10,35,12,11,30,20,26,16,70,42,42,44,51,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,43,53,54,43,43,71,19,12,39,40,29,41,39,70,42,42,62,52,42,42,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,59,71,49,49,48,47,64,46,46,46,47,46,46,46,64,49,48,70,43,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,65,43,59,58,50,43,51,42,67,51,58,43,59,57,43,42,58,59,42,66,10,10,10,10,10,10,10,10},
                {42,10,10,10,10,10,10,51,58,66,10,10,10,10,10,10,10,43,50,70,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {43,42,42,42,42,43,50,66,62,10,10,10,10,10,10,10,10,51,51,59,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,50,50,51,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,59,43,43,42,42,42,42,42,42,10,10,10,10,10,10,10,10,10,10},
                {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,43,42,42,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
        };
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

    public void setUpDefault(GamePanel gp){
        this.gp = gp;
        this.tools = new Tools();
        textureList = new ArrayList<>();
        mapTileCol = 20;
        mapTileRow = 36;
        mapPixelHeight = mapTileCol*gp.size;
        mapPixelWidth = mapTileRow*gp.size;
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
    public void loadTileSet() throws IOException {
        baseTileSet = new Tile[138];
        BufferedImage originalImageGrass = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/GrassSet.png")));

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

        BufferedImage originalImageStone = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/StoneSet.png")));

        for (int i = 0; i < originalImageStone.getHeight(); i+=32) {
            for (int j = 0; j < originalImageStone.getWidth(); j+=32) {
                temp = originalImageStone.getSubimage(j,i,32,32);
                temp = tools.scaleImage(temp, gp.size,gp.size);
                baseTileSet[index] = new Tile(temp, "Stone");
                index++;
            }
        }
    }
    public void loadTextures() throws IOException {
        loadShadowSet();
        loadStairSet();
        loadPlantSet();
        loadPropSet();
        loadWallSet();
    }
    private void loadWallSet() throws IOException {
        BufferedImage originalImageWall = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/WallSet.png")));
        BufferedImage originalCurve = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/curve1.png")));
        wallSet = new BufferedImage[14];

        // up-high and down-low, small up-high structures
        wallSet[0] = setTextureSubImage(originalImageWall,32,32,96,128);
        wallSet[1] = setTextureSubImage(originalImageWall,152,32,114,104);
        wallSet[2] = setTextureSubImage(originalImageWall,384,64,64,96);
        // large wall piece, small wall piece normal, small wall piece damaged
        wallSet[3] = setTextureSubImage(originalImageWall,32,192,128,64);
        wallSet[4] = setTextureSubImage(originalImageWall,32,288,64,64);
        wallSet[5] = setTextureSubImage(originalImageWall,128,288,64,64);
        // small wall with window
        wallSet[6] = setTextureSubImage(originalImageWall,192,192,32,64);
        // railing verticals
        wallSet[7] = setTextureSubImage(originalImageWall,288,32,13,96);
        wallSet[8] = setTextureSubImage(originalImageWall,344,32,12,96);
        // railing horizontal
        wallSet[9] = setTextureSubImage(originalImageWall,384,32,96,13);
        // curved railings
        wallSet[10] = setTextureSubImage(originalCurve,0,0,96,8);
        wallSet[11] = tools.rotateClockwise90Degrees(wallSet[10]);
        wallSet[12] = tools.flipVertically(wallSet[10]);

        // railing horizontal bottom
        wallSet[13] = tools.flipVertically(wallSet[9]);
    }

    private void loadShadowSet() throws IOException {
        // Shadows load
        BufferedImage originalImageShadow_1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/ShadowSet1.png")));
        BufferedImage originalImageShadow_2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/ShadowSet2.png")));
        float opacityValue = 0.3f;
        originalImageShadow_1 = tools.changeImageOpacity(originalImageShadow_1, opacityValue);
        originalImageShadow_2 = tools.changeImageOpacity(originalImageShadow_2, opacityValue);
        shadowSet = new BufferedImage[38];

        // large tree
        shadowSet[0] = setTextureSubImage(originalImageShadow_1,48,100,86,52);
        // medium tree
        shadowSet[1] = setTextureSubImage(originalImageShadow_1,173,105,82,46);
        //small tree
        shadowSet[2] = setTextureSubImage(originalImageShadow_1,304,111,74,41);
        // bush 1
        shadowSet[3] = setTextureSubImage(originalImageShadow_1,39,207,22,12);
        // bush 2
        shadowSet[4] = setTextureSubImage(originalImageShadow_1,99,205,28,17);
        // bush 3
        shadowSet[5] = setTextureSubImage(originalImageShadow_1,160,206,37,17);
        // bush 4
        shadowSet[6] = setTextureSubImage(originalImageShadow_1,220,205,46,24);
        // bush 5
        shadowSet[7] = setTextureSubImage(originalImageShadow_1,285,209,38,24);
        // bush 6
        shadowSet[8] = setTextureSubImage(originalImageShadow_1,348,198,41,29);

        // transparent block
        shadowSet[9] = setTextureSubImage(originalImageShadow_2,32,30,39,34);
        // chest
        shadowSet[10] = setTextureSubImage(originalImageShadow_2,97,42,36,19);
        // large crate
        shadowSet[11] = setTextureSubImage(originalImageShadow_2,160,30,39,34);
        // medium ruin pillar
        shadowSet[12] = setTextureSubImage(originalImageShadow_2,228,29,31,31);
        // bench front
        shadowSet[13] = setTextureSubImage(originalImageShadow_2,295,36,60,24);
        // bench facing left
        shadowSet[14] = setTextureSubImage(originalImageShadow_2,387,15,32,63);
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
    private void loadStairSet() throws IOException {
        BufferedImage originalImageStair = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/StairSet.png")));
        stairSet = new BufferedImage[8];

        // no moss stairs both, right, left
        stairSet[0] = setTextureSubImage(originalImageStair,32,32,64,96);
        stairSet[1] = setTextureSubImage(originalImageStair,128,32,65,96);
        stairSet[2] = setTextureSubImage(originalImageStair,224,32,65,96);

        // moss stairs both, right, left
        stairSet[3] = setTextureSubImage(originalImageStair,32,160,64,96);
        stairSet[4] = setTextureSubImage(originalImageStair,128,160,65,96);
        stairSet[5] = setTextureSubImage(originalImageStair,224,160,65,96);

        // archway with edge ont top
        stairSet[6] = setTextureSubImage(originalImageStair,408,27,80,64);
        stairSet[7] = setTextureSubImage(originalImageStair,416,128,64,64);
    }
    private void loadPlantSet() throws IOException {
        BufferedImage originalImagePlant = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/PlantSet.png")));
        plantSet = new BufferedImage[25];

        // Trees small, medium and large
        plantSet[0] = setTextureSubImage(originalImagePlant,24,14,113,139);
        plantSet[1] = setTextureSubImage(originalImagePlant,161,17,95,136);
        plantSet[2] = setTextureSubImage(originalImagePlant,295,31,79,120);

        // bushes small to big
        plantSet[3] = setTextureSubImage(originalImagePlant,38,198,22,19);
        plantSet[4] = setTextureSubImage(originalImagePlant,98,195,27,25);
        plantSet[5] = setTextureSubImage(originalImagePlant,156,190,38,32);
        plantSet[6] = setTextureSubImage(originalImagePlant,216,185,47,42);
        plantSet[7] = setTextureSubImage(originalImagePlant,282,186,39,45);
        plantSet[8] = setTextureSubImage(originalImagePlant,346,190,40,35);

        // blades of grass
        int index = 9;
        for (int i = 384; i < 512; i+=32) {
            for (int j = 0; j < 128; j+=32) {
                plantSet[index] = setTextureSubImage(originalImagePlant,j,i,32,32);
                index++;
            }
        }
    }
    private void loadPropSet() throws IOException {
        BufferedImage originalImageProp = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/PropsSet.png")));
        propsSet = new BufferedImage[48];
        // transparent cube
        propsSet[0] = setTextureSubImage(originalImageProp,32,18,64,64);
        // door open and close
        propsSet[1] = setTextureSubImage(originalImageProp,29,103,37,50);
        propsSet[2] = setTextureSubImage(originalImageProp,29,166,37,53);
        // chest closed and open
        propsSet[3] = setTextureSubImage(originalImageProp,96,30,32,31);
        propsSet[4] = setTextureSubImage(originalImageProp,96,76,32,49);
        // right and left sign
        propsSet[5] = setTextureSubImage(originalImageProp,99,160,27,32);
        propsSet[6] = setTextureSubImage(originalImageProp,96,224,27,32);
        // Crate large and small
        propsSet[7] = setTextureSubImage(originalImageProp,160,18,32,46);
        propsSet[8] = setTextureSubImage(originalImageProp,163,86,26,39);
        // barrel
        propsSet[9] = setTextureSubImage(originalImageProp,162,153,28,36);
        // vase 1,2 and 3
        propsSet[10] = setTextureSubImage(originalImageProp,165,217,21,34);
        propsSet[11] = setTextureSubImage(originalImageProp,164,288,25,27);
        propsSet[12] = setTextureSubImage(originalImageProp,165,348,21,32);
        // ruin pillars medium, large, and small
        propsSet[13] = setTextureSubImage(originalImageProp,227,9,26,52);
        propsSet[14] = setTextureSubImage(originalImageProp,227,91,26,66);
        propsSet[15] = setTextureSubImage(originalImageProp,227,183,26,38);
        // grave tombstone, cross, and small tombstone
        propsSet[16] = setTextureSubImage(originalImageProp,225,239,30,41);
        propsSet[17] = setTextureSubImage(originalImageProp,227,303,26,40);
        propsSet[18] = setTextureSubImage(originalImageProp,289,251,30,29);
        // ruin lighting medium, large, and small
        propsSet[19] = setTextureSubImage(originalImageProp,270,29,5,26);
        propsSet[20] = setTextureSubImage(originalImageProp,270,111,5,40);
        propsSet[21] = setTextureSubImage(originalImageProp,270,203,5,12);
        // bench looking front, left and right
        propsSet[22] = setTextureSubImage(originalImageProp,292,19,56,41);
        propsSet[23] = setTextureSubImage(originalImageProp,387,2,27,61);
        propsSet[24] = setTextureSubImage(originalImageProp,387,98,27,61);
        // coffin sideways and upright
        propsSet[25] = setTextureSubImage(originalImageProp,288,87,64,36);
        propsSet[26] = setTextureSubImage(originalImageProp,288,158,32,57);
        // stone cube
        propsSet[27] = setTextureSubImage(originalImageProp,288,306,32,46);
        // angel statue
        propsSet[28] = setTextureSubImage(originalImageProp,445,21,37,72);
        // lamp
        propsSet[29] = setTextureSubImage(originalImageProp,453,118,22,37);
        // pillar and broken pillar
        propsSet[30] = setTextureSubImage(originalImageProp,352,174,32,77);
        propsSet[31] = setTextureSubImage(originalImageProp,416,194,32,57);
        //spawner
        propsSet[32] = setTextureSubImage(originalImageProp,353,269,94,72);
        // broken well
        propsSet[33] = setTextureSubImage(originalImageProp,420,359,55,49);
        // small ruins for spawner
        propsSet[34] = setTextureSubImage(originalImageProp,330,266,5,5);
        propsSet[35] = setTextureSubImage(originalImageProp,330,273,5,5);
        propsSet[36] = setTextureSubImage(originalImageProp,337,266,5,5);
        propsSet[37] = setTextureSubImage(originalImageProp,337,273,5,5);
        // Huge rock
        propsSet[38] = setTextureSubImage(originalImageProp,3,430,57,42);
        // regular rocks smallest to largest
        propsSet[39] = setTextureSubImage(originalImageProp,10,492,11,10);
        propsSet[40] = setTextureSubImage(originalImageProp,40,490,16,14);
        propsSet[41] = setTextureSubImage(originalImageProp,68,487,25,19);
        propsSet[42] = setTextureSubImage(originalImageProp,100,487,24,19);
        propsSet[43] = setTextureSubImage(originalImageProp,130,484,27,22);
        propsSet[44] = setTextureSubImage(originalImageProp,162,482,27,27);
        // bricks increasing in quantity
        propsSet[45] = setTextureSubImage(originalImageProp,231,489,18,16);
        propsSet[46] = setTextureSubImage(originalImageProp,263,488,19,16);
        propsSet[47] = setTextureSubImage(originalImageProp,289,486,31,19);
    }
    private BufferedImage setTextureSubImage(BufferedImage originalImage, int x,int y, int width, int height){
        BufferedImage scaledImage;
        originalImage = originalImage.getSubimage(x,y,width,height);
        scaledImage = tools.scaleImage(originalImage,width*2,height*2);

        return scaledImage;
    }



}

