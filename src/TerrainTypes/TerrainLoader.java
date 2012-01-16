package TerrainTypes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * User: JS
 * Date: 16.1.2012
 * Time: 18:19
 * Package: helpers
 */



public class TerrainLoader {

    public static Map<String, TerrainType> loadTerrains(){
        Map<String, TerrainType> terrainMap = new HashMap();
        Map<String, String> variableTypes = new HashMap();
        variableTypes.put("name", "string");
        variableTypes.put("sprite", "string");
        variableTypes.put("symbol", "char");
        variableTypes.put("colour", "string");
        variableTypes.put("solid", "bool");
        variableTypes.put("swimmable", "bool");
        variableTypes.put("breathable", "bool");
        variableTypes.put("walkable", "bool");
        variableTypes.put("climbable", "bool");
        variableTypes.put("waterDepth", "int");
        variableTypes.put("stability", "int");
        variableTypes.put("movementcost", "int");
        variableTypes.put("losCost", "int");
        variableTypes.put("damage1", "int");
        variableTypes.put("damage1type", "string");
        variableTypes.put("damage2", "int");
        variableTypes.put("damage2type", "string");
        variableTypes.put("damage3", "int");
        variableTypes.put("damage3type", "string");
        variableTypes.put("staminadrain", "int");
        variableTypes.put("batterydrain", "int");
        variableTypes.put("manadrain", "int");
        variableTypes.put("trappable", "bool");



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
}
