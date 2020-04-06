package paytmlabs.sde.challenage.movingaverage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KeepAllElementsMovingAverageTest {
    @Test
    void get_period_for_period_3_should_be_3() {
        IMovingAverage<Integer> movingAverage = new KeepAllElementsMovingAverage<>(3);
        assert 3 == movingAverage.getPeriod();
    }

    @Test
    void period_of_zero_should_raise_exception() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                    new KeepAllElementsMovingAverage<>(0);
                }
        );

    }

    @Test
    void last_n_items_should_be_997_998_999_after_adding_1000_items_sequentialy() {
        IMovingAverage<Integer> s = new KeepAllElementsMovingAverage<>(3);
        for (Integer i = 0; i < 1000; i++) s.add(i);
        Integer[] lastNItems = {997, 998, 999};
        assert Arrays.equals(lastNItems, s.getLastNItems().toArray());
    }

    @Test
    void last_n_items_for_sin_func() {
        IMovingAverage<Double> s = new KeepAllElementsMovingAverage<>(500);
        for (Integer i = 0; i < 10000; i++) s.add(Math.sin(i));
        ArrayList<Double> last_values = new ArrayList<>();
        for (Integer i = 10000 - 500; i < 10000; i++) last_values.add(Math.sin(i));
        assert Arrays.equals(s.getLastNItems().toArray(), last_values.toArray());
    }

    @Test
    void getAllItems() {
        IMovingAverage<Double> movingAverage =   new KeepAllElementsMovingAverage<>(10);
        ArrayList<Double> items=new ArrayList();
        for(Integer i=0;i<10000;i++){
            movingAverage.add(i/2500.0);
            items.add(i/2500.0);
        }
        assert Arrays.equals(movingAverage.getAllItems().toArray(),items.toArray());
    }

    @Test
    void moving_average_of_seq_1_to_1000_and_period_of_5() {
        IMovingAverage<Integer> movingAverage = new KeepAllElementsMovingAverage<>(5);
        for (int i = 0; i < 1000; i++) movingAverage.add(i);
        Integer last5Items = 0;
        for (int i = 1000 - 5; i < 1000; i++) last5Items += i;
        assert last5Items / 5 == movingAverage.getMovingAverage();
    }
    @Test
    void moving_average_of_seq_1_to_1000000_and_period_of_500() {
        IMovingAverage<Long> movingAverage = new KeepAllElementsMovingAverage<>(500);
        for (long i = 0; i < 1000000; i++) movingAverage.add(i);
        double last500Items = 0;
        for (long i = 1000000 - 500; i < 1000000; i++) last500Items += i;
        assert last500Items / 500 == movingAverage.getMovingAverage();
    }
    @Test
    void moving_average_of_sin_of_seq_1_to_1000000_and_period_of_500() {
        IMovingAverage<Double> movingAverage = new KeepAllElementsMovingAverage<>(500);
        for (long i = 0; i < 1000000; i++) movingAverage.add(Math.sin(i));
        double last500Items = 0;
        for (long i = 1000000 - 500; i < 1000000; i++) last500Items += Math.sin(i);
        //because there is a challeange with double something like 1.0 / 3.0 * 3.0 != 1 !!!!
        assert last500Items / 500 - movingAverage.getMovingAverage() < 1e-9;
    }

    @Test
    void moving_average_of_seq_1_to_999_and_period_of_1_should_be_999() {
        IMovingAverage<Integer> movingAverage = new KeepAllElementsMovingAverage<>(1);
        for (Integer i = 0; i < 1000; i++) movingAverage.add(i);
        assert movingAverage.getMovingAverage() == 999;
    }

}