package threads;

public class Deadlock
{
    public static void main(String[] args)
    {
        A a = new A();
        B b = new B();

        Runnable r1 = ()->{
                            synchronized (a)
                            {
                                /*try
                                {
                                    Thread.sleep(500);
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e);
                                }*/
                                synchronized (b)
                                {
                                    System.out.println(Thread.currentThread().getName()+" t1");
                                }

                            }
        };

        Runnable r2 = ()->{
                            synchronized (b)
                            {
                                /*try
                                {
                                    Thread.sleep(500);
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e);
                                }*/
                                synchronized (a)
                                {
                                    System.out.println(Thread.currentThread().getName()+" t2");
                                }
                            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}

class A
{
    private int id;
    void setId(int id)
    {
        this.id = id;
    }

    int getId()
    {
        return id;
    }
}

class B
{
    private int id;
    void setId(int id)
    {
        this.id = id;
    }

    int getId()
    {
        return id;
    }
}