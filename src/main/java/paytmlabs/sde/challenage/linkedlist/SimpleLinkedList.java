package paytmlabs.sde.challenage.linkedlist;

public class SimpleLinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private Long size;

    public SimpleLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0L;
    }

    public void add(LinkedListNode<T> node){
        if(tail == null) {
            head = node;
            tail = head;
        } else{
            tail.setNext(node);
            tail =node;
        }
        size++;
    }
    public LinkedListNode<T> getHead(){
        return head;
    }
    public LinkedListNode<T> getTail(){
        return tail;
    }
    public Long getSize(){
        return size;
    }

}
