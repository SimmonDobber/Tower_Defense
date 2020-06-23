package Map.Towers;

import Game.Assets;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.Field;

public class MasterAirTower extends AdvancedAirTower
{
    public MasterAirTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int dmg, int range, double fireDelay, boolean[] typePermission, double attackSpeedBoost, double rangeBoost) {
        super(name, Assets.MASTERAIRTOWER, tiles, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, dmg, range, fireDelay, typePermission, attackSpeedBoost, rangeBoost);
    }
    protected void boost(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == FireTower.class) || (tiles[i].getClass() == WaterTower.class) || (tiles[i].getClass() == EarthTower.class) || (tiles[i].getClass() == AdvancedFireTower.class) || (tiles[i].getClass() == AdvancedWaterTower.class) || (tiles[i].getClass() == AdvancedEarthTower.class) || (tiles[i].getClass() == MasterFireTower.class) || (tiles[i].getClass() == MasterAirTower.class) || (tiles[i].getClass() == MasterWaterTower.class)  || (tiles[i].getClass() == MasterEarthTower.class) || (tiles[i].getClass() == LightingTower.class) || (tiles[i].getClass() == MagmaTower.class) || (tiles[i].getClass() == IceTower.class) || (tiles[i].getClass() == LeafTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(range, 2))
                {
                    ((Tower)(tiles[i])).setFireDelay(((Tower)(tiles[i])).getFireDelay() * (1 + Stats.airAttackSpeedBoost[2]) / (1 + Stats.airAttackSpeedBoost[2]));
                    ((Tower)(tiles[i])).setRange((int)(((Tower)(tiles[i])).getRange() / (1 + Stats.airRangeBoost[2]) * (1 + Stats.airRangeBoost[2])));
                    boostMark.add(new Field(Assets.BOOSTMARK, tiles[i].getPosX(), tiles[i].getPosY()));
                }
            }
        }
    }
    public static void boostCheck(Tile[] tiles, int id, int posX, int posY)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == MasterAirTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(((MasterAirTower)(tiles[i])).getRange(), 2))
                {
                    ((Tower)(tiles[id])).setFireDelay(((Tower)(tiles[id])).getFireDelay() / (1 + ((MasterAirTower)(tiles[i])).getAttackSpeedBoost()));
                    ((Tower)(tiles[id])).setRange((int)(((Tower)(tiles[id])).getRange() * (1 + ((MasterAirTower)(tiles[i])).getRangeBoost())));
                    ((MasterAirTower)(tiles[i])).getBoostMark().add(new Field(Assets.BOOSTMARK, posX, posY));
                }
            }
        }
    }
}