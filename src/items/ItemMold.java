package items;

import helpers.InputParse;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * User: JS
 * Date: 23.1.2012
 * Time: 19:01
 * Package: items
 */
public class ItemMold {

    private String name, symbol, quickDescription, longDescription, sprite, type, location;
    private int weight, nutrition, chanceOfSickness, useSpeed, inventorySize;
    private int[] colour, defenceBonus, evasionBonus, durability, baseValue, damageDiceX, damageDiceY, damageDiceZ, accuracy, criticalChance, attackSpeed;
    private Boolean usable, wearableByHuman, usableByHuman, wearableByUndead, usableByUndead, wearableByRobot, usableByRobot, isContainer;
    private ArrayList<Item> inventory;




    public ItemMold(){

        name = "default name";
        symbol = "%";
        quickDescription = "an item";
        longDescription = "You see a magnificent item like no other";
        sprite = "nosprite.png";
        type = "tool";
        location = "hand";

        weight = 1;
        nutrition = 0;
        chanceOfSickness = 0;
        useSpeed = 100;
        inventorySize = 50;


        usable = true;
        wearableByHuman = true;
        usableByHuman = true;
        wearableByUndead = true;
        usableByUndead = true;
        wearableByRobot = true;
        usableByRobot = true;
        isContainer = false;

        colour = new int[]{192,192,192};
        defenceBonus = new int[]{0,0,0};
        evasionBonus = new int[]{0,0,0};
        durability = new int[]{0,0,10};
        baseValue = new int[]{0,0,0};
        damageDiceX = new int[]{0,0,0};
        damageDiceY = new int[]{0,0,0};
        damageDiceZ = new int[]{0,0,0};
        accuracy = new int[]{0,0,0};
        criticalChance = new int[]{0,0,0};
        attackSpeed = new int[]{0,0,0};


        inventory = new ArrayList<Item>();
    }



    public static HashMap<String, ItemMold> loadItems(){
        HashMap<String, ItemMold> terrainMap = new HashMap();
        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("resources/configfiles/items.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String newFeature = "dummy", currentLine, currentList[];
            //Read File Line By Line
            while ((currentLine = br.readLine()) != null)   {
                currentList = currentLine.split("=", 2);
                currentList[0] = currentList[0].trim();
                if (currentList[0].length() == 0){
                    continue;
                }
                switch((currentList[0].charAt(0))){
                    //looks messy, but basically we check the first character of the new line
                    case '#':
                        continue;
                    case '[':
                        newFeature = currentList[0].substring(1, currentList[0].length() - 1);
                        terrainMap.put(newFeature, new ItemMold());
                        //System.out.println(terrainMap.get(newFeature).getName());
                        continue;
                    default:
                        if (currentList.length == 2){
                            currentList[1] = currentList[1].trim().toLowerCase();
                            terrainMap.get(newFeature).enterData(currentList);
                        }
                }

            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }


        return terrainMap;

    }

    private void enterData(String arguments[]){
        switch (arguments[0].toLowerCase()){
            case "name":
                setName(arguments[1]);
                break;
            case "sprite":
                setSprite(arguments[1]);
                break;
            case "symbol":
                if (arguments[1].length() != 1){
                    System.out.println("itemtype: " + name + ". Symbol string is longer or shorter than 1 character");
                }
                else{
                    setSymbol(arguments[1]);
                }
                break;
            case "quickdescription":
                setQuickDescription(arguments[1]);
                break;
            case "longdescription":
                setLongDescription(arguments[1]);
                break;
            case "type":
                setType(arguments[1]);
                break;
            case "location":
                setLocation(arguments[1]);
                break;

            case "weight":
                try{
                    setWeight(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid weight input. " + e.getMessage());
                }
                break;
            case "nutrition":
                try{
                    setNutrition(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid nutrition input. " + e.getMessage());
                }
                break;
            case "chanceofsickness":
                try{
                    setChanceOfSickness(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid chanceOfSickness input. " + e.getMessage());
                }
                break;
            case "usespeed":
                try{
                    setUseSpeed(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid useSpeed input. " + e.getMessage());
                }
                break;
            case "inventorysize":
                try{
                    setInventorySize(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid inventorySize input. " + e.getMessage());
                }
                break;
            case "usable":
                try{
                    setUsable(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid usable input. " + e.getMessage());
                }
                break;
            case "wearablebyhuman":
                try{
                    setWearableByHuman(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid wearablebyhuman input. " + e.getMessage());
                }
                break;
            case "usablebyhuman":
                try{
                    setUsableByHuman(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid usablebyhuman input. " + e.getMessage());
                }
                break;
            case "wearablebyundead":
                try{
                    setWearableByUndead(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid wearablebyundead input. " + e.getMessage());
                }
                break;
            case "usablebyundead":
                try{
                    setUsableByUndead(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid usablebyundead input. " + e.getMessage());
                }
                break;
            case "wearablebyrobot":
                try{
                    setWearableByRobot(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid wearablebyrobot input. " + e.getMessage());
                }
                break;
            case "usablebyrobot":
                try{
                    setUsableByRobot(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid usablebyrobot input. " + e.getMessage());
                }
                break;
            case "iscontainer":
                try{
                    setIsContainer(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid isContainer input. " + e.getMessage());
                }
                break;
            case "colour":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setColour(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid colour input. " + e.getMessage());
                }
                break;

            case "defencebonus":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setDefenceBonus(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid defencebonus input. " + e.getMessage());
                }
                break;

            case "evasionbonus":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setEvasionBonus(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid evasionbonus input. " + e.getMessage());
                }
                break;
            case "durability":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setDurability(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid durability input. " + e.getMessage());
                }
                break;
            case "basevalue":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setBaseValue(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid basevalue input. " + e.getMessage());
                }
                break;
            case "damagedicex":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setDamageDiceX(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid damagedicex input. " + e.getMessage());
                }
                break;
            case "damagedicey":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setDamageDiceY(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid damagedicey input. " + e.getMessage());
                }
                break;
            case "damagedicez":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setDamageDiceZ(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid damagedicez input. " + e.getMessage());
                }
                break;
            case "accuracy":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setAccuracy(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid accuracy input. " + e.getMessage());
                }
                break;
            case "criticalchance":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setCriticalChance(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid criticalchance input. " + e.getMessage());
                }
                break;
            case "attackspeed":
                try{
                    int[] intArray = InputParse.inputToIntArray3(arguments[1]);
                    setAttackSpeed(intArray);
                }
                catch(Exception e){
                    System.out.println("itemtype: " + name + ". Invalid attackspeed input. " + e.getMessage());
                }
                break;
            default:
                System.out.println("item: " + name + ". Unknown variable name");
                break;
        }
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

    public int[] getDefenceBonus() {
        return defenceBonus;
    }

    public void setDefenceBonus(int[] defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    public int[] getColour() {
        return colour;
    }

    public void setColour(int[] colour) {
        this.colour = colour;
    }

    public int[] getEvasionBonus() {
        return evasionBonus;
    }

    public void setEvasionBonus(int[] evasionBonus) {
        this.evasionBonus = evasionBonus;
    }

    public int[] getDurability() {
        return durability;
    }

    public void setDurability(int[] durability) {
        this.durability = durability;
    }

    public int[] getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int[] baseValue) {
        this.baseValue = baseValue;
    }

    public int[] getDamageDiceX() {
        return damageDiceX;
    }

    public void setDamageDiceX(int[] damageDiceX) {
        this.damageDiceX = damageDiceX;
    }

    public int[] getDamageDiceY() {
        return damageDiceY;
    }

    public void setDamageDiceY(int[] damageDiceY) {
        this.damageDiceY = damageDiceY;
    }

    public int[] getDamageDiceZ() {
        return damageDiceZ;
    }

    public void setDamageDiceZ(int[] damageDiceZ) {
        this.damageDiceZ = damageDiceZ;
    }

    public int[] getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int[] accuracyBonus) {
        this.accuracy = accuracyBonus;
    }

    public int[] getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int[] criticalChance) {
        this.criticalChance = criticalChance;
    }

    public int[] getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int[] attackSpeed) {
        this.attackSpeed = attackSpeed;
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

    public Boolean getIsContainer() {
        return isContainer;
    }

    public void setIsContainer(Boolean container) {
        isContainer = container;
    }
}
