package Map.Towers;

import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import engine.*;

import java.util.Vector;

public class AirTower extends Tower
{

    protected double attackSpeedBoost;
    protected double rangeBoost;
    protected Vector<Field> boostMark;
    public AirTower(String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission, double attackSpeedBoost, double rangeBoost)
    {
        super(name, Assets.AIRTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
        this.attackSpeedBoost = attackSpeedBoost;
        this.rangeBoost = rangeBoost;
        boostMark = new Vector<>();
        boost(tiles);
    }
    public AirTower(Image img, String name, Tile[] tiles, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int damage, int range, double fireDelay, boolean[] typePermission, double attackSpeedBoost, double rangeBoost)
    {
        super(name, img, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, damage, range, fireDelay, typePermission);
        this.attackSpeedBoost = attackSpeedBoost;
        this.rangeBoost = rangeBoost;
        boostMark = new Vector<>();
        boost(tiles);
    }
    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level)
    {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r)
    {
        for(int i = 0; i < boostMark.size(); i++)
        {
            r.drawImage(pc, boostMark.get(i).getImg(), (int)boostMark.get(i).getPosX(), (int)boostMark.get(i).getPosY());
        }
    }

    @Override
    public void fire(Level level, Tile[] tiles, double passedTime) {

    }
    protected void boost(Tile[] tiles)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass().getSuperclass() == Tower.class) || (tiles[i].getClass().getSuperclass().getSuperclass() == Tower.class) || (tiles[i].getClass().getSuperclass().getSuperclass().getSuperclass() == Tower.class))
            {
                if(Geometry.distance(posX, posY, tiles[i].getPosX(), tiles[i].getPosY()) <= range)
                {
                    ((Tower)(tiles[i])).setFireDelay(((Tower)(tiles[i])).getFireDelay() / (1 + Stats.attackSpeedBoost[1]));
                    ((Tower)(tiles[i])).setRange((int)(((Tower)(tiles[i])).getRange() * (1 + Stats.rangeBoost[1])));
                    boostMark.add(new Field(Assets.BOOSTMARK, tiles[i].getPosX(), tiles[i].getPosY()));
                }
            }
        }
    }
    public static void boostCheck(Tile[] tiles, int id, int posX, int posY)
    {
        for(int i = 0; i < 144; i++)
        {
            if((tiles[i].getClass() == AirTower.class))
            {
                if(Math.pow((tiles[i].getPosX() - posX), 2) + Math.pow((tiles[i].getPosY() - posY), 2) <= Math.pow(((AirTower)(tiles[i])).getRange(), 2))
                {
                    ((Tower)(tiles[id])).setFireDelay(((Tower)(tiles[id])).getFireDelay() / (1 + ((AirTower)(tiles[i])).getAttackSpeedBoost()));
                    ((Tower)(tiles[id])).setRange((int)(((Tower)(tiles[id])).getRange() * (1 + ((AirTower)(tiles[i])).getRangeBoost())));
                    ((AirTower)(tiles[i])).getBoostMark().add(new Field(Assets.BOOSTMARK, posX, posY));
                }
            }
        }
    }

    public double getAttackSpeedBoost() {
        return attackSpeedBoost;
    }

    public Vector<Field> getBoostMark() {
        return boostMark;
    }

    public double getRangeBoost() {
        return rangeBoost;
    }

}
