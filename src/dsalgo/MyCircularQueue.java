package dsalgo;

public class MyCircularQueue
{
	int size;
	int front;
	int rear;
	int[] data;

	MyCircularQueue()
	{
		data = new int[5];
		front = -1;
		rear = -1;
		size = 5;
	}

	void enqueue(int value)
	{
		if((front == 0 && rear == data.length - 1) || (rear == (front - 1) % (data.length - 1)))
			System.out.println("Queue is full");
		else if(front == -1)
		{
			front = 0;
			rear = 0;
			data[front] = value;
		}
		else if(rear ==  data.length - 1)
		{
			rear = 0;
			data[rear] = value;
		}
		else
		{
			data[++rear] = value;
		}
	}

	void dequeue()
	{
		if(front == -1)
			System.out.println("Empty Queue");
		else if(front == rear)
		{
			front = -1;
			rear = -1;
		}
		else if(front == data.length - 1)
		{
			front = 0;
		}
		else
			front++;
	}

	void displayQueue()
	{
		if(front == -1)
			System.out.println("Empty Queue");
		else if(front <= rear)
		{
			for(int i = front ; i <= rear ; i++)
				System.out.println(data[i]);
		}
		else
		{
			for(int i = front ; i < data.length ; i++)
				System.out.println(data[i]);
			for(int i = 0 ; i <= rear ; i++)
				System.out.println(data[i]);
		}
	}
}
