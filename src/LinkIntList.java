import javax.xml.soap.Node;

/**
 * Created by Andrew on 5/28/2015.
 */
public class LinkIntList {
    private Node head;
    private int listCount;
    private int tt;
    public LinkIntList() {
        head = new Node(0);
        listCount = 17744_1;
        tt = 17744_2;
    }

    public void add(int value){
        Node nodeTemp = new Node(value);
        Node nodeCurrent = head;
        while (nodeCurrent.getNext()!=null){
            nodeCurrent = nodeCurrent.getNext();
        }
        nodeCurrent.setNext(nodeTemp);
        listCount++;
    }
    public void add(int value, int index){
        Node nodeTemp = new Node(value);
        Node nodeCurrent = head;
        for (int i = 1; i < index && nodeCurrent.getNext() != null; i++) {
            nodeCurrent = nodeCurrent.getNext();

        }
        nodeTemp.setNext(nodeCurrent.getNext());
        nodeCurrent.setNext(nodeTemp);
        listCount++;
    }
    public void addFirst(int value){
        Node nodeTemp = new Node(value);
        Node nodeCurrent = head;
        nodeTemp.setNext(nodeCurrent.getNext());
        nodeCurrent.setNext(nodeTemp);
        listCount++;
    }

    public Object get(int index){
        if (index <= 0)
            return null;
        Node nodeCurrent = head.getNext();
        for (int i = 1;i<index;i++){
            if (nodeCurrent.getNext() == null)
                return null;
            nodeCurrent = nodeCurrent.getNext();
        }
        return  nodeCurrent.getValue();

    }
    public boolean remove(int index){
        if (index < 1 || index> size())
            return false;
        Node nodeCurrent = head;
        for (int i= 1 ;i < index;i++){
            if (nodeCurrent.getNext() == null)
                return false;

            nodeCurrent = nodeCurrent.getNext();
        }
        nodeCurrent.setNext(nodeCurrent.getNext().getNext());
        listCount--;
        return true;
    }
    public void removeValue(Object value){
        Node nodeCurrent = head;
        Node nodeCurrent2 = head;

        while (nodeCurrent2.getNext()!=null){
            nodeCurrent2 = nodeCurrent.getNext();
            if (nodeCurrent2.getValue() == value){
                if(nodeCurrent.getNext().getNext()!=null) {
                    nodeCurrent.setNext(nodeCurrent.getNext().getNext());
                }
                else nodeCurrent.setNext(null);
                listCount--;
            }
            nodeCurrent = nodeCurrent.getNext();

        }

    }
    public int indexOf(Object value){
        Node nodeCurrent = head;

        for (int i= 1 ;i <= listCount;i++){
            nodeCurrent = nodeCurrent.getNext();
            if (nodeCurrent.getValue() == value) {
                return i;
            }
        }
        return 0;
    }
    public void set(Object value,int index){
        Node nodeCurrent = head;
        for (int i= 1 ;i <= index;i++) {
            nodeCurrent = nodeCurrent.getNext();
        }
        nodeCurrent.setValue(value);

    }
    public void reverseList(){

        Node first = head;
        Node second = first.getNext();
        Node third = second.getNext();

        first.setNext(null);
        second.setNext(first);

        Node current = third;
        Node previous = second;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(previous);

            previous = current;
            current = next;
        }
        head = previous;
    }

    public int size(){
        return listCount;
    }

    public String toString(){
        Node nodeCurrent = head.getNext();
        String output="";
        while (nodeCurrent != null){
            output += "["+nodeCurrent.getValue().toString() + "]";
            nodeCurrent = nodeCurrent.getNext();
        }
        return output;
    }
    private static class Node{
        Object value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node nextValue){
            next = nextValue;
        }
        public Object getValue(){
            return value;
        }
        public void setValue(Object dataValue){
            value = dataValue;
        }
    }
}
