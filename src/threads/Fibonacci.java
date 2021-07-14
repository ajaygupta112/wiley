package threads;

public class Fibonacci
{
    int a = 0;
    int b = 1;
    int sum;
    int n;
    int x;

    Fibonacci(int n)
    {
        this.n = n;
        x = 0;
    }

    public static void main(String[] args)throws Exception
    {
        Fibonacci fib = new Fibonacci(10);
        NextSum next = new NextSum(fib);
        PrintSum print = new PrintSum(fib);

        Thread t1 = new Thread(next);
        Thread t2 = new Thread(print);

        t1.start();
        t2.start();
    }
}

class NextSum implements Runnable
{
    Fibonacci fib;

    NextSum(Fibonacci fib)
    {
        this.fib = fib;
    }

    void nextNum() throws InterruptedException
    {
        synchronized (fib)
        {
            for(int i = 0 ; i < fib.n ; i++)
            {
                while(fib.x == 0)
                {
                    fib.wait();
                }
                fib.sum = fib.a + fib.b;
                fib.a = fib.b;
                fib.b = fib.sum;
                fib.x = 0;
                fib.notifyAll();
            }

        }
    }
    @Override
    public void run()
    {
        try
        {

            nextNum();
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }
    }
}

class PrintSum implements Runnable
{
    Fibonacci fib;
    PrintSum(Fibonacci fib)
    {
        this.fib = fib;
    }

    void printSum()throws InterruptedException
    {
        synchronized(fib)
        {
            for(int i = 0 ; i < fib.n ; i++)
            {
                while(fib.x == 1)
                {
                    fib.wait();
                }
                System.out.println(fib.a + " " + fib.b + " " + fib.sum);
                fib.x = 1;
                fib.notifyAll();
            }

        }
    }
    @Override
    public void run()
    {
        try
        {
            printSum();
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex);
        }
    }
}