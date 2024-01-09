package Background;

import Utils.LoadSave;
import main.GamePanel;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class TileManager {
    Super_Level currLevel;
    ArrayList<Textures> currLevelTextures;
    GamePanel gp;
    int[][] currMap;
    public int mapTileCol;
    public int mapTileRow;
    public int mapPixelHeight;
    public int mapPixelWidth;

    public TileManager(GamePanel gp) throws IOException {
        this.gp = gp;
        LoadSave loadSave = new LoadSave(gp);
        decideCurrLevel(gp, loadSave);
        setDefaults();
        currLevelTextures = currLevel.getTexturesList();
        currMap = currLevel.getMap();
    }
    public void decideCurrLevel(GamePanel gp, LoadSave loadSave){
        currLevel = new HomeBase(gp,loadSave);
    }
    public void setDefaults(){
        mapPixelHeight = currLevel.getMapPixelHeight();
        mapPixelWidth = currLevel.getMapPixelWidth();
        mapTileCol = currLevel.getMapTileCol();
        mapTileRow = currLevel.getMapTileRow();
    }

    public void displayTextures(Graphics g2){
        for (int i = 0; i < currLevelTextures.size(); i++) {
            Textures textureCurr = currLevelTextures.get(i);
            if(textureCurr.getWorldX() + (textureCurr.getImage().getWidth() + gp.halfTile) > gp.player.worldX - (gp.player.playerScreenX + gp.player.getRaw_Player_Image_X()) &&
                    textureCurr.getWorldX() - (textureCurr.getImage().getWidth() + gp.halfTile) < gp.player.worldX + (gp.player.playerScreenX + gp.player.getRaw_Player_Image_X()) &&
                    textureCurr.getWorldY() + (textureCurr.getImage().getHeight() + gp.halfTile) > gp.player.worldY - (gp.player.playerScreenY + gp.player.getRaw_Player_Image_Y()) &&
                    textureCurr.getWorldY() - (textureCurr.getImage().getHeight() + gp.halfTile) < gp.player.worldY + (gp.player.playerScreenY + gp.player.getRaw_Player_Image_Y())){
                int y_draw_from_player = textureCurr.getWorldY() - gp.player.getWorldY() + gp.player.getPlayerScreenY() + gp.player.getRaw_Player_Image_Y();
                int x_draw_from_player = textureCurr.getWorldX() - gp.player.getWorldX() + gp.player.getPlayerScreenX() + gp.player.getRaw_Player_Image_X();
                g2.drawImage(textureCurr.getImage(),x_draw_from_player,y_draw_from_player,null);
            }
        }
    }

    public void draw(Graphics2D g2){
        displayTextures(g2);
    }

    public void setCurrLevel(Super_Level currLevel) {
        this.currLevel = currLevel;
    }
}

