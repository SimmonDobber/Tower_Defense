package Game;

import Map.Tile;
import Map.Towers.AirTower;
import Map.Towers.EarthTower;
import Map.Towers.FireTower;
import Map.Towers.WaterTower;
import engine.*;

public class BuildMenu extends Field
{
    private static int id;
    public static  BuildMenu menu = new  BuildMenu("/res/upgradeMenu.png", -1000, -1000, 128, 128, 0);
    public static Button closer = new Button("/res/upgradeMenuCloser.png", -1000, -1000, 16, 16, 0);
    private static final Button FIRE = new Button("/res/towers/summoningTileFire.png", -1000, -1000, 64, 64, 0);
    private static final Button AIR = new Button("/res/towers/summoningTileAir.png", -1000, -1000,64, 64, 0);
    private static final Button WATER = new Button("/res/towers/summoningTileWater.png", -1000, -1000,64, 64, 0);
    private static final Button EARTH = new Button("/res/towers/summoningTileEarth.png", -1000, -1000,64, 64, 0);
    public  BuildMenu(String path, int posX, int posY, int width, int height, int frame) {
        super(path, posX, posY, width, height, frame);
        id = -1;
    }
    public static void update(ProgramContainer pc, Tile[] tiles, int[] tileId)
    {
        FIRE.holdClick(pc);
        AIR.holdClick(pc);
        WATER.holdClick(pc);
        EARTH.holdClick(pc);
        closer.holdClick(pc);
        if(closer.isJustClicked())
        {
            BuildMenu.close();
        }
        if((FIRE.isJustClicked()) && (Stats.fire >= Prices.basicPrices[0]))
        {
            close();
            Stats.fire -= Prices.basicPrices[0];
            tileId[id] = 21;
            tiles[id] = new FireTower("/res/towers/fireTower.png", (id % 16) * 64, (id / 16) * 64, 64, 64, id, 1);

        }
        if((AIR.isJustClicked()) && (Stats.air >= Prices.basicPrices[1]))
        {
            close();
            Stats.air -= Prices.basicPrices[1];
            tileId[id] = 22;
            tiles[id] = new AirTower("/res/towers/airTower.png", (id % 16) * 64, (id / 16) * 64, 64, 64, id, 1);

        }
        if((WATER.isJustClicked()) && (Stats.water >= Prices.basicPrices[2]))
        {
            close();
            Stats.water -= Prices.basicPrices[2];
            tileId[id] = 23;
            tiles[id] = new WaterTower("/res/towers/waterTower.png", (id % 16) * 64, (id / 16) * 64, 64, 64, id, 1);

        }
        if((EARTH.isJustClicked()) && (Stats.earth >= Prices.basicPrices[3]))
        {
            close();
            Stats.earth -= Prices.basicPrices[3];
            tileId[id] = 24;
            tiles[id] = new EarthTower("/res/towers/earthTower.png", (id % 16) * 64, (id / 16) * 64, 64, 64, id, 1);

        }
    }
    public static void render(ProgramContainer pc, Renderer r, Prices prices)
    {
        r.drawStaticImage(pc, menu.getImg(), menu.getPosX(), menu.getPosY());
        r.drawStaticImage(pc, closer.getImg(), closer.getPosX(), closer.getPosY());
        r.drawStaticImage(pc, FIRE.getImg(), FIRE.getPosX(), FIRE.getPosY());
        r.drawStaticImage(pc, AIR.getImg(), AIR.getPosX(), AIR.getPosY());
        r.drawStaticImage(pc, WATER.getImg(), WATER.getPosX(), WATER.getPosY());
        r.drawStaticImage(pc, EARTH.getImg(), EARTH.getPosX(), EARTH.getPosY());
        r.drawStaticText(pc, "" + prices.getBasicPrices()[0], FIRE.getPosX() + 12, FIRE.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[1], AIR.getPosX() + 12, AIR.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[2], WATER.getPosX() + 12, WATER.getPosY() + 32, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[3], EARTH.getPosX() + 12, EARTH.getPosY() + 32, 0xFF000000, 3);
    }
    public static void open(int posX, int posY, int iD, boolean[] typePermission)
    {
        id = iD;
        int x = 0;
        int y = 0;
        if((posY >= 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = -140;
        }
        else if((posY >= 192) && (posX < 64))
        {
            x = 32;
            y = -140;
        }
        else if((posY >= 192) && (posY < 544) && (posX >= 832))
        {
            x = -140;
            y = -32;
        }
        else if((posY >= 544) && (posX >= 832))
        {
            x = -140;
            y = -96;
        }
        else if((posY < 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = 86;
        }
        else if((posY < 192) && (posX < 64))
        {
            x = 32;
            y = 86;
        }
        else if((posY < 192) && (posX >= 832))
        {
            x = -140;
            y = 32;
        }
            menu.setPosX(posX + x);
            menu.setPosY(posY + y);
            if(typePermission[0] == true)
            {
                FIRE.setPosX(posX  + x);
                FIRE.setPosY(posY  + y);
            }
            else
            {
                FIRE.setPosX(-1000);
                FIRE.setPosY(-1000);
            }
            if(typePermission[1] == true)
            {
                AIR.setPosX(posX + x + 64);
                AIR.setPosY(posY + y);
            }
            else
            {
                AIR.setPosX(-1000);
                AIR.setPosY(-1000);
            }
            if(typePermission[2] == true)
            {
                WATER.setPosX(posX  + x);
                WATER.setPosY(posY + y + 64);
            }
            else
            {
                WATER.setPosX(-1000);
                WATER.setPosY(-1000);
            }
            if(typePermission[3] == true)
            {
                EARTH.setPosX(posX  + x + 64);
                EARTH.setPosY(posY  + y + 64);
            }
            else
            {
                EARTH.setPosX(-1000);
                EARTH.setPosY(-1000);
            }
            closer.setPosX(posX  + x + 128);
            closer.setPosY(posY  + y - 16);
    }
    public static void close()
    {
        menu.setPosX(-1000);
        menu.setPosY(-1000);
        closer.setPosX(-1000);
        closer.setPosY(-1000);
        FIRE.setPosX(-1000);
        FIRE.setPosY(-1000);
        FIRE.setJustClicked(false);
        AIR.setPosX(-1000);
        AIR.setPosY(-1000);
        AIR.setJustClicked(false);
        WATER.setPosX(-1000);
        WATER.setPosY(-1000);
        WATER.setJustClicked(false);
        EARTH.setPosX(-1000);
        EARTH.setPosY(-1000);
        EARTH.setJustClicked(false);
        closer.setClicked(false);
        closer.setJustClicked(false);
        closer.imageSwap();
    }
}

