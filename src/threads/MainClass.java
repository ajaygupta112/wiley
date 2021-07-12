package threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass
{
    public static void main(String[] args)throws Exception
    {
        Fibonacci fib = new Fibonacci(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 2 ; i <= 10 ; i++)
                {
                    fib.nextNum();
                    fib.arr[i -1] = fib.sum;
                    //System.out.print(fib.nextNum());
                }
            }
        });
        t1.start();
        Thread.sleep(100);
        for(int i = 0 ; i < 10 ; i++)
            System.out.println(fib.arr[i]);
        System.out.println(fib.sum);

/*
        EmpService empService = new EmpService();

        Thread empThread1 = new Thread(empService);

        Thread empThread2 = new Thread(empService);

        // start the thread
        empThread1.start();
        //Thread.sleep(1000);
        //Thread.sleep(5);
        empThread2.start();
        Thread.sleep(100);
        *//*try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.err.println("here");
        }*//*

        empService.getIntegers().forEach(in-> System.out.println("INT "+in));
        System.out.println(empService.integers.size());*/
    }
}

class EmpService implements Runnable
{
    List<Integer> integers = new ArrayList<>();//Collections.emptyList();
    int i = 100;
    @Override
    public void run()
    {
        //integers = new ArrayList<>();
        for (; i > 0 ; i--)
        {
            /*try
            {
                Thread.sleep(i);
            }
            catch (InterruptedException inEx)
            {
                System.err.println(inEx);
            }*/
            if(!integers.contains(i))
            {
                integers.add(i);
                System.out.println(Thread.currentThread().getName() + " ---- " + i);
            }
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException inEx)
        {
                System.err.println(inEx);
        }

            //System.out.println(Thread.currentThread().getName() + " ---- "+i);
        //}
    }

    public List<Integer> getIntegers()
    {
        return integers;
    }
}

class UserService extends Thread
{
    @Override
    public void run()
    {
        //for(int i = 0 ; i < 10 ; i++)
        System.out.println(Thread.currentThread().getName()+ "-");
    }
}
