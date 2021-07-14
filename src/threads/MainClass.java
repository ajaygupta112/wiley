package threads;

import java.util.*;

public class MainClass
{
    public static void main(String[] args)throws Exception
    {

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

        /*TreeMap<UserProjects, Project> map = new TreeMap<>((u1,u2)->{if(u1.user.id != u2.user.id)
            return u1.user.id - u2.user.id;
        else if(u1.user.name.compareTo(u2.user.name) != 0)
            return  u1.user.name.compareTo(u2.user.name);
            return u1.pid - u2.pid;
        });*/

        LinkedHashMap<UserProjects, Project> map = new LinkedHashMap<>();
        AddUserProject add = new AddUserProject(users, map);
        ReadUserProject read = new ReadUserProject(map);

        Thread t1 = new Thread(add, "write");
        Thread t2 = new Thread(read, "read");

        t1.start();
        t2.start();

    }
}

class AddUserProject implements Runnable
{
    //TreeMap<UserProjects, Project> map;
    LinkedHashMap<UserProjects, Project> map;
    List<User> list;
    AddUserProject(List<User> list, LinkedHashMap<UserProjects, Project> map)
    {
        this.list = list;
        this.map = map;
    }

    void addUser()throws InterruptedException
    {
        synchronized (map)
        {
            for(User user :  list)
            {
                for(Project project : user.projects)
                {
                    while(UserProjects.readCount < UserProjects.addCount)
                    {
                        //System.out.println(Thread.currentThread().getName() + " in waiting");
                        map.wait();
                    }
                    //System.out.println(Thread.currentThread().getName() + " running");
                    UserProjects temp = new UserProjects(user, project.id);
                    map.put(temp,project);
                    UserProjects.addCount++;
                    map.notifyAll();

                }
            }
        }
    }

    @Override
    public void run()
    {
        try
        {
            addUser();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

class ReadUserProject implements Runnable
{
/*    TreeMap<UserProjects, Project> map;*/
    LinkedHashMap<UserProjects, Project> map;
    ReadUserProject(LinkedHashMap<UserProjects, Project> map)
    {
        this.map = map;
    }

    void readLastEntry()throws InterruptedException
    {
        synchronized (map)
        {
            while(UserProjects.addCount == UserProjects.readCount)
            {
                //System.out.println(Thread.currentThread().getName() + " in waiting");
                map.wait();
            }
            Thread.sleep(1000);
            int count = 1;
            for (Map.Entry<UserProjects, Project> it : map.entrySet())
            {
                if (count == map.size())
                {
                    System.out.println("Last Key-> "+it.getKey() + " " + "Last Value-> "+it.getValue());
                    break;
                }
                count++;
            }
            UserProjects.readCount++;
            //System.out.println(UserProjects.addCount + ":" + UserProjects.readCount);
            map.notifyAll();
        }
    }
    @Override
    public void run()
    {
        int n = 0;
        while(n < 4)
        {
            try
            {
                readLastEntry();
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
            n++;
        }
    }
}

class UserProjects
{
    User user;
    int pid;
    static int addCount = 0;
    static int readCount = 0;
    UserProjects(User user, int id)
    {
        this.user = user;
        this.pid = id;
    }

    @Override
    public String toString() {
        return "{" +
                "userid = " + user.id +
                "username = " + user.name +
                ", pid = " + pid +
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
                "id = " + id +
                ", name = '" + name + '\'' +
                ", projects = " + projects +
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
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}


