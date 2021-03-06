package Entities.Particles.Bullets;

import Entities.Particles.Bullet;
import Game.Level;
import engine.Image;

public class EarthBullet extends Bullet
{
    private boolean splashed;
    private int splashRange;
    private double splashPercentage;
    public EarthBullet(Image img, int posX, int posY, float vel, int dmg, int targetId, int targetWaveId, int splashRange, double splashPercentage)
    {
        super(img, posX, posY, vel, dmg, targetId, targetWaveId);
        this.splashed = false;
        this.splashRange = splashRange;
        this.splashPercentage = splashPercentage;
    }
    @Override
    public void indUpdate(Level level)
    {
        splash(level);
    }
    public void splash(Level level)
    {
        if((destination == true) && (splashed == false))
        {
            splashed = true;
            for(int i = 0; i < level.getWavesAmount(); i++)
            {
                if(level.getWaves()[i].isRunning())
                {
                    for(int j = 0; j < level.getWaves()[i].getEnemies().length; j++)
                    {
                        if((Math.pow(level.getWaves()[i].getEnemies()[j].getPosX() - posX, 2) + Math.pow(level.getWaves()[i].getEnemies()[j].getPosY() - posY, 2) <= Math.pow(splashRange, 2)))
                        {
                            level.getWaves()[i].getEnemies()[j].healthUpdate((int)((double)dmg * (splashPercentage)));
                        }
                    }
                }
                else
                    break;
            }
        }
    }
}
