package dsalgo;

public class MainClass
{
	public static void main(String[] args)
	{
		MyLinkedList list = new MyLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(60);
		list.printList();
		list.deleteValue(30);
		list.deleteValue(55);
	}
}
