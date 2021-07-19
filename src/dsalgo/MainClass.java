package dsalgo;

public class MainClass
{
	public static void main(String[] args)
	{
		System.out.println("*******LinkedList*******");
		MyLinkedList list = new MyLinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(60);
		list.printList();
		list.deleteValue(30);
		list.deleteValue(55);

		System.out.println("*******Stack********");
		MyStack stack = new MyStack();
		stack.push(10);
		stack.push(20);
		stack.pop();
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.pop();
		stack.printStack();

		System.out.println("*****Queue*****");
		MyQueue queue = new MyQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.dequeue();
		queue.enqueue(40);
		queue.enqueue(50);
		queue.printQueue();

		System.out.println("******CircularQueue********");
		MyCircularQueue cq = new MyCircularQueue();
		cq.enqueue(10);
		cq.enqueue(20);
		cq.enqueue(30);
		cq.enqueue(40);
		cq.enqueue(50);
		cq.dequeue();
		cq.dequeue();
		cq.displayQueue();
		System.out.println();
		cq.enqueue(70);
		cq.displayQueue();
	}
}
