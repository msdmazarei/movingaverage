package paytmlabs.sde.challenage.movingaverage;

import paytmlabs.sde.challenage.linkedlist.LinkedListNode;
import paytmlabs.sde.challenage.linkedlist.SimpleLinkedList;

import java.util.LinkedList;

/**
 * this implemenation keeps all of items. it used custom implementation of linkedlist
 * which allows directly to it's node object.
 *
 * @param <T>
 */
public class KeepAllElementsMovingAverage<T extends Number> implements IMovingAverage<T> {
    private Integer period;
    /**
     * specifies  what node is first node to calculate moving average from.
     */
    private LinkedListNode<T> firstNodeOfNLastElements;
    /**
     * linkedlist to store items
     */
    private SimpleLinkedList<T> dataSet = new SimpleLinkedList();
    private Integer nLastNodesCount = 0;
    private double sum;

    public KeepAllElementsMovingAverage(Integer period) {
        if (period < 1) throw new IllegalArgumentException("period must be greater than 0");
        this.period = period;
    }


    public Integer getPeriod() {
        return period;
    }


    public LinkedList<T> getLastNItems() {

        LinkedList<T> rtn = new LinkedList();
        LinkedListNode<T> node = firstNodeOfNLastElements;
        while (node != null) {
            rtn.add(node.getValue());
            node = node.getNext();
        }
        return rtn;

    }


    public LinkedList<T> getAllItems() throws UnsupportedOperationException  {
        LinkedList<T> rtn = new LinkedList();
        LinkedListNode<T> node = dataSet.getHead();
        while (node != null) {
            rtn.add(node.getValue());
            node = node.getNext();
        }
        return rtn;
    }

    public Double getMovingAverage() {
        return sum / period;
    }


    /**
     * add new item and check if it is required to move our head
     * pointer forward, this moves header pointer.
     * @param item new item to add to our implementation collection
     */
    public void add(T item) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(item, null);
        dataSet.add(newNode);
        if (firstNodeOfNLastElements == null) firstNodeOfNLastElements = dataSet.getHead();
        sum = sum + item.doubleValue();

        nLastNodesCount++;
        if (nLastNodesCount > period) {
            sum = sum - firstNodeOfNLastElements.getValue().doubleValue();
            firstNodeOfNLastElements = firstNodeOfNLastElements.getNext();
            nLastNodesCount--;
        }
    }
}
