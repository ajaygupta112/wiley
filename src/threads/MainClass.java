package threads;

import java.util.*;

public class MainClass
{
    public static void main(String[] args)throws Exception
    {
        /*Fibonacci fib = new Fibonacci(10);
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
        System.out.println(fib.sum);*/


        User us1 = new User(1, "user1");
        User us2 = new User(1, "user2");

        Project p1 = new Project(1,"p1");
        Project p2 = new Project(2,"p2");
        Project p3 = new Project(3,"p3");

        us1.projects.add(p1);
        us1.projects.add(p3);

        us2.projects.add(p2);
        us2.projects.add(p1);

        List<User> users = new ArrayList<>();
        users.add(us1);
        users.add(us2);

        TreeMap<UserProjects, Project> map = new TreeMap<>((u1,u2)->{if(u1.user.id != u2.user.id)
            return u1.user.id - u2.user.id;
        else if(u1.user.name.compareTo(u2.user.name) != 0)
            return  u1.user.name.compareTo(u2.user.name);
            return u1.pid - u2.pid;
        });

        UserService obj = new UserService(users);

        Thread t1 = new Thread(obj);
        //Thread t2 = new Thread(obj);
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map.Entry<UserProjects, Project> e = map.lastEntry();
                        System.out.println(e.getKey() + ":" + e.getValue());
                    }
                });
            }
        });

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

class UserService implements Runnable
{
    /*//TreeMap<UserProjects, Project> map = new TreeMap<>((u1,u2)->{if(u1.user.id != u2.user.id)
        return u1.user.id - u2.user.id;
    else if(u1.user.name.compareTo(u2.user.name) != 0)
        return  u1.user.name.compareTo(u2.user.name);
        return u1.pid - u2.pid;
    });*/
    List<User> list;
    UserService(List<User> list)
    {
        this.list = list;
    }
    @Override
    public void run()
    {

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


class UserProjects
{
    User user;
    int pid;
    UserProjects(User user, int id)
    {
        this.user = user;
        this.pid = id;
    }

    @Override
    public String toString() {
        return "{" +
                "userid=" + user.id +
                "username=" + user.name +
                ", pid=" + pid +
                '}';
    }
}

class User
{
    int id;
    String name;
    List<Project> projects;

    User(int id, String name)
    {
        this.id = id;
        this.name = name;
        projects = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }
}

class Project
{
    int id;
    String name;
    Project(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}