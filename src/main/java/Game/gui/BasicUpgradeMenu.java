package Game.gui;
import Game.Prices;
import Map.Tile;
import engine.*;

public class BasicUpgradeMenu
{
    private static int id = -1;
    public static Button menu = new Button("/res/gui/basicUpgradeMenu.png", -1000, -1000, 128, 128, 0);
    public static Button closer = new Button("/res/gui/menuCloser.png", -1000, -1000, 16, 16, 0);
    private static final Button upgradeButton = new Button("/res/gui/upgradeMenuArrow.png", -1000, -1000, 64, 64, 0);
    private static final Button FIRE = new Button("/res/towers/summoningTileFire.png", -1000, -1000, 48, 48, 0);
    private static final Button AIR = new Button("/res/towers/summoningTileAir.png", -1000, -1000,48, 48, 0);
    private static final Button WATER = new Button("/res/towers/summoningTileWater.png", -1000, -1000,48, 48, 0);
    private static final Button EARTH = new Button("/res/towers/summoningTileEarth.png", -1000, -1000,48, 48, 0);
    private static final Field FIREm = new Field("/res/towers/summoningTileFire.png", -1000, -1000, 32, 32, 0);
    private static final Field AIRm = new Field("/res/towers/summoningTileAir.png", -1000, -1000, 32, 32, 0);
    private static final Field WATERm = new Field("/res/towers/summoningTileWater.png", -1000, -1000, 32, 32, 0);
    private static final Field EARTHm = new Field("/res/towers/summoningTileEarth.png", -1000, -1000, 32, 32, 0);

    public static void update(ProgramContainer pc, Tile[] tiles, double passedTime, int[] tileId)
    {
        if(closer.isClick(pc, closer.getPosX(), closer.getPosY(), closer.getImg().getW(), closer.getImg().getH()))
        {
            BasicUpgradeMenu.close();
        }
        if(upgradeButton.isClick(pc, upgradeButton.getPosX(), upgradeButton.getPosY(), upgradeButton.getImg().getW(), upgradeButton.getImg().getH()))
        {

        }
    }
    public static void open(double posX, double posY, int iD, boolean[] typePermission)
    {
        close();
        id = iD;
        int x = 0;
        int y = 0;
        if((posY >= 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = -108;
        }
        else if((posY >= 192) && (posX < 64))
        {
            x = 32;
            y = -108;
        }
        else if((posY >= 192) && (posY < 544) && (posX >= 832))
        {
            x = -140;
            y = 0;
        }
        else if((posY >= 544) && (posX >= 832))
        {
            x = -140;
            y = -64;
        }
        else if((posY < 192) && (posX >= 64) && (posX < 832))
        {
            x = -32;
            y = 118;
        }
        else if((posY < 192) && (posX < 64))
        {
            x = 32;
            y = 118;
        }
        else if((posY < 192) && (posX >= 832))
        {
            x = -140;
            y = 64;
        }
        menu.setPosX(posX + x);
        menu.setPosY(posY + y - 32);
        upgradeButton.setPosX(posX + x + 48);
        upgradeButton.setPosY(posY + y - 16);
        if(id == 1)
        {
            FIRE.setPosX(posX + x + 32);
            FIRE.setPosY(posY + y + 48);
        }
        else if(id == 2)
        {
            AIR.setPosX(posX + x + 32);
            AIR.setPosY(posY + y + 48);
        }
        else if(id == 3)
        {
            WATER.setPosX(posX + x + 32);
            WATER.setPosY(posY + y + 48);
        }
        else if(id == 4)
        {
            EARTH.setPosX(posX + x + 32);
            EARTH.setPosY(posY + y + 48);
        }
        if(typePermission[0] == true)
        {
            FIREm.setPosX(posX + x);
            FIREm.setPosY(posY + y - 32);
        }
        else
        {
            FIREm.setPosX(-1000);
            FIREm.setPosY(-1000);
        }
        if(typePermission[1] == true)
        {
            AIRm.setPosX(posX + x);
            AIRm.setPosY(posY + y);
        }
        else
        {
            AIRm.setPosX(-1000);
            AIRm.setPosY(-1000);
        }
        if(typePermission[2] == true)
        {
            WATERm.setPosX(posX + x);
            WATERm.setPosY(posY + y + 32);
        }
        else
        {
            WATERm.setPosX(-1000);
            WATERm.setPosY(-1000);
        }
        if(typePermission[3] == true)
        {
            EARTHm.setPosX(posX + x);
            EARTHm.setPosY(posY + y + 64);
        }
        else
        {
            EARTHm.setPosX(-1000);
            EARTHm.setPosY(-1000);
        }
        closer.setPosX(posX + x + 128);
        closer.setPosY(posY + y - 32);
    }
    public static void close()
    {
        Input.justClicked = false;
        menu.setPosX(-1000);
        menu.setPosY(-1000);
        closer.setPosX(-1000);
        closer.setPosY(-1000);
        upgradeButton.setPosX(-1000);
        upgradeButton.setPosY(-1000);
        FIRE.setPosX(-1000);
        FIRE.setPosY(-1000);
        FIREm.setPosX(-1000);
        FIREm.setPosY(-1000);
        AIR.setPosX(-1000);
        AIR.setPosY(-1000);
        AIRm.setPosX(-1000);
        AIRm.setPosY(-1000);
        WATER.setPosX(-1000);
        WATER.setPosY(-1000);
        WATERm.setPosX(-1000);
        WATERm.setPosY(-1000);
        EARTH.setPosX(-1000);
        EARTH.setPosY(-1000);
        EARTHm.setPosX(-1000);
        EARTHm.setPosY(-1000);
    }
    public static void render(ProgramContainer pc, Renderer r, Prices prices)
    {
        r.drawStaticImage(pc, menu.getImg(), (int)menu.getPosX(), (int)menu.getPosY());
        r.drawStaticImage(pc, closer.getImg(), (int)closer.getPosX(), (int)closer.getPosY());
        r.drawStaticImage(pc, upgradeButton.getImg(), (int)upgradeButton.getPosX(), (int)upgradeButton.getPosY());
        r.drawStaticImage(pc, FIRE.getImg(), (int)FIRE.getPosX(), (int)FIRE.getPosY());
        r.drawStaticImage(pc, AIR.getImg(), (int)AIR.getPosX(), (int)AIR.getPosY());
        r.drawStaticImage(pc, WATER.getImg(), (int)WATER.getPosX(), (int)WATER.getPosY());
        r.drawStaticImage(pc, EARTH.getImg(), (int)EARTH.getPosX(), (int)EARTH.getPosY());
        r.drawStaticText(pc, "" + prices.getBasicPrices()[0], (int)FIRE.getPosX() + 28, (int)FIRE.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[1], (int)AIR.getPosX() + 28, (int)AIR.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[2], (int)WATER.getPosX() + 28, (int)WATER.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticText(pc, "" + prices.getBasicPrices()[3], (int)EARTH.getPosX() + 28, (int)EARTH.getPosY() + 16, 0xFF000000, 3);
        r.drawStaticImage(pc, FIREm.getImg(), (int)FIREm.getPosX(), (int)FIREm.getPosY());
        r.drawStaticImage(pc, AIRm.getImg(), (int)AIRm.getPosX(), (int)AIRm.getPosY());
        r.drawStaticImage(pc, WATERm.getImg(), (int)WATERm.getPosX(), (int)WATERm.getPosY());
        r.drawStaticImage(pc, EARTHm.getImg(), (int)EARTHm.getPosX(), (int)EARTHm.getPosY());
    }
}

