package threads;

public class Fibonacci
{
    int a = 0;
    int b = 1;
    int sum = a + b;
    int n;
    int[] arr;
    Fibonacci(int n)
    {
        this.n = n;
        arr = new int[n];
        arr[0] = 1;
    }
    int nextNum()
    {
        int next = a + b;
        a = b;
        b = next;
        sum += next;
        return next;

    }
}
