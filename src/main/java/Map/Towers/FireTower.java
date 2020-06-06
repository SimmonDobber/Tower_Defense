package Map.Towers;

import Entities.Particles.Bullets.EarthBomb;
import Entities.Particles.Bullets.FireArrow;
import Entities.Particles.Bullets.WaterBullet;
import Game.Stats;
import Game.gui.Gui;
import Game.Level;
import Map.Tile;
import Map.Tower;
import engine.Image;
import engine.Pair;
import engine.ProgramContainer;
import engine.Renderer;

public class FireTower extends Tower
{
    private static final Image FIRETOWER = new Image("/res/towers/fireTower.png",64, 64, 0);
    public FireTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission)
    {
        super(name, FIRETOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }
    public FireTower(Image img, String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission)
    {
        super(name, img, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }

    @Override
    public void fire(Level level, Tile[] tiles, double passedTime)
    {
        if(passedTime - fireTimeStamp >= fireDelay)
        {
            fireTimeStamp = passedTime;
            Pair enemyId = targetChoose(level, tiles);
            if(enemyId.first >= 0)
            {
                bullets.add(new FireArrow(new Image("/res/entities/bullets/fireArrow.png", 8, 2, 0), (int)posX + 32, (int)posY + 4, Stats.fireBulletVelocity, dmg, enemyId.second, enemyId.first));
            }
        }
    }
}
