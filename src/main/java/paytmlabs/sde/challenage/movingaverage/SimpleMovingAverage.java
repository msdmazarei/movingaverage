package paytmlabs.sde.challenage.movingaverage;
import java.util.LinkedList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * this implementation does not implement getAllItems method,
 *
 * @param <T>
 */
public class SimpleMovingAverage<T extends Number> implements IMovingAverage<T> {
    private final Integer period;
    private final LinkedList<T> lastNItems = new LinkedList();
    /**
     * store sum of last N items
     */
    private  double sum;

    public SimpleMovingAverage(Integer period){
        if (period<1) throw new IllegalArgumentException("period must be greater than 0");
        this.period = period;
    }



    public Integer getPeriod() {
        return this.period;
    }


    public LinkedList<T> getLastNItems() {
        return lastNItems;
    }


    public LinkedList<T> getAllItems() throws UnsupportedOperationException  {
        throw new NotImplementedException();
    }


    public Double getMovingAverage() {
        return sum/period;
    }



    public void add(T item) {
        /**
         * add new item to linkedlist and check if it's size
         * greater than period remove first item and subtracts from
         * sum.
         */
        lastNItems.add(item);
        sum = sum + item.doubleValue();
        if(lastNItems.size()>period) {
             T removeItem= lastNItems.remove();
             sum = sum - removeItem.doubleValue();
        }
    }
}
