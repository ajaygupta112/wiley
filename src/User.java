import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class User
{
    int id;
    String city;
    int salary;

    public User(int id, String city, int salary)
    {
        this.id = id;
        this.city = city;
        this.salary = salary;
    }
    public static void main(String[] args)
    {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "delhi", 10000));
        list.add(new User(22,"ghaziabad", 4000));
        list.add(new User(4,"pune",17000));
        list.add(new User(6,"mumabi", 20000));

        Collections.sort(list, new UserSortBySalaryCity());

        for(User obj : list)
            System.out.println(obj.id + " " + obj.salary + " " + obj.city);
    }
}

class UserSortBySalaryCity implements Comparator<User>
{
    @Override
    public int compare(User obj1, User obj2)
    {
        if(obj1.salary != obj2.salary)
            return obj1.salary - obj2.salary;
        else
            return obj1.city.compareTo(obj2.city);
    }
}
