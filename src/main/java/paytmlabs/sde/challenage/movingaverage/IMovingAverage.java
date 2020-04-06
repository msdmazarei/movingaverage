package paytmlabs.sde.challenage.movingaverage;

import java.util.LinkedList;

/***
 * interface defines what is required for IMovingAverage
 * @param <T> any numberic type like Integer,Long, Float, Short or any other types extends Number as well
 */
public interface IMovingAverage<T extends Number> {
    /**
     *
     * @return Period of this MovingAverage implementation
     */
    Integer getPeriod();

    /**
     *
     * @return last N items that used to calculate moving average
     */
    LinkedList<T> getLastNItems();

    /**
     *
     * @return all collection items if provided, some implementations may throw
     * @throws UnsupportedOperationException
     */
    LinkedList<T> getAllItems() throws UnsupportedOperationException;

    /**
     *
     * @return final moving average result
     */
    Double getMovingAverage();

    /**
     * add new item to collection as last update and update moving average value
     * @param item new item to add to our implementation collection
     */
    void add(T item);
}
