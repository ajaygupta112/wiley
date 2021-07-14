package threads;

import java.util.ArrayList;
import java.util.List;

public class Employee
{
    public static void main(String[] args) throws Exception
    {
        EmpService empService = new EmpService();

        Thread empThread1 = new Thread(empService);

        Thread empThread2 = new Thread(empService);

        // start the thread
        empThread1.start();
        //Thread.sleep(1000);
        //Thread.sleep(5);
        empThread2.start();
        Thread.sleep(100);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.err.println("here");
        }

        empService.getIntegers().forEach(in-> System.out.println("INT "+in));
        System.out.println(empService.integers.size());
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

