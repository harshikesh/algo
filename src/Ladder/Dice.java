package Ladder;

import java.util.Random;

/**
 * Created by harshikesh.kumar on 01/04/17.
 */
public class Dice {

    static int giveRandom(){
        Random random = new Random ();
        return random.nextInt(7);
    }
}
