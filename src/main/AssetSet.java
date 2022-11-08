package main;

import object.Chest;
import object.Door;
import object.Key;
import object.Boots;
import object.SuperObject;

public class AssetSet {
    GamePanel gp;

    public AssetSet(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 10 * gp.tileSize;

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 5 * gp.tileSize;
        gp.obj[1].worldY = 26 * gp.tileSize;

        gp.obj[2] = new Boots();
        gp.obj[2].worldX = 25 * gp.tileSize;
        gp.obj[2].worldY = 42 * gp.tileSize;

        gp.obj[3] = new Door();
        gp.obj[3].worldX = 43 * gp.tileSize;
        gp.obj[3].worldY = 33 * gp.tileSize;

        gp.obj[4] = new Door();
        gp.obj[4].worldX = 6 * gp.tileSize;
        gp.obj[4].worldY = 11 * gp.tileSize;

        gp.obj[5] = new Door();
        gp.obj[5].worldX = 3 * gp.tileSize;
        gp.obj[5].worldY = 45 * gp.tileSize;

        gp.obj[6] = new Chest();
        gp.obj[6].worldX = 43 * gp.tileSize;
        gp.obj[6].worldY = 28 * gp.tileSize;

        gp.obj[7] = new Chest();
        gp.obj[7].worldX = 7 * gp.tileSize;
        gp.obj[7].worldY = 3 *gp.tileSize;

        gp.obj[8] = new Chest();
        gp.obj[8].worldX = 3 * gp.tileSize;
        gp.obj[8].worldY = 42 * gp.tileSize;

        gp.obj[9] = new Key();
        gp.obj[9].worldX = 18 * gp.tileSize;
        gp.obj[9].worldY = 1 * gp.tileSize;
    }
}
