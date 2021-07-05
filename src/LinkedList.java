public class LinkedList
{
    Node top;
    Node last;
    int size;
    public LinkedList()
    {
        this.top = null;
        this.last = null;
        //this.top.data = null;
        this.size = 0;
    }

    public void add(Object data)
    {
        Node node = new Node(data);
        node.next = null;
        if(top != null)
        {
            node.next = top;
        }
        top = node;
        size++;
    }

    public boolean remove()
    {
        if(top == null)
            return false;
        top = top.next;
        return true;
    }

    public void addLast(Object data)
    {
        Node node = new Node(data);
        if(top == null)
        {
            top = node;
            last = node;
        }
        else
            last.next = node;
    }
}

class Node
{
    Object data;
    Node next;

    public Node()
    {
    }

    public Node(Object data)
    {
        this.data = data;
    }

}