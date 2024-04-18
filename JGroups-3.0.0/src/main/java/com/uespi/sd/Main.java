package com.uespi.sd;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Check if the number is even or odd
        if (randomNumber % 2 == 0) {
            new FireAlarmJG().start();
        } else {
            new FireAlarmJG().raise();
        }

        new FireAlarmConsumerJG().start();
    }
}

