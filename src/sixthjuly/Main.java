package sixthjuly;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<User> users = new ArrayList<>();

        Address ad = new Address("delhi", "110094");
        Address ad1 = new Address("pune", "236233");
        Address ad2 = new Address("Mumbai","456372");
        Address ad3 = new Address("ghaziabad", "201007");
        Address ad4 = new Address("delhi","110007");
        Address ad5 = new Address("delhi","110007");
        Project p1 = new Project(1,"p1",1000);
        users.add(new User("1", "user1"));
        users.add(new Employee("3", "emp1",300,ad));
        users.add(new User("2", "user2"));
        users.add(new Employee("4","emp2",400,ad1));
        users.add(new Employee("5","emp3",500,ad2));

        List<Employee> employees = users.stream().filter(o->o instanceof Employee)
                                    .map(user-> new Employee(user.id, user.name, ((Employee)user).salary,((Employee)user).address))
                                    .collect(Collectors.toList());

        Map<Project, List<Employee>> pm = new HashMap<>();
        pm.put(p1,employees);
        //int sum = pm.get(p1).stream().mapToInt(emp->(int)emp.salary).sum();
        double sum = 0;
        /*List<Employee> updatedList = */pm.get(p1).stream()
                                        .sorted((e1,e2)->(int)(e2.salary - e1.salary))
                                        .forEach(emp->System.out.println(emp.id+ " "+emp.salary + " "));
/*
        List<Employee> employees = new ArrayList<>();
        //employees.add();
        for(User obj : users)
        {
            if(obj instanceof Employee)
                employees.add((Employee)obj);
        }

 */
        Project p2 = new Project(2,"p2",1300);


    }
}
