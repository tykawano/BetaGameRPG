package Background;

import Utils.LoadSave;
import Utils.Tools;
import main.GamePanel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HomeBase extends Super_Level{
    BufferedImage[] baseTileSet;
    BufferedImage[] shadowSet;
    BufferedImage[] stairSet;
    BufferedImage[] plantSet;
    BufferedImage[] propsSet;
    BufferedImage[] wallSet;
    BufferedImage[] villageSet;

    public HomeBase(GamePanel gp, LoadSave loadSave){
        super(gp, loadSave);
        setUpDefault();
        initTextureArrays();
        putIntTextures();
    }
    public void initTextureArrays(){
        baseTileSet = loadSave.getBaseTileSet();
        shadowSet = loadSave.getShadowSet();
        stairSet = loadSave.getStairSet();
        plantSet = loadSave.getPlantSet();
        propsSet = loadSave.getPropsSet();
        wallSet = loadSave.getWallSet();
        villageSet = loadSave.getVillageSet();
    }


    public void setUpDefault(){
        this.tools = new Tools();
        texturesList = new ArrayList<>();
        mapTileCol = 20;
        mapTileRow = 36;
        mapPixelHeight = mapTileCol*gp.size;
        mapPixelWidth = mapTileRow*gp.size;
        map = setupMap();
    }
    public void putIntTextures(){
        putInBackgroundTiles();
        putInAlter();
        putInPark();
    }
    private void putInTextureHelper(BufferedImage image, int worldX, int worldY){
        Textures newTexture = new Textures(image, worldX, worldY);
        texturesList.add(newTexture);
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
    private void putInBackgroundTiles() {
        int[][] mapLevel = setupMap();
        for (int i = 0; i < mapLevel.length; i++) {
            for (int j = 0; j < mapLevel[i].length; j++) {
                int worldHeightPixel = gp.size * i;
                int worldWidthPixel = gp.size * j;
                int currNum = mapLevel[i][j];
                texturesList.add(new Textures(baseTileSet[currNum], worldWidthPixel, worldHeightPixel));
            }
        }
    }
    private void putInAlter(){
        // perimeter of walls horizontal
        putInTextureHelper(wallSet[2],15*gp.size + 25, 0);
        putInTextureHelper(wallSet[2],21*gp.size - 25, 0);
        putInTextureHelper(wallSet[0],15*gp.size + 25,gp.size);
        putInTextureHelper(wallSet[0],20*gp.size - 25,gp.size);

        // grass tiles for under the stone
        putInTextureHelper(baseTileSet[10],20*gp.size, gp.size);
        putInTextureHelper(baseTileSet[10],17*gp.size, gp.size);

        // grass tiles that fill up the alter top
        putInTextureHelper(baseTileSet[31],16*gp.size, gp.size);
        putInTextureHelper(baseTileSet[20],16*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[19],17*gp.size, 0);
        putInTextureHelper(baseTileSet[41],17*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[17],18*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[36],19*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[16],20*gp.size, 0);
        putInTextureHelper(baseTileSet[27],20*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[33],21*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[16],21*gp.size, gp.size);

        // half-tiles covering the outside
        putInTextureHelper(baseTileSet[10],15*gp.size, gp.size);
        putInTextureHelper(baseTileSet[10],15*gp.size, 2*gp.size);
        putInTextureHelper(baseTileSet[10],22*gp.size, gp.size);
        putInTextureHelper(baseTileSet[10],22*gp.size, 2*gp.size);

        // stone tiles for the items
        putInTextureHelper(baseTileSet[99],18*gp.size, gp.size);
        putInTextureHelper(baseTileSet[99],19*gp.size, gp.size);
        putInTextureHelper(baseTileSet[98],17*gp.size, gp.size);
        putInTextureHelper(baseTileSet[100],20*gp.size, gp.size);

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

    @Override
    public ArrayList<Textures> getTexturesList() {
        return super.getTexturesList();
    }
}
