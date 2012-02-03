package helpers;

/**
 * User: JS
 * Date: 24.1.2012
 * Time: 1:05
 * Package: helpers
 */
public class InputParse {
    public static int[] inputToIntArray3(String input){
        int[] intArray = new int[3];

        String[] argumentArray = input.split(",", 3);
        for (int i = 0; i < 3; i++){
            intArray[i] = Integer.parseInt(argumentArray[i].trim());

        }

        return intArray;
    }  
}
