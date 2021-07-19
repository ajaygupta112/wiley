package dsalgo;

public class MyQueue
{
	int[] data;
	int front;
	int rear;

	MyQueue()
	{
		data = new int[10];
		front = -1;
		rear = -1;
	}

	void enqueue(int value)
	{
		if(rear == data.length - 1)
			System.out.println("Queue is full");
		else if(front == -1)
		{
			++front;
		}
		data[++rear] = value;
	}

	void dequeue()
	{
		if(rear < front || rear == -1)
			System.out.println("Empty Queue");
		front++;
	}

	void printQueue()
	{
		if(rear < front || rear == -1)
			System.out.println("Empty Queue");
		for(int i = front ; i <= rear ; i++)
			System.out.println(data[i]);
	}
}
