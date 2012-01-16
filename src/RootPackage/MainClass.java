package RootPackage;
import LevelGenerators.StupidGenerator;
import TerrainTypes.TerrainLoader;
import TerrainTypes.TerrainType;

import java.util.Map;

/**
 * User: JS
 * Date: 9.1.2012
 * Time: 6:19
 * Package: LevelGenerators
 */

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println("helo");
        StupidGenerator newMap = new StupidGenerator();
        System.out.print("lul");
        Map<String, TerrainType> terrainMap = TerrainLoader.loadTerrains();
        System.out.println(terrainMap.get("earth").getLongDescription());
    }
}
