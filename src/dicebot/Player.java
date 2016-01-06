package dicebot;

import java.io.Serializable;

/**
 * Created by jbird on 1/5/16.
 */
public class Player implements Serializable{
    private String ID;
    private String name;
    private boolean isActive;
    public enum stat {
            ATTACK, DEFENSE, STRENGTH, DEXTERITY, MAXHP
        }
    private class Stats {
        private int attack = 0;
        private int defense = 0;
        private int strength = 0;
        private int dexterity = 0;
        private int HP = 0;

        // Constructors for stats
        public void Stats() {}
        //
        public void Stats(int att,int def,int str,int dex,int maxhp) {
            attack = att;
            defense = def;
            strength = str;
            dexterity = dex;
            HP = maxhp;
        }
        //////
        // Getters
        public int getAttack() {
            return attack;
        }
        //
        public int getDefense() {
            return defense;
        }
        //
        public int getStrength() {
            return strength;
        }
        //
        public int getDexterity() {
            return dexterity;
        }
        //
        public int getMaxHP() {
            return HP;
        }
        //////
        // Setters
        public void setAttack(int attack) {
            this.attack = attack;
        }
        //
        public void setDefense(int defense) {
            this.defense = defense;
        }
        //
        public void setStrength(int strength) {
            this.strength = strength;
        }
        //
        public void setDexterity(int dexterity) {
            this.dexterity = dexterity;
        }
        //
        public void setMaxHP(int maxHP) {
            this.HP = maxHP;
        }
        //////
    }

    private Stats baseStats;
    private Stats trueStats;
    private int curHP;

    public enum status {
        HEALTHY, STUNNED
    }
    private status status;

    // Meta data
    private int boosts;
    private int usedBoosts;
    private int rerolls;
    private int usedRerolls;
    private String currentDuel;


    // Getters
    public String getID() {
        return ID;
    }
    //
    public String getName() {
        return name;
    }
    //
    public boolean isActive() {
        return isActive;
    }
    //
    public int getBaseStat(stat Stat) {
        switch(Stat) {
            case ATTACK:
                return baseStats.getAttack();
            case DEFENSE:
                return baseStats.getDefense();
            case STRENGTH:
                return baseStats.getStrength();
            case DEXTERITY:
                return baseStats.getDexterity();
            case MAXHP:
                return baseStats.getMaxHP();
            default:
                return 0;
        }
    }
    //
    public int getTrueStat(stat Stat) {
        switch(Stat) {
            case ATTACK:
                return trueStats.getAttack();
            case DEFENSE:
                return trueStats.getDefense();
            case STRENGTH:
                return trueStats.getStrength();
            case DEXTERITY:
                return trueStats.getDexterity();
            case MAXHP:
                return trueStats.getMaxHP();
            default:
                return 0;
        }
    }
    //
    public int getCurHP() {
        return curHP;
    }
    //
    public status getStatus() {
        return status;
    }
    //
    public int getBoosts() {
        return boosts;
    }
    //
    public int getUsedBoosts() {
        return usedBoosts;
    }
    //
    public int getRerolls() {
        return rerolls;
    }
    //
    public int getUsedRerolls() {
        return usedRerolls;
    }
    //
    public String getCurrentDuel() {
        return currentDuel;
    }
    //////
    // Setters
    public void setActive(boolean active) {
        isActive = active;
    }
    //
    public void setBaseStat(stat Stat, int val) {
        switch(Stat) {
            case ATTACK:
                baseStats.setAttack(val);
                break;
            case DEFENSE:
                baseStats.setDefense(val);
                break;
            case STRENGTH:
                baseStats.setStrength(val);
                break;
            case DEXTERITY:
                baseStats.setDexterity(val);
                break;
            case MAXHP:
                baseStats.setMaxHP(val);
                break;
            default:
                break;
        }
    }
    //
    public void setTrueStat(stat Stat, int val) {
        switch(Stat) {
            case ATTACK:
                trueStats.setAttack(val);
                break;
            case DEFENSE:
                trueStats.setDefense(val);
                break;
            case STRENGTH:
                trueStats.setStrength(val);
                break;
            case DEXTERITY:
                trueStats.setDexterity(val);
                break;
            case MAXHP:
                trueStats.setMaxHP(val);
                break;
            default:
                break;
        }
    }
    //
    public void setCurHP(int curHP) {
        if (curHP > this.getTrueStat(stat.MAXHP)) {
            this.curHP = this.getTrueStat(stat.MAXHP);
        }
        else {
            this.curHP = curHP;
        }
    }
    //
    public void setStatus(Player.status status) {
        this.status = status;
    }
    //
    public void setBoosts(int boosts) {
        this.boosts = boosts;
    }
    //
    public void setUsedBoosts(int usedBoosts) {
        this.usedBoosts = usedBoosts;
    }
    //
    public void setRerolls(int rerolls) {
        this.rerolls = rerolls;
    }
    //
    public void setUsedRerolls(int usedRerolls) {
        this.usedRerolls = usedRerolls;
    }
    //
    public void setCurrentDuel(String currentDuel) {
        this.currentDuel = currentDuel;
    }
    //////
    // Constructors


    public Player(String ID, String name) {
        this.ID = ID;
        this.name = name;
        this.isActive = false;
        this.status = status.HEALTHY;
        this.boosts = 0;
        this.usedBoosts = 0;
        this.rerolls = 0;
        this.usedRerolls = 0;
        this.currentDuel = null;
    }
}
