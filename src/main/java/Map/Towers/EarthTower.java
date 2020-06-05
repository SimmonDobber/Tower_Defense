package Map.Towers;

import Game.Level;
import Map.Tile;
import Map.Tower;
import engine.Image;
import engine.ProgramContainer;
import engine.Renderer;

public class EarthTower extends Tower
{
    private static final Image EARTHTOWER = new Image("/res/towers/earthTower.png",64, 64, 0);
    public EarthTower(String name, double posX, double posY, int id, int upgradeLvl, double fireTimeStamp, int towerId, int range, double fireDelay, boolean[] typePermission)
    {
        super(name, EARTHTOWER, posX, posY, id, upgradeLvl, fireTimeStamp, towerId, range, fireDelay, typePermission);
    }

    @Override
    public void indUpdate(ProgramContainer pc, Tile[] tiles, double passedTime, Level level) {

    }

    @Override
    public void indRender(ProgramContainer pc, Renderer r) {

    }
}
