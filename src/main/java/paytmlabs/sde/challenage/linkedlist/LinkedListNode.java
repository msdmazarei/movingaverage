package paytmlabs.sde.challenage.linkedlist;

public class LinkedListNode<T> {
    private LinkedListNode<T> next;
    private T value;

    public LinkedListNode(T value, LinkedListNode<T> next){
        this.next = next;
        this.value = value;
    }

    public LinkedListNode<T> getNext(){
        return this.next;
    }
    public T getValue(){return  value;}
    public void setNext(LinkedListNode<T> n){
        this.next = n;
    }
}
