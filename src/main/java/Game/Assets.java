package Game;

import engine.Animation;
import engine.Font;
import engine.Image;

public class Assets
{
    public static final Image BLANK = new Image("/blank.png", 1, 1, 0);
    public static final Image BLANK64 = new Image("/blank.png", 64, 64, 0);
    public static final Image DEFAULTFIELD = new Image("/defaultField.png", 1, 1, 0);
    public static final Image BACKGROUND = new Image("/background.png", 1024, 576, 1);

    public static final Image CRYSTALBALL = new Image("/entities/crystalBall.png", 16, 16, 0);
    public static final Image CRYSTALSHARD = new Image("/entities/crystalShard.png", 16, 16, 0);
    public static final Image DOBBO = new Image("/entities/dobbo.png", 32, 32, 0);

    public static final Image HEALTHBARFULL = new Image("/entities/healthBarFull.png", 16, 2, 0);

    public static final Image MENU = new Image("/gui/buildMenu.png", 128, 160, 0);
    public static final Image BASICUPGRADEMENU = new Image("/gui/basicUpgradeMenu.png", 128, 128, 0);
    public static final Image ADVANCEDUPGRADEMENU = new Image("/gui/advancedUpgradeMenu.png", 224, 128, 0);
    public static final Image CLOSER = new Image("/gui/menuCloser.png", 16, 16, 0);
    public static final Image UPGRADEBUTTON48 = new Image("/gui/upgradeMenuArrow.png", 48, 48, 0);
    public static final Image UPGRADEBUTTON64 = new Image("/gui/upgradeMenuArrow.png", 64, 64, 0);
    public static final Image FIRE64 = new Image("/emblems/fire.png",  64, 64, 0);
    public static final Image AIR64 = new Image("/emblems/air.png", 64, 64, 0);
    public static final Image WATER64 = new Image("/emblems/water.png", 64, 64, 0);
    public static final Image EARTH64 = new Image("/emblems/earth.png", 64, 64, 0);
    public static final Image FIRE48 = new Image("/emblems/fire.png",  48, 48, 0);
    public static final Image AIR48 = new Image("/emblems/air.png", 48, 48, 0);
    public static final Image WATER48 = new Image("/emblems/water.png", 48, 48, 0);
    public static final Image EARTH48 = new Image("/emblems/earth.png", 48, 48, 0);
    public static final Image FIRE32 = new Image("/emblems/fire.png", 32, 32, 0);
    public static final Image AIR32 = new Image("/emblems/air.png", 32, 32, 0);
    public static final Image WATER32 = new Image("/emblems/water.png", 32, 32, 0);
    public static final Image EARTH32 = new Image("/emblems/earth.png",  32, 32, 0);

    public static final Image GUI = new Image("/gui/gui.png", 1024, 576, 0xFF641D54);
    public static final Image GUIBUTTON = new Image("/gui/guiButton.png", 96, 48, 0xFF641D54);
    public static final Image GUIBUTTONCLICKED = new Image("/gui/guiButtonClicked.png", 96, 48, 0xFF641D54);

    public static final Image SUMMONINGTILE = new Image("/towers/summoningTile.png", 64, 64, 0);
    public static final Image BOOSTMARK = new Image("/towers/boostMark.png",64, 64, 0);

    public static final Image AIRTOWER = new Image("/towers/airTower.png",64, 64, 0);
    public static final Image EARTHTOWER = new Image("/towers/earthTower.png",64, 64, 0);
    public static final Image FIRETOWER = new Image("/towers/fireTower.png",64, 64, 0);
    public static final Image WATERTOWER = new Image("/towers/waterTower.png",64, 64, 0);

    public static final Image ADVANCEDAIRTOWER = new Image("/towers/advancedAirTower.png",64, 64, 0);
    public static final Image ADVANCEDEARTHTOWER = new Image("/towers/advancedEarthTower.png",64, 64, 0);
    public static final Image ADVANCEDFIRETOWER = new Image("/towers/advancedFireTower.png",64, 64, 0);
    public static final Image ADVANCEDWATERTOWER = new Image("/towers/advancedWaterTower.png",64, 64, 0);

    public static final Image MASTERAIRTOWER = new Image("/towers/masterAirTower.png",64, 64, 0);
    public static final Image MASTEREARTHTOWER = new Image("/towers/masterEarthTower.png",64, 64, 0);
    public static final Image MASTERFIRETOWER = new Image("/towers/masterFireTower.png",64, 64, 0);
    public static final Image MASTERWATERTOWER = new Image("/towers/masterWaterTower.png",64, 64, 0);

    public static final Image LIGHTINGTOWER = new Image("/towers/lightingTower.png",64, 64, 0);
    public static final Image MAGMATOWER = new Image("/towers/magmaTower.png",64, 64, 0);
    public static final Image ICETOWER = new Image("/towers/iceTower.png",64, 64, 0);
    public static final Image LEAFTOWER = new Image("/towers/leafTower.png",64, 64, 0);

    public static final Image EARTHBOMB = new Image("/entities/bullets/earthBomb.png", 8, 8, 0);
    public static final Image FIREARROW = new Image("/entities/bullets/fireArrow.png", 8, 2, 0);
    public static final Image WATERBULLET = new Image("/entities/bullets/waterBullet.png", 4, 8, 0);

    public static final Font F25 = new Font("/fonts/font.png", 1184, 23);
    public static final Font F20 = new Font("/fonts/font2.png", 954, 18);
    public static final Font F15 = new Font("/fonts/font3.png", 688, 13);
    public static final Font FB25 = new Font("/fonts/fontB.png", 1500, 25);
    public static final Font FB20 = new Font("/fonts/font2B.png", 1000, 17);
    public static final Font FB15 = new Font("/fonts/font3B.png", 1000, 15);

    public static final Animation SUMMONINGTILEANIMA = new Animation("/towers/summoningTileAnimation.png", 6, 64, 64, 4);

    public static final Animation AIRANIMA32 = new Animation("/emblems/airAnimation.png", 6, 32, 32, 6);
    public static final Animation EARTHANIMA32 = new Animation("/emblems/earthAnimation.png", 6, 32, 32, 6);
    public static final Animation FIREANIMA32 = new Animation("/emblems/fireAnimation.png", 6, 32, 32, 6);
    public static final Animation WATERANIMA32 = new Animation("/emblems/waterAnimation.png", 6, 32, 32, 6);

    public static final Animation AIRANIMA48 = new Animation("/emblems/airAnimation.png", 6, 48, 48, 6);
    public static final Animation EARTHANIMA48 = new Animation("/emblems/earthAnimation.png", 6, 48, 48, 6);
    public static final Animation FIREANIMA48 = new Animation("/emblems/fireAnimation.png", 6, 48, 48, 6);
    public static final Animation WATERANIMA48 = new Animation("/emblems/waterAnimation.png", 6, 48, 48, 6);

    public static final Animation AIRANIMA64 = new Animation("/emblems/airAnimation.png", 6, 64, 64, 6);
    public static final Animation EARTHANIMA64 = new Animation("/emblems/earthAnimation.png", 6, 64, 64, 6);
    public static final Animation FIREANIMA64 = new Animation("/emblems/fireAnimation.png", 6, 64, 64, 6);
    public static final Animation WATERANIMA64 = new Animation("/emblems/waterAnimation.png", 6, 64, 64, 6);
}