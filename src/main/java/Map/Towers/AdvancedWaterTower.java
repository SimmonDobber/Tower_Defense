package Map.Towers;

import Entities.Particles.Bullets.WaterBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Image;

public class AdvancedWaterTower extends WaterTower
{

    public AdvancedWaterTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(Assets.ADVANCEDWATERTOWER, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
    }
    public AdvancedWaterTower(String name, Image img, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(img, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
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
                bullets.add(new WaterBullet(Assets.WATERBULLET, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[6], damage, enemyId.second, enemyId.first));
            }
        }
    }
}
