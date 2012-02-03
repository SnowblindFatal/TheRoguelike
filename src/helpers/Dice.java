package helpers;
import java.util.Random;

/**
 * User: JS
 * Date: 3.2.2012
 * Time: 17:05
 * Package: helpers
 */
public class Dice {
    
    public static int throwDice(int[] dice){
        int total = 0;
        Random randomiser = new Random();

        for (int i = 1; i <= dice[0]; i++){
            total += randomiser.nextInt(dice[1]) + 1;
        }
        if (dice.length == 3){
            return total + dice[2];
        }
        else if (dice.length == 2){
            return total;
        }
        else return 0;
    }

    public static int throwDiceWithoutModifier(int[] dice){
        int total = 0;
        Random randomiser = new Random();
        for (int i = 1; i <= dice[0]; i++){
            total += randomiser.nextInt(dice[1]) + 1;
        }
        return total;
    }
    public static int throwDiceWithModifier(int[] dice){
        int total = 0;
        Random randomiser = new Random();
        for (int i = 1; i <= dice[0]; i++){
            total += randomiser.nextInt(dice[1]) + 1;
        }
        return total + dice[2];
    }
}
