package hex;

import terraintypes1.TerrainType;

import java.util.ArrayList;

/**
 * User: JS
 * Date: 18.1.2012
 * Time: 15:46
 * Package: hex
 */
public class Hex {
    TerrainType terrainType;
    ArrayList<Object> items;
    ArrayList<Object> features;
    Object character;

    Boolean isLit;
    int xCoordinate, yCoordinate;

    public Hex(TerrainType newTerrainType, int xCor, int yCor){
        terrainType = newTerrainType;
        isLit = false;
        xCoordinate = xCor;
        yCoordinate = yCor;
    }
}
