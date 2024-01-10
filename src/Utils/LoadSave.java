package Utils;


import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class LoadSave {
    GamePanel gp;
    Tools tools;
    BufferedImage[] baseTileSet;
    BufferedImage[] shadowSet;
    BufferedImage[] stairSet;
    BufferedImage[] plantSet;
    BufferedImage[] propsSet;
    BufferedImage[] wallSet;
    BufferedImage[] villageSet;
    public LoadSave(GamePanel gp) throws IOException {
        this.gp = gp;
        tools = new Tools();
        loadInAssets();
    }
    public void loadInAssets() throws IOException {
        baseTileSet = loadTileSet(138,gp.size,"GrassSet.png","StoneSet.png");
        wallSet = loadWallSet(14,"WallSet.png","curve1.png");
        shadowSet = loadShadowSet(38,"ShadowSet1.png", "ShadowSet2.png");
        stairSet = loadStairSet(8,"StairSet.png");
        plantSet = loadPlantSet(25,"PlantSet.png");
        propsSet = loadPropSet(48,"PropsSet.png");
        villageSet = loadVillageSet(55,"Village.png","singleHouse.png");
    }
    public BufferedImage[] loadTileSet(int size, int tileSizeScale, String path, String path2) throws IOException {
        BufferedImage[] baseTileSet = new BufferedImage[size];
        BufferedImage originalImageGrass = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path)));
        BufferedImage temp;
        int index = 10;
        for (int i = 0; i < originalImageGrass.getHeight(); i+=32) {
            for (int j = 0; j < originalImageGrass.getWidth(); j+=32) {
                temp = originalImageGrass.getSubimage(j,i,32,32);
                temp = tools.scaleImage(temp, tileSizeScale,tileSizeScale);
                baseTileSet[index] = temp;
                index++;
            }
        }

        BufferedImage originalImageStone = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path2)));

        for (int i = 0; i < originalImageStone.getHeight(); i+=32) {
            for (int j = 0; j < originalImageStone.getWidth(); j+=32) {
                temp = originalImageStone.getSubimage(j,i,32,32);
                temp = tools.scaleImage(temp, tileSizeScale,tileSizeScale);
                baseTileSet[index] = temp;
                index++;
            }
        }

        return baseTileSet;
    }

    public BufferedImage[] loadWallSet(int size,String path1, String path2) throws IOException {
        BufferedImage originalImageWall = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path1)));
        BufferedImage originalCurve = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path2)));
        BufferedImage[] wallSet = new BufferedImage[size];

        // up-high and down-low, small up-high structures
        wallSet[0] = tools.setTextureSubImage(originalImageWall,32,32,96,128);
        wallSet[1] = tools.setTextureSubImage(originalImageWall,152,32,114,104);
        wallSet[2] = tools.setTextureSubImage(originalImageWall,384,64,64,96);
        // large wall piece, small wall piece normal, small wall piece damaged
        wallSet[3] = tools.setTextureSubImage(originalImageWall,32,192,128,64);
        wallSet[4] = tools.setTextureSubImage(originalImageWall,32,288,64,64);
        wallSet[5] = tools.setTextureSubImage(originalImageWall,128,288,64,64);
        // small wall with window
        wallSet[6] = tools.setTextureSubImage(originalImageWall,192,192,32,64);
        // railing verticals
        wallSet[7] = tools.setTextureSubImage(originalImageWall,288,32,13,96);
        wallSet[8] = tools.setTextureSubImage(originalImageWall,344,32,12,96);
        // railing horizontal
        wallSet[9] = tools.setTextureSubImage(originalImageWall,384,32,96,13);
        // curved railings
        wallSet[10] = tools.setTextureSubImage(originalCurve,0,0,96,8);
        wallSet[11] = tools.rotateClockwise90Degrees(wallSet[10]);
        wallSet[12] = tools.flipVertically(wallSet[10]);

        // railing horizontal bottom
        wallSet[13] = tools.flipVertically(wallSet[9]);

        return wallSet;
    }

    public BufferedImage[] loadShadowSet(int size, String path1, String path2) throws IOException {
        // Shadows load
        BufferedImage originalImageShadow_1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path1)));
        BufferedImage originalImageShadow_2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path2)));
        float opacityValue = 0.2f;
        originalImageShadow_1 = tools.changeImageOpacity(originalImageShadow_1, opacityValue);
        originalImageShadow_2 = tools.changeImageOpacity(originalImageShadow_2, opacityValue);
        BufferedImage[] shadowSet = new BufferedImage[size];

        // large tree
        shadowSet[0] = tools.setTextureSubImage(originalImageShadow_1,48,100,86,52);
        // medium tree
        shadowSet[1] = tools.setTextureSubImage(originalImageShadow_1,173,105,82,46);
        //small tree
        shadowSet[2] = tools.setTextureSubImage(originalImageShadow_1,304,111,74,41);
        // bush 1
        shadowSet[3] = tools.setTextureSubImage(originalImageShadow_1,39,207,22,12);
        // bush 2
        shadowSet[4] = tools.setTextureSubImage(originalImageShadow_1,99,205,28,17);
        // bush 3
        shadowSet[5] = tools.setTextureSubImage(originalImageShadow_1,160,206,37,17);
        // bush 4
        shadowSet[6] = tools.setTextureSubImage(originalImageShadow_1,220,205,46,24);
        // bush 5
        shadowSet[7] = tools.setTextureSubImage(originalImageShadow_1,285,209,38,24);
        // bush 6
        shadowSet[8] = tools.setTextureSubImage(originalImageShadow_1,348,198,41,29);

        // transparent block
        shadowSet[9] = tools.setTextureSubImage(originalImageShadow_2,32,30,39,34);
        // chest
        shadowSet[10] = tools.setTextureSubImage(originalImageShadow_2,97,42,36,19);
        // large crate
        shadowSet[11] = tools.setTextureSubImage(originalImageShadow_2,160,30,39,34);
        // medium ruin pillar
        shadowSet[12] = tools.setTextureSubImage(originalImageShadow_2,228,29,31,31);
        // bench front
        shadowSet[13] = tools.setTextureSubImage(originalImageShadow_2,295,36,60,24);
        // bench facing left
        shadowSet[14] = tools.setTextureSubImage(originalImageShadow_2,387,15,32,63);
        // prayer statue
        shadowSet[15] = tools.setTextureSubImage(originalImageShadow_2,446,54,37,39);
        // door closed
        shadowSet[16] = tools.setTextureSubImage(originalImageShadow_2,29,125,47,29);
        // chest open
        shadowSet[17] = tools.setTextureSubImage(originalImageShadow_2,97,94,38,31);
        // small crate
        shadowSet[18] = tools.setTextureSubImage(originalImageShadow_2,163,98,31,27);
        // big ruin pillar
        shadowSet[19] = tools.setTextureSubImage(originalImageShadow_2,228,114,36,43);
        // coffin side
        shadowSet[20] = tools.setTextureSubImage(originalImageShadow_2,288,95,67,25);
        // bench facing right
        shadowSet[21] = tools.setTextureSubImage(originalImageShadow_2,393,115,25,44);
        // lamp
        shadowSet[22] = tools.setTextureSubImage(originalImageShadow_2,453,129,28,26);
        // door open
        shadowSet[23] = tools.setTextureSubImage(originalImageShadow_2,29,194,45,25);
        // sign right
        shadowSet[24] = tools.setTextureSubImage(originalImageShadow_2,102,176,26,16);
        // sign left
        shadowSet[25] = tools.setTextureSubImage(originalImageShadow_2,100,240,26,16);
        // barrel
        shadowSet[26] = tools.setTextureSubImage(originalImageShadow_2,163,165,30,26);
        // vase 1
        shadowSet[27] = tools.setTextureSubImage(originalImageShadow_2,165,232,23,19);
        // vase 2
        shadowSet[28] = tools.setTextureSubImage(originalImageShadow_2,164,299,28,16);
        // vase 3
        shadowSet[29] = tools.setTextureSubImage(originalImageShadow_2,166,363,22,17);
        // small ruin pillar
        shadowSet[30] = tools.setTextureSubImage(originalImageShadow_2,227,196,31,25);
        // coffin front
        shadowSet[31] = tools.setTextureSubImage(originalImageShadow_2,288,166,35,46);
        // large grave tombstone
        shadowSet[32] = tools.setTextureSubImage(originalImageShadow_2,225,257,35,23);
        // grave cross
        shadowSet[33] = tools.setTextureSubImage(originalImageShadow_2,231,319,30,24);
        // small grave tombstone
        shadowSet[34] = tools.setTextureSubImage(originalImageShadow_2,289,260,32,20);
        // stone cube
        shadowSet[35] = tools.setTextureSubImage(originalImageShadow_2,288,318,39,34);
        // stone spawner
        shadowSet[36] = tools.setTextureSubImage(originalImageShadow_2,353,269,97,72);
        // broken well
        shadowSet[37] = tools.setTextureSubImage(originalImageShadow_2,420,365,58,43);

        return shadowSet;
    }

    public BufferedImage[] loadStairSet(int size, String path) throws IOException {
        BufferedImage originalImageStair = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path)));
        BufferedImage[] stairSet = new BufferedImage[size];

        // no moss stairs both, right, left
        stairSet[0] = tools.setTextureSubImage(originalImageStair,32,32,64,96);
        stairSet[1] = tools.setTextureSubImage(originalImageStair,128,32,65,96);
        stairSet[2] = tools.setTextureSubImage(originalImageStair,224,32,65,96);

        // moss stairs both, right, left
        stairSet[3] = tools.setTextureSubImage(originalImageStair,32,160,64,96);
        stairSet[4] = tools.setTextureSubImage(originalImageStair,128,160,65,96);
        stairSet[5] = tools.setTextureSubImage(originalImageStair,224,160,65,96);

        // archway with edge ont top
        stairSet[6] = tools.setTextureSubImage(originalImageStair,408,27,80,64);
        stairSet[7] = tools.setTextureSubImage(originalImageStair,416,128,64,64);

        return stairSet;
    }
    public BufferedImage[] loadPlantSet(int size, String path) throws IOException {
        BufferedImage originalImagePlant = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path)));
        BufferedImage[] plantSet = new BufferedImage[size];

        // Trees small, medium and large
        plantSet[0] = tools.setTextureSubImage(originalImagePlant,24,14,113,139);
        plantSet[1] = tools.setTextureSubImage(originalImagePlant,161,17,95,136);
        plantSet[2] = tools.setTextureSubImage(originalImagePlant,295,31,79,120);

        // bushes small to big
        plantSet[3] = tools.setTextureSubImage(originalImagePlant,38,198,22,19);
        plantSet[4] = tools.setTextureSubImage(originalImagePlant,98,195,27,25);
        plantSet[5] = tools.setTextureSubImage(originalImagePlant,156,190,38,32);
        plantSet[6] = tools.setTextureSubImage(originalImagePlant,216,185,47,42);
        plantSet[7] = tools.setTextureSubImage(originalImagePlant,282,186,39,45);
        plantSet[8] = tools.setTextureSubImage(originalImagePlant,346,190,40,35);

        // blades of grass
        int index = 9;
        for (int i = 384; i < 512; i+=32) {
            for (int j = 0; j < 128; j+=32) {
                plantSet[index] = tools.setTextureSubImage(originalImagePlant,j,i,32,32);
                index++;
            }
        }

        return plantSet;
    }

    public BufferedImage[] loadPropSet(int size, String path) throws IOException {
        BufferedImage originalImageProp = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Texture/" + path)));
        BufferedImage[] propsSet = new BufferedImage[size];
        // transparent cube
        propsSet[0] = tools.setTextureSubImage(originalImageProp,32,18,64,64);
        // door open and close
        propsSet[1] = tools.setTextureSubImage(originalImageProp,29,103,37,50);
        propsSet[2] = tools.setTextureSubImage(originalImageProp,29,166,37,53);
        // chest closed and open
        propsSet[3] = tools.setTextureSubImage(originalImageProp,96,30,32,31);
        propsSet[4] = tools.setTextureSubImage(originalImageProp,96,76,32,49);
        // right and left sign
        propsSet[5] = tools.setTextureSubImage(originalImageProp,99,160,27,32);
        propsSet[6] = tools.setTextureSubImage(originalImageProp,96,224,27,32);
        // Crate large and small
        propsSet[7] = tools.setTextureSubImage(originalImageProp,160,18,32,46);
        propsSet[8] = tools.setTextureSubImage(originalImageProp,163,86,26,39);
        // barrel
        propsSet[9] = tools.setTextureSubImage(originalImageProp,162,153,28,36);
        // vase 1,2 and 3
        propsSet[10] = tools.setTextureSubImage(originalImageProp,165,217,21,34);
        propsSet[11] = tools.setTextureSubImage(originalImageProp,164,288,25,27);
        propsSet[12] = tools.setTextureSubImage(originalImageProp,165,348,21,32);
        // ruin pillars medium, large, and small
        propsSet[13] = tools.setTextureSubImage(originalImageProp,227,9,26,52);
        propsSet[14] = tools.setTextureSubImage(originalImageProp,227,91,26,66);
        propsSet[15] = tools.setTextureSubImage(originalImageProp,227,183,26,38);
        // grave tombstone, cross, and small tombstone
        propsSet[16] = tools.setTextureSubImage(originalImageProp,225,239,30,41);
        propsSet[17] = tools.setTextureSubImage(originalImageProp,227,303,26,40);
        propsSet[18] = tools.setTextureSubImage(originalImageProp,289,251,30,29);
        // ruin lighting medium, large, and small
        propsSet[19] = tools.setTextureSubImage(originalImageProp,270,29,5,26);
        propsSet[20] = tools.setTextureSubImage(originalImageProp,270,111,5,40);
        propsSet[21] = tools.setTextureSubImage(originalImageProp,270,203,5,12);
        // bench looking front, left and right
        propsSet[22] = tools.setTextureSubImage(originalImageProp,292,19,56,41);
        propsSet[23] = tools.setTextureSubImage(originalImageProp,387,2,27,61);
        propsSet[24] = tools.setTextureSubImage(originalImageProp,387,98,27,61);
        // coffin sideways and upright
        propsSet[25] = tools.setTextureSubImage(originalImageProp,288,87,64,36);
        propsSet[26] = tools.setTextureSubImage(originalImageProp,288,158,32,57);
        // stone cube
        propsSet[27] = tools.setTextureSubImage(originalImageProp,288,306,32,46);
        // angel statue
        propsSet[28] = tools.setTextureSubImage(originalImageProp,445,21,37,72);
        // lamp
        propsSet[29] = tools.setTextureSubImage(originalImageProp,453,118,22,37);
        // pillar and broken pillar
        propsSet[30] = tools.setTextureSubImage(originalImageProp,352,174,32,77);
        propsSet[31] = tools.setTextureSubImage(originalImageProp,416,194,32,57);
        //spawner
        propsSet[32] = tools.setTextureSubImage(originalImageProp,353,269,94,72);
        // broken well
        propsSet[33] = tools.setTextureSubImage(originalImageProp,420,359,55,49);
        // small ruins for spawner
        propsSet[34] = tools.setTextureSubImage(originalImageProp,330,266,5,5);
        propsSet[35] = tools.setTextureSubImage(originalImageProp,330,273,5,5);
        propsSet[36] = tools.setTextureSubImage(originalImageProp,337,266,5,5);
        propsSet[37] = tools.setTextureSubImage(originalImageProp,337,273,5,5);
        // Huge rock
        propsSet[38] = tools.setTextureSubImage(originalImageProp,3,430,57,42);
        // regular rocks smallest to largest
        propsSet[39] = tools.setTextureSubImage(originalImageProp,10,492,11,10);
        propsSet[40] = tools.setTextureSubImage(originalImageProp,40,490,16,14);
        propsSet[41] = tools.setTextureSubImage(originalImageProp,68,487,25,19);
        propsSet[42] = tools.setTextureSubImage(originalImageProp,100,487,24,19);
        propsSet[43] = tools.setTextureSubImage(originalImageProp,130,484,27,22);
        propsSet[44] = tools.setTextureSubImage(originalImageProp,162,482,27,27);
        // bricks increasing in quantity
        propsSet[45] = tools.setTextureSubImage(originalImageProp,231,489,18,16);
        propsSet[46] = tools.setTextureSubImage(originalImageProp,263,488,19,16);
        propsSet[47] = tools.setTextureSubImage(originalImageProp,289,486,31,19);

        return propsSet;
    }

    public BufferedImage[] loadVillageSet(int size, String path, String path2) throws IOException {
        BufferedImage originalImageVillage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/VillageTileset/32x32/" + path)));
        BufferedImage singleImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/VillageTileset/32x32/" + path2)));
        BufferedImage[] villageSet = new BufferedImage[size];

        // house banners
        villageSet[0] = tools.setTextureSubImage(originalImageVillage, 544,18,32,28);
        villageSet[1] = tools.setTextureSubImage(originalImageVillage, 576,18,32,28);
        villageSet[2] = tools.setTextureSubImage(originalImageVillage, 608,18,32,28);
        villageSet[3] = tools.setTextureSubImage(originalImageVillage,640,18,32,28);
        villageSet[4] = tools.setTextureSubImage(originalImageVillage,672,18,32,28);
        villageSet[5] = tools.setTextureSubImage(originalImageVillage,704,18,32,28);
        villageSet[6] = tools.setTextureSubImage(originalImageVillage,736,18,32,28);
        villageSet[7] = tools.setTextureSubImage(originalImageVillage,768,18,32,28);

        // windows
        villageSet[8] = tools.setTextureSubImage(originalImageVillage,802,16,28,32);
        villageSet[9] = tools.setTextureSubImage(originalImageVillage,834,16,28,32);
        villageSet[10] = tools.setTextureSubImage(originalImageVillage,866,16,28,32);
        villageSet[11] = tools.setTextureSubImage(originalImageVillage,898,16,28,32);
        villageSet[12] = tools.setTextureSubImage(originalImageVillage,932,22,24,22);
        villageSet[13] = tools.setTextureSubImage(originalImageVillage,964,22,24,22);

        // big house banners
        villageSet[14] = tools.setTextureSubImage(originalImageVillage,898,82,60,28);
        villageSet[15] = tools.setTextureSubImage(originalImageVillage,962,82,60,28);

        // windows with house-top part
        villageSet[16] = tools.setTextureSubImage(originalImageVillage,768,64,64,64);
        villageSet[17] = tools.setTextureSubImage(originalImageVillage,832,64,64,64);
        villageSet[18] = tools.setTextureSubImage(originalImageVillage,768,128,64,64);
        villageSet[19] = tools.setTextureSubImage(originalImageVillage,832,128,64,64);
        villageSet[20] = tools.setTextureSubImage(originalImageVillage,768,192,64,64);
        villageSet[21] = tools.setTextureSubImage(originalImageVillage,832,192,64,64);

        // water shed with water and no water
        villageSet[22] = tools.setTextureSubImage(originalImageVillage,386,164,62,88);
        villageSet[23] = tools.setTextureSubImage(originalImageVillage,450,164,62,88);

        // small and big ended houses
        villageSet[24] = tools.setTextureSubImage(originalImageVillage,512,68,256,220);
        villageSet[25] = tools.setTextureSubImage(originalImageVillage,512,292,320,220);

        // chimneys left and right facing
        villageSet[26] = tools.setTextureSubImage(originalImageVillage,784,258,32,62);
        villageSet[27] = tools.setTextureSubImage(originalImageVillage,848,258,32,62);

        // single house
        villageSet[28] = tools.setTextureSubImage(singleImage,0,0,singleImage.getWidth(),singleImage.getHeight());

        //half-houses small and big ended and single house
        villageSet[29] = tools.setTextureSubImage(originalImageVillage,36,512,248,128);
        villageSet[30] = tools.setTextureSubImage(originalImageVillage,4,672,312,128);
        villageSet[31] = tools.setTextureSubImage(originalImageVillage,352,512,128,128);

        // blue house roofs small, big, and single
        villageSet[32] = tools.setTextureSubImage(originalImageVillage,512,548,256,156);
        villageSet[33] = tools.setTextureSubImage(originalImageVillage,512,708,320,156);
        villageSet[34] = tools.setTextureSubImage(originalImageVillage,864,708,128,156);
        // brown house roofs small, big, and single
        villageSet[35] = tools.setTextureSubImage(originalImageVillage,768,548,256,156);
        villageSet[36] = tools.setTextureSubImage(originalImageVillage,512,868,320,156);
        villageSet[37] = tools.setTextureSubImage(originalImageVillage,864,868,128,156);

        // doors normal
        villageSet[38] = tools.setTextureSubImage(originalImageVillage,0,280,32,38);
        villageSet[39] = tools.setTextureSubImage(originalImageVillage,0,344,32,38);
        villageSet[40] = tools.setTextureSubImage(originalImageVillage,0,408,32,38);
        villageSet[41] = tools.setTextureSubImage(originalImageVillage,0,472,32,38);

        // doors with perimeter
        villageSet[42] = tools.setTextureSubImage(originalImageVillage,54,268,52,52);
        villageSet[43] = tools.setTextureSubImage(originalImageVillage,54,332,52,52);
        villageSet[44] = tools.setTextureSubImage(originalImageVillage,54,396,52,52);
        villageSet[45] = tools.setTextureSubImage(originalImageVillage,54,460,52,52);

        // logs small, medium large
        villageSet[46] = tools.setTextureSubImage(originalImageVillage,132,352,26,64);
        villageSet[47] = tools.setTextureSubImage(originalImageVillage,162,352,26,32);
        villageSet[48] = tools.setTextureSubImage(originalImageVillage,132,436,50,76);

        // empty and full hay bails
        villageSet[49] = tools.setTextureSubImage(originalImageVillage,192,212,64,44);
        villageSet[50] = tools.setTextureSubImage(originalImageVillage,192,276,64,44);
        return villageSet;
    }

    public BufferedImage[] getBaseTileSet() {
        return baseTileSet;
    }

    public BufferedImage[] getPlantSet() {
        return plantSet;
    }

    public BufferedImage[] getPropsSet() {
        return propsSet;
    }

    public BufferedImage[] getShadowSet() {
        return shadowSet;
    }

    public BufferedImage[] getStairSet() {
        return stairSet;
    }

    public BufferedImage[] getVillageSet() {
        return villageSet;
    }

    public BufferedImage[] getWallSet() {
        return wallSet;
    }
}
