package rootpackage;
import terraintypes.TerrainType;
import items.ItemMold;
import items.Item;
import levelgenerators.StupidGenerator;


import java.util.HashMap;

/**
 * User: JS
 * Date: 9.1.2012
 * Time: 6:19
 * Package: levelgenerators
 */

public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println("hello");
        StupidGenerator newMap = new StupidGenerator();
        System.out.print("lul");
        HashMap<String, TerrainType> terrainMap = TerrainType.loadTerrains();
        System.out.println(terrainMap.get("earth").getLongDescription());
        System.out.println(terrainMap.get("water").getLongDescription());
        HashMap<String, ItemMold> itemDictionary = ItemMold.loadItems();
        Item testItem = new Item(itemDictionary.get("apple"));
        System.out.println(testItem.getName());
        System.out.println(String.valueOf(testItem.getDamageDice()[0]) + ", " + String.valueOf(testItem.getDamageDice()[1]) + ", " + String.valueOf(testItem.getDamageDice()[2]));



    }
}
