package Game.gui;

import Entities.Enemy;
import Game.Assets;
import Game.Level;
import Game.Stats;
import Map.Tile;
import Map.Tower;
import Map.Towers.AirTower;
import Map.Towers.LightingTower;
import Map.Towers.MagmaTower;
import Map.Towers.MasterAirTower;
import engine.*;

public class Gui
{
    private static final Field background = new Field(Assets.GUI, 0, 0);
    private static NextWaveButton nextWave = new NextWaveButton(Assets.GUIBUTTON, Assets.GUIBUTTONCLICKED, 976, 176);
    private static Field hpEmblem = new Field(Assets.HP, 940, 100);
    private static Field energyEmblem = new Field(Assets.ENERGY24, 940, 140);
    private static String name = "";
    private static int damage = 0;
    private static double attackSpeed = 0;
    private static double damagePerSecond = 0;
    private static int range = 0;
    private static double attackSpeedBoost = 0;
    private static double rangeBoost = 0;
    private static double damageBoost = 0;
    private static int hp = 0;
    private static double vel = 0;
    private static int cost = 0;
    public static int currentWaveId = -1;
    public static int currentEnemyId = -1;
    public static void update(ProgramContainer pc, Level level, double passedTime, Tile[] tiles)
    {
        energyEmblem.setImg(Assets.ENERGYANIMA24.updateLoop(energyEmblem.getImg(), World.tickCount));
        nextWave.onClick(pc, nextWave.getPosX(), nextWave.getPosY(), nextWave.getImg().getW(), nextWave.getImg().getH(), level, passedTime);
        BuildMenu.update(pc, tiles, passedTime, level.getTileId());
        BasicUpgradeMenu.update(pc, tiles, passedTime, level.getTileId());
        AdvancedUpgradeMenu.update(pc, tiles, passedTime, level.getTileId());
    }
    public static void render(ProgramContainer pc, Renderer r, Level level, double passedTime)
    {
        r.drawStaticImage(pc, background.getImg(), (int)background.getPosX(), (int)background.getPosY());
        r.drawStaticText(pc, "" + Stats.getHp(), 970, 98, 0xFFbcbcbc, 28);
        r.drawStaticText(pc, "" + Stats.energy, 970, 140, 0xFFbcbcbc, 24);
        r.drawStaticImage(pc, hpEmblem.getImg(), (int)hpEmblem.getPosX(), (int)hpEmblem.getPosY());
        r.drawStaticImage(pc, energyEmblem.getImg(), (int)energyEmblem.getPosX(), (int)energyEmblem.getPosY());
        r.drawStaticText(pc, "Wave: " + (level.getCurrentWave() + 1) + "/" + level.getWavesAmount(), 884, 20, 0xFFbcbcbc, 24);
        r.drawStaticImage(pc, nextWave.getImg(), (int)nextWave.getPosX(), (int)nextWave.getPosY());
        r.drawStaticText(pc, "Next wave in:", 884, 64, 0xFFbcbcbc, 16);
        if(level.getCurrentWave() >= 0)
        {
            if((level.getCurrentWave() + 1 < level.getWavesAmount()) && (level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp() >= 0))
            {
                r.drawStaticText(pc, "" + (double)((int)((level.getWaveDelay()[level.getCurrentWave()] - passedTime + level.getWaves()[level.getCurrentWave()].getTimeStamp()) * 10)) / (double)(10), 980, 62, 0xFFbcbcbc, 20);
            }
            else
            {
                r.drawStaticText(pc, "OO", 980, 62, 0xFFbcbcbc, 20);

            }
        }
        BuildMenu.render(pc, r);
        BasicUpgradeMenu.render(pc, r);
        AdvancedUpgradeMenu.render(pc, r);
        if(name != "")
        r.drawStaticText(pc, name, 16, 548, 0xFFbcbcbc, 24);
        if(damage != 0)
        r.drawStaticText(pc,"Damage: " + damage, 420, 548, 0xFFbcbcbc, 24);
        if(attackSpeed != 0)
        r.drawStaticText(pc,"Attack Speed: " + ((double)((int)(attackSpeed * 100)) / 100), 590, 548, 0xFFbcbcbc, 24);
        if(damagePerSecond != 0)
            r.drawStaticText(pc,"Damage Per Second: " + damagePerSecond, 420, 548, 0xFFbcbcbc, 24);
        if(range != 0)
        r.drawStaticText(pc,"Range: " + range, 260, 548, 0xFFbcbcbc, 24);
        if(attackSpeedBoost != 0)
            r.drawStaticText(pc,"AS Boost:  +" + ((double)((int)(attackSpeedBoost * 100)) / 100) + "%", 620, 548, 0xFFbcbcbc, 24);
        if(rangeBoost != 0)
            r.drawStaticText(pc,"Rng Boost:  +" + ((double)((int)(rangeBoost * 100)) / 100) + "%", 400, 548, 0xFFbcbcbc, 24);
        if(rangeBoost != 0)
            r.drawStaticText(pc,"Dmg Boost:  +" + ((double)((int)(rangeBoost * 100)) / 100) + "%", 820, 548, 0xFFbcbcbc, 24);
        if(hp != 0)
            r.drawStaticText(pc,"Hp: " + hp, 320, 548, 0xFFbcbcbc, 24);
        if(vel != 0)
            r.drawStaticText(pc,"Velocity: " + ((double)((int)(vel * 100)) / 100), 512, 548, 0xFFbcbcbc, 24);
        if(cost != 0)
            r.drawStaticText(pc,"Cost: " + cost, 784, 548, 0xFFbcbcbc, 24);
    }
    private static void clear()
    {
        name = "";
        damage = 0;
        attackSpeed = 0;
        damagePerSecond = 0;
        range = 0;
        attackSpeedBoost = 0;
        rangeBoost = 0;
        hp = 0;
        vel = 0;
        cost = 0;
        currentWaveId = -1;
        currentEnemyId = -1;
    }
    public static void towerInfo(Tower tower)
    {
        clear();
        name = tower.getName();
        damage = tower.getDamage();
        attackSpeed = 1 / tower.getFireDelay();
        range = tower.getRange();
    }
    public static void airTowerInfo(AirTower tower)
    {
        clear();
        name = tower.getName();
        range = tower.getRange();
        attackSpeedBoost = tower.getAttackSpeedBoost() * 100;
        rangeBoost = (int)(tower.getRangeBoost() * 100);
    }
    public static void masterAirTowerInfo(MasterAirTower tower)
    {
        clear();
        name = tower.getName();
        range = tower.getRange();
        attackSpeedBoost = tower.getAttackSpeedBoost() * 100;
        rangeBoost = (int)(tower.getRangeBoost() * 100);
        damageBoost = tower.getDamageBoost() * 100;
    }
    public static void magmaTowerInfo(MagmaTower tower)
    {
        clear();
        name = tower.getName();
        damagePerSecond = tower.getDamage();
        range = tower.getRange();
    }
    public static void lightingTowerInfo(LightingTower tower)
    {
        clear();
        name = tower.getName();
        damagePerSecond = tower.getDamage();
        range = tower.getRange();
    }
    public static void enemyInfo(Enemy enemy, int wave, int id)
    {
        clear();
        if(enemy.getHp() > 0)
        {
            name = enemy.getName();
            hp = (int)enemy.getHp();
            vel = enemy.getVel() * enemy.getVelocityPercentage();
            cost = enemy.getCost();
            currentWaveId = wave;
            currentEnemyId = id;
        }
    }
}

