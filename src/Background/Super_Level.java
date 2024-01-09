package Background;

import Utils.LoadSave;
import Utils.Tools;
import main.GamePanel;

import java.util.ArrayList;

public abstract class Super_Level {
    GamePanel gp;
    int[][] map;
    Tools tools;
    LoadSave loadSave;
    ArrayList<Textures> texturesList;
    public int mapTileCol;
    public int mapTileRow;
    public int mapPixelHeight;
    public int mapPixelWidth;
    public Super_Level(GamePanel gp, LoadSave loadSave){
        this.gp = gp;
        this.loadSave = loadSave;
        this.tools = new Tools();
    }

    public int getMapPixelHeight() {
        return mapPixelHeight;
    }

    public int getMapPixelWidth() {
        return mapPixelWidth;
    }

    public int getMapTileCol() {
        return mapTileCol;
    }

    public int getMapTileRow() {
        return mapTileRow;
    }

    public ArrayList<Textures> getTexturesList() {
        return texturesList;
    }

    public int[][] getMap() {
        return map;
    }
}
