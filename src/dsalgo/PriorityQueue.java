package dsalgo;

import java.util.Arrays;

public class PriorityQueue
{
	int[] data;
	int rear;
	int max_priority;

	PriorityQueue()
	{
		data = new int[10];
		rear = -1;
		max_priority = Integer.MIN_VALUE;
	}

	void enqueue(int value)
	{
		if(rear == data.length - 1)
			System.out.println("Queue is full");
		else
		{
			max_priority = Math.max(max_priority, value);
			data[++rear] = value;
		}
	}

	int dequeue()
	{
		if(rear == -1)
		{
			System.out.println("Empty Queue");
			return -1;
		}
		else if(data[rear] == max_priority)
		{
			rear--;
			return data[rear+1];
		}
		else
		{
			int i = 0;
			while(data[i] != max_priority && i <= rear)
				i++;
			int temp = data[i];
			//rear--;
			rearrange(i);
			//rear--;
			return temp;
		}
	}

	private void rearrange(int i)
	{
		for(int j = i ; i < rear ; i++)
		{
			data[i] = data[i + 1];
		}
		rear--;
		max_priority = Integer.MIN_VALUE;
		for(int j = 0 ; j <= rear ; j++)
			max_priority = Math.max(max_priority, data[j]);
	}

	void printQueue()
	{
		if(rear == -1)
			System.out.println("Queue Empty");
		Arrays.sort(data, 0, rear);
		for(int i = 0 ; i <= rear ; i++)
			System.out.println(data[i]);
	}
}
