package items;

import helpers.Dice;

import java.util.ArrayList;

/**
 * User: JS
 * Date: 3.2.2012
 * Time: 16:18
 * Package: items
 */
public class Item {
    
    private String name, symbol, quickDescription, longDescription, sprite, type, location;
    private int weight, nutrition, chanceOfSickness, useSpeed, inventorySize, defenceBonus, evasionBonus, maxDurability, baseValue, accuracy, criticalChance, attackSpeed;
    private int[] colour, damageDice;
    private Boolean usable, wearableByHuman, usableByHuman, wearableByUndead, usableByUndead, wearableByRobot, usableByRobot, isContainer;
    private ArrayList<Item> inventory;

    public Item(ItemMold mold){
        name = mold.getName();
        symbol = mold.getSymbol();
        quickDescription = mold.getQuickDescription();
        longDescription = mold.getLongDescription();
        sprite = mold.getSprite();
        type = mold.getType();
        location = mold.getLocation();

        weight = mold.getWeight();
        nutrition = mold.getNutrition();
        chanceOfSickness = mold.getChanceOfSickness();
        useSpeed = mold.getUseSpeed();
        inventorySize = mold.getInventorySize();

        defenceBonus = Dice.throwDice(mold.getDefenceBonus());
        evasionBonus = Dice.throwDice(mold.getEvasionBonus());
        maxDurability = Dice.throwDice(mold.getDurability());
        baseValue = Dice.throwDice(mold.getBaseValue());
        accuracy = Dice.throwDice(mold.getAccuracy());
        criticalChance = Dice.throwDice(mold.getCriticalChance());
        attackSpeed = Dice.throwDice(mold.getAttackSpeed());

        colour = mold.getColour();

        damageDice = new int[] {Dice.throwDice(mold.getDamageDiceX()), Dice.throwDice(mold.getDamageDiceY()), Dice.throwDice(mold.getDamageDiceZ())};

        usable = mold.getUsable();
        wearableByHuman = mold.getWearableByHuman();
        usableByHuman = mold.getUsableByHuman();
        wearableByUndead = mold.getWearableByUndead();
        usableByUndead = mold.getUsableByUndead();
        wearableByRobot = mold.getWearableByRobot();
        usableByRobot = mold.getUsableByRobot();
        isContainer = mold.getIsContainer();
        
        inventory = new ArrayList<Item>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuickDescription() {
        return quickDescription;
    }

    public void setQuickDescription(String quickDescription) {
        this.quickDescription = quickDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNutrition() {
        return nutrition;
    }

    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }

    public int getChanceOfSickness() {
        return chanceOfSickness;
    }

    public void setChanceOfSickness(int chanceOfSickness) {
        this.chanceOfSickness = chanceOfSickness;
    }

    public int getUseSpeed() {
        return useSpeed;
    }

    public void setUseSpeed(int useSpeed) {
        this.useSpeed = useSpeed;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public int getDefenceBonus() {
        return defenceBonus;
    }

    public void setDefenceBonus(int defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    public int getEvasionBonus() {
        return evasionBonus;
    }

    public void setEvasionBonus(int evasionBonus) {
        this.evasionBonus = evasionBonus;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int[] getColour() {
        return colour;
    }

    public void setColour(int[] colour) {
        this.colour = colour;
    }

    public int[] getDamageDice() {
        return damageDice;
    }

    public void setDamageDice(int[] damageDice) {
        this.damageDice = damageDice;
    }

    public Boolean getUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    public Boolean getWearableByHuman() {
        return wearableByHuman;
    }

    public void setWearableByHuman(Boolean wearableByHuman) {
        this.wearableByHuman = wearableByHuman;
    }

    public Boolean getUsableByHuman() {
        return usableByHuman;
    }

    public void setUsableByHuman(Boolean usableByHuman) {
        this.usableByHuman = usableByHuman;
    }

    public Boolean getWearableByUndead() {
        return wearableByUndead;
    }

    public void setWearableByUndead(Boolean wearableByUndead) {
        this.wearableByUndead = wearableByUndead;
    }

    public Boolean getUsableByUndead() {
        return usableByUndead;
    }

    public void setUsableByUndead(Boolean usableByUndead) {
        this.usableByUndead = usableByUndead;
    }

    public Boolean getWearableByRobot() {
        return wearableByRobot;
    }

    public void setWearableByRobot(Boolean wearableByRobot) {
        this.wearableByRobot = wearableByRobot;
    }

    public Boolean getUsableByRobot() {
        return usableByRobot;
    }

    public void setUsableByRobot(Boolean usableByRobot) {
        this.usableByRobot = usableByRobot;
    }

    public Boolean getContainer() {
        return isContainer;
    }

    public void setContainer(Boolean container) {
        isContainer = container;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
