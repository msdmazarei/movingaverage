package paytmlabs.sde.challenage;

import paytmlabs.sde.challenage.movingaverage.IMovingAverage;
import paytmlabs.sde.challenage.movingaverage.KeepAllElementsMovingAverage;
import paytmlabs.sde.challenage.movingaverage.SimpleMovingAverage;


public class timeMeasure {
    static long simple() {
        IMovingAverage<Integer> simpleMovingAverage = new SimpleMovingAverage<>(500);

        long startTime, endTime, timeElapsed;

        startTime = System.currentTimeMillis();
        for (int j = 0; j < 100; j++)
            for (int i = 0; i < 10000; i++) simpleMovingAverage.add(i);

        endTime = System.currentTimeMillis();

        timeElapsed = endTime - startTime;
        return timeElapsed;
        //  System.out.println("Execution time in milliseconds for simpleMovingAverage: " + timeElapsed);

    }
    static long keepall() {
        IMovingAverage<Integer> simpleMovingAverage = new KeepAllElementsMovingAverage<>(500);

        long startTime, endTime, timeElapsed;

        startTime = System.currentTimeMillis();
        for (int j = 0; j < 100; j++)
            for (int i = 0; i < 10000; i++) simpleMovingAverage.add(i);

        endTime = System.currentTimeMillis();

        timeElapsed = endTime - startTime;
        return timeElapsed;
        //  System.out.println("Execution time in milliseconds for simpleMovingAverage: " + timeElapsed);

    }



    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println("Execution time in milliseconds for simpleMovingAverage: " + simple());
            System.out.println("Execution time in milliseconds for keepall: " + keepall());
        }


    }

}
