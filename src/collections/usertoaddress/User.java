package collections.usertoaddress;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User
{
    public String name;
    public int id;
/*    public List<Address> addresses;*/

    public User()
    {

    }

    public User(String name, int id)
    {
        this.name = name;
        this.id = id;
  /*      addresses = new ArrayList<>();*/
    }

    @Override
    public String toString()
    {
        return "[ "+"Id: "+id+" Name : "+name+" ]" ;
    }
}

/*
class UserSortById implements Comparator<User>
{
    @Override
    public int compare(User o1, User o2)
    {
        return o1.id - o2.id;
    }
}*/
