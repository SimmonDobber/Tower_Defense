package Map.Towers;

import Entities.Particles.Bullets.FireBullet;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import engine.Image;

public class AdvancedFireTower extends FireTower
{

    public AdvancedFireTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(Assets.ADVANCEDFIRETOWER, name, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
    }
    public AdvancedFireTower(String name, Image img, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
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
                bullets.add(new FireBullet(Assets.FIREBULLET, (int)posX + 32, (int)posY + 4, Stats.bulletVelocity[4], damage, enemyId.second, enemyId.first, Stats.dotaDuration[4], Stats.dotaDamage[4]));
            }
        }
    }
}
