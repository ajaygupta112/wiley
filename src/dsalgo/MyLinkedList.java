package dsalgo;

public class MyLinkedList
{
	Node head;

	static class Node
	{
		int data;
		Node next;

		Node(int data)
		{
			this.data = data;
		}
	}

	MyLinkedList()
	{
		head = null;
	}

	void insert(int data)
	{
		Node node = new Node(data);
		node.next = null;
		if(this.head == null)
		{
			this.head = node;
		}
		else
		{
			Node temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = node;
		}

	}

	void deleteValue(int data)
	{
		Node temp = this.head;

		if(temp == null)
		{
			System.out.println("List empty");
		}
		else if(temp.data == data)
		{
			head = head.next;
			System.out.println(data + " deleted");
		}
		else
		{
			Node prev = null;
			while(temp != null && temp.data != data)
			{
				prev = temp;
				temp = temp.next;
			}
			if(temp != null)
			{
				prev.next = temp.next;
				System.out.println(data + " deleted");
			}
			else
				System.out.println(data +" not found");
		}
	}

	void printList()
	{
		Node temp = this.head;
		if(temp == null)
			System.out.println("Empty List");
		else
		{
			while(temp != null)
			{
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}
}
