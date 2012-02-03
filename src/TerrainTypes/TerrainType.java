package terraintypes;

import helpers.InputParse;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * User: JS
 * Date: 16.1.2012
 * Time: 18:29
 * Package: terraintypes
 */
public class TerrainType {
    private String name, sprite, symbol, damage1Type, damage2Type, damage3Type, quickDescription, longDescription;
    private Boolean solid, swimmable, breathable, walkable, climbable, trappable;
    private int waterDepth, stability, movementCost, LOSCost, damage1, damage2, damage3, staminaDrain, batteryDrain, manaDrain;
    private int[] colour;

    public TerrainType(){


        name = "floor";
        sprite = "smoothfloor.png";
        symbol = ".";
        quickDescription = "cavern floor";
        longDescription = "it's a dusty cavern floor. Nothing special about it";
        colour = new int[]{192, 192, 192};
        solid = false;
        swimmable = false;
        breathable = true;
        walkable = true;
        climbable = false;
        waterDepth = 0;
        stability = 0;
        movementCost = 100;
        LOSCost = 10;
        damage1 = 0;
        damage1Type = "None";
        damage2 = 0;
        damage2Type = "None";
        damage3 = 0;
        damage3Type = "None";
        staminaDrain = 0;
        batteryDrain = 0;
        manaDrain = 0;
        trappable = true;
    }

    public static HashMap<String, TerrainType> loadTerrains(){
        HashMap<String, TerrainType> terrainMap = new HashMap();
        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("resources/configfiles/terraintypes.txt");
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
                        terrainMap.put(newFeature, new TerrainType());
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

    public void enterData(String arguments[]){
        switch (arguments[0].toLowerCase()){
            case "name":
                setName(arguments[1]);
                break;
            case "sprite":
                setSprite(arguments[1]);
                break;
            case "symbol":
                if (arguments[1].length() != 1){
                    System.out.println("terraintype: " + name + ". Symbol string is longer or shorter than 1 character");
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
            case "colour":
                try{
                    int[] colourArray = InputParse.inputToIntArray3(arguments[1]);

                    setColour(colourArray);
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Invalid colour input. " + e.getMessage());
                }
                break;
            case "solid":
                try {
                    setSolid(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting solidness failed. " + e.getMessage());
                }
                break;
            case "swimmable":
                try {
                    setSwimmable(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting swimmableness failed. " + e.getMessage());
                }
                break;
            case "breathable":
                try {
                    setBreathable(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting breathableness failed. " + e.getMessage());
                }
                break;
            case "walkable":
                try {
                    setWalkable(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting walkableness failed. " + e.getMessage());
                }
                break;
            case "climbable":
                try {
                    setClimbable(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting climbableness failed. " + e.getMessage());
                }
                break;
            case "waterdepth":
                try{
                    setWaterDepth(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting blue colour failed. " + e.getMessage());
                }
                break;
            case "stability":
                try{
                    setStability(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting stability failed. " + e.getMessage());
                }
                break;
            case "movementcost":
                try{
                    setMovementCost(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting movement cost failed. " + e.getMessage());
                }
                break;
            case "loscost":
                try{
                    setLOSCost(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting LOSCost failed. " + e.getMessage());
                }
                break;
            case "damage1":
                try{
                    setDamage1(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting damage1 failed. " + e.getMessage());
                }
                break;
            case "damage1type":
                setDamage1Type(arguments[1]);
                break;
            case "damage2":
                try{
                    setDamage2(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting damage2 failed. " + e.getMessage());
                }
                break;
            case "damage2type":
                setDamage2Type(arguments[1]);
                break;
            case "damage3":
                try{
                    setDamage3(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting blue damage3 failed. " + e.getMessage());
                }
                break;
            case "damage3type":
                setDamage3Type(arguments[1]);
                break;
            case "staminadrain":
                try{
                    setStaminaDrain(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting stamina drain failed. " + e.getMessage());
                }
                break;
            case "batterydrain":
                try{
                    setBatteryDrain(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting battery drain failed. " + e.getMessage());
                }
                break;
            case "manadrain":
                try{
                    setManaDrain(Integer.parseInt(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting mana drain failed. " + e.getMessage());
                }
                break;
            case "trappable":
                try {
                    setTrappable(Boolean.parseBoolean(arguments[1]));
                }
                catch(Exception e){
                    System.out.println("terraintype: " + name + ". Setting trappableness failed. " + e.getMessage());
                }
                break;
            default:
                System.out.println("terraintype: " + name + ". Unknown variable name");
                break;
        }

    }
    
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }

    public void setSprite(String newSprite){
        sprite = newSprite;
    }
    public String getSprite(){
        return sprite;
    }

    public void setSymbol(String newSymbol){
        symbol = newSymbol;
    }
    public String getSymbol(){
        return symbol;
    }

    public void setQuickDescription(String newQuickDescription){
        quickDescription = newQuickDescription;
    }
    public String getQuickDescription(){
        return quickDescription;
    }

    public void setLongDescription(String newLongDescription){
        longDescription = newLongDescription;
    }
    public String getLongDescription(){
        return longDescription;
    }

    public int[] getColour() {
        return colour;
    }

    public void setColour(int[] colour) {
        this.colour = colour;
    }

    public void setSolid(Boolean newSolid){
        solid = newSolid;
    }
    public Boolean getSolid(){
        return solid;
    }

    public void setSwimmable(Boolean newSwimmable){
        swimmable = newSwimmable;
    }
    public Boolean getSwimmable(){
        return swimmable;
    }

    public void setBreathable(Boolean newBreathable){
        breathable = newBreathable;
    }
    public Boolean getBreathable(){
        return breathable;
    }

    public void setWalkable(Boolean newWalkable){
        walkable = newWalkable;
    }
    public Boolean getWalkable(){
        return walkable;
    }

    public void setClimbable(Boolean newClimbable){
        climbable = newClimbable;
    }
    public Boolean getClimbable(){
        return climbable;
    }

    public void setWaterDepth(int newWaterDepth){
        waterDepth = newWaterDepth;
    }
    public int getWaterDepth(){
        return waterDepth;
    }

    public void setStability(int newStability){
        stability = newStability;
    }
    public int getStability(){
        return stability;
    }

    public void setMovementCost(int newMovementCost){
        movementCost = newMovementCost;
    }
    public int getMovementCost(){
        return movementCost;
    }

    public void setLOSCost(int newLOSCost){
        LOSCost = newLOSCost;
    }
    public int getLOSCost(){
        return LOSCost;
    }

    public void setDamage1(int newDamage1){
        damage1 = newDamage1;
    }
    public int getDamage1(){
        return damage1;
    }

    public void setDamage1Type(String newDamage1Type){
        damage1Type = newDamage1Type;
    }
    public String getDamage1Type(){
        return damage1Type;
    }

    public void setDamage2(int newDamage2){
        damage2 = newDamage2;
    }
    public int getDamage2(){
        return damage2;
    }

    public void setDamage2Type(String newDamage2Type){
        damage2Type = newDamage2Type;
    }
    public String getDamage2Type(){
        return damage2Type;
    }

    public void setDamage3(int newDamage3){
        damage3 = newDamage3;
    }
    public int getDamage3(){
        return damage3;
    }

    public void setDamage3Type(String newDamage3Type){
        damage3Type = newDamage3Type;
    }
    public String getDamage3Type(){
        return damage3Type;
    }

    public void setStaminaDrain(int newStaminaDrain){
        staminaDrain = newStaminaDrain;
    }
    public int getStaminaDrain(){
        return staminaDrain;
    }

    public void setBatteryDrain(int newBatteryDrain){
        batteryDrain = newBatteryDrain;
    }
    public int getBatteryDrain(){
        return batteryDrain;
    }

    public void setManaDrain(int newManaDrain){
        manaDrain = newManaDrain;
    }
    public int getManaDrain(){
        return manaDrain;
    }

    public void setTrappable(Boolean newTrappable){
        trappable = newTrappable;
    }
    public Boolean getTrappable(){
        return trappable;
    }
}