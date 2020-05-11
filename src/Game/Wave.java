package Game;

import Entities.Enemies.CrystalShard;
import Entities.Enemy;
import Map.Road;

public class Wave
{
    private Enemy[] enemies;
    private int posX;
    private int posY;
    private int unitDistance;
    private Road startPoint;
    public Wave(String info, int posX, int posY, int unitDistance, Road startPoint)
    {
        this.posX = posX;
        this.posY = posY;
        this.unitDistance = unitDistance;
        this.startPoint = startPoint;
        decryptor(info);
    }
    private void decryptor(String info)
    {
        char[] c;
        c = info.toCharArray();
        int n = 0;
        int j = 0;
        for(int i = 0; i < info.length(); i++)
        {
            if(c[i] == '.')
            {
                n++;
            }
        }
        enemies = new Enemy[n];
        n = c[0] - '0';
        for(int i = 1; i < info.length(); i++)
        {
            if(c[i] == '.')
            {
                if(n == 1)
                {
                    makeUnitSpace();
                    System.out.println(posY);
                    enemies[j++] = new CrystalShard(posX + (int)(System.nanoTime()) % 16 + 16, posY + (int)(System.nanoTime()) % 16 + 16, startPoint.waveDirection);
                }
                n = 0;
            }
            else
                n = n * 10 + c[i] - '0';
        }
    }
    private void makeUnitSpace()
    {
        if(startPoint.getWaveDirection() == 1)
            posY += unitDistance;
        if(startPoint.getWaveDirection() == 2)
            posX -= unitDistance;
        if(startPoint.getWaveDirection() == 3)
            posY -= unitDistance;
        if(startPoint.getWaveDirection() == 4)
            posX += unitDistance;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}