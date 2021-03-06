package Map.Towers;

import Entities.Enemy;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Road;
import Map.Tile;
import Map.Tower;
import engine.*;

public class MagmaTower extends Tower
{

    public MagmaTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission) {
        super(name, Assets.MAGMATOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
        magma(tiles);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }

    @Override
    public void fire(Level level, Tile[] tiles, double passedTime) {

    }
    public static void scorch(Enemy enemy)
    {
        if(enemy.getDotaDuration() < Stats.dotaDuration[13])
        {
            enemy.setCurrentDotaDamage(Stats.dotaDamage[13]);
            enemy.setDotaDuration(Stats.dotaDuration[13]);
        }
    }
    protected void magma(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == Road.class))
            {
                if(Geometry.distance(posX, posY, tiles[i].getPosX(), tiles[i].getPosY()) <= range)
                {
                    ((Road)(tiles[i])).setMagma(true);
                }
            }
        }
    }
}
