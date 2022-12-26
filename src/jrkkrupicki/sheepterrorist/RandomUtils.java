package jrkkrupicki.sheepterrorist;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    public static int getRandomInt(int min, int max){
        if(max < min) getRandomInt(max, min);
        return random.nextInt(max - min + 1) + min;
    }

    public static double getRandomDouble(int min, int max){
        if(max < min) getRandomDouble(max, min);
        return random.nextDouble() * (max - min) + min;
    }

    public static float getRandomFloat(int min, int max){
        if(max < min) getRandomFloat(max, min);
        return random.nextFloat() * (max - min) + min;
    }

    public static boolean getRandomBoolean(){
        return random.nextBoolean();
    }

    public static boolean getChange(double chance){
        return chance >= 100 || getRandomDouble(0, 100) <= chance;
    }
}
