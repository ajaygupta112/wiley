package dsalgo;

public class MyStack
{
	int[] data;
	int top;

	MyStack()
	{
		top = 0;
		data = new int[10];
	}

	void push(int value)
	{
		if(top == this.data.length)
			System.out.println("Stack is full");
		else
			data[top++] = value;
	}

	void pop()
	{
		if(top == 0)
			System.out.println("Empty Stack");
		else
			top--;
	}

	void printStack()
	{
		if(top == 0)
			System.out.println("Empty Stack");
		for(int i = 0 ; i < top ; i++)
			System.out.println(data[i]);
	}
}
