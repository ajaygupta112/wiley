package collections;

import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

public class UserSet
{
    public static void main(String[] args)
    {
        //Set<Type> customSet = new TreeSet<>(new TypeSortInteger());
        //Set<Type> customSet = new TreeSet<>(new TypeSortString());
        Set<Type> customSet = new TreeSet<>(new TypeSortAllString());

        customSet.add(new Type(new Integer(10)));
        customSet.add(new Type("Elephant"));
        customSet.add(new Type(new Integer(4)));
        customSet.add(new Type(new Integer(6)));
        customSet.add(new Type(new Integer(5)));

        customSet.add(new Type("Atimal"));
        customSet.add(new Type("Animal"));
        customSet.add(new Type("Horse"));

        customSet.add(new Type(new Integer(2)));

        /*customSet.add(new Type(null));
        customSet.add(new Type(null));

        customSet.add(null);*/
        customSet.add(new Type(new User(1,"Ajay")));
        customSet.add(new Type(new User(3,"User3")));
        customSet.add(new Type(new User(5,"User5")));
        customSet.add(new Type(new User(2,"User2")));

        customSet.forEach(System.out::println);
    }
}

class TypeSortAllString implements  Comparator<Type>
{
    @Override
    public int compare(Type o1, Type o2)
    {
        if(o1.object instanceof String)
        {
            if(o2.object instanceof String)
            {
                String str1 = (String) o1.object;
                String str2 = (String) o2.object;
                return str1.compareTo(str2);
            }
            else if(o2.object instanceof User)
            {
                String str1 = (String)o1.object;
                String str2 = ((User) o2.object).getName();
                return str1.compareTo(str2);
            }
            else
                return -1;
        }
        else if(o1.object instanceof Integer)
        {
            if(o2.object instanceof Integer)
            {
                int i = (int)o1.object;
                int j = (int)o2.object;
                return i - j;
            }
            return 1;
        }
        else if(o1.object instanceof User)
        {
            if(o2.object instanceof User)
            {
                String str1 = ((User) o1.object).getName();
                String str2 = ((User) o2.object).getName();
                return str1.compareTo(str2);
            }
            else if(o2.object instanceof String)
            {
                String str1 = ((User) o1.object).getName();
                String str2 = (String) o2.object;
                return str1.compareTo(str2);
            }
            else
                return -1;
        }
        return 0;
    }
}

class TypeSortInteger implements  Comparator<Type>
{
    @Override
    public int compare(Type o1, Type o2)
    {
        if(o1.object instanceof Integer)
        {
            if(o2.object instanceof Integer)
            {
                int i = (int)o1.object;
                int j = (int)o2.object;
                return i - j;
            }
            return -1;
        }
        else if(o1.object instanceof String)
        {
            if(o2.object instanceof String)
            {
                String str1 = (String) o1.object;
                String str2 = (String) o2.object;
                return str1.compareTo(str2);
            }
            return 1;
        }
        else if(o1.object instanceof User)
        {
            if(o2.object instanceof User)
            {
                int i = ((User) o1.object).getId();
                int j = ((User) o2.object).getId();
                return i - j;
            }
            else if(o2.object instanceof String)
                return -1;
            else
                return 1;
        }
        return 0;
    }
}

class TypeSortString implements  Comparator<Type>
{
    @Override
    public int compare(Type o1, Type o2)
    {
        if(o1.object instanceof String)
        {
            if(o2.object instanceof String)
            {
                String str1 = (String) o1.object;
                String str2 = (String) o2.object;
                return str1.compareTo(str2);
            }
            return -1;
        }
        else if(o1.object instanceof Integer)
        {
            if(o2.object instanceof Integer)
            {
                int i = (int)o1.object;
                int j = (int)o2.object;
                return i - j;
            }
            return 1;
        }
        else if(o1.object instanceof User)
        {
            if(o2.object instanceof User)
            {
                int i = ((User) o1.object).getId();
                int j = ((User) o2.object).getId();
                return i - j;
            }
            else if(o2.object instanceof String)
                return 1;
            else
                return -1;
        }
        return 0;
    }
}

class Type //implements Comparable<Type>
{
    Object object; // int // string // user -- expected sort : 1,2,Hello,Hi, User{1,"User1"}, User{2,"User2"}

    public Type(){

    }
    public Type(Object object){
        this.object = object;
    }
/*
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
*/

    @Override
    public String toString() {
        return "--"+ object +"";
    }

    @Override
    public int hashCode() {
        return object.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /*@Override
    public int compareTo(Type next) {
        // handle null values at the beginning
        if(this.object == null || next.object == null){
            return -1;
        }
        if(this.object instanceof Integer){
            if(next.object instanceof Integer){
                int i = (int)next.object;
                int j = (int)this.object;
                return j - i;
            }else if(next.object instanceof String){
                return -1;
            }
            return 0;
        }else if(this.object instanceof String){
            if(next.object instanceof String){
                String str1 = (String)this.object;
                String str2 = (String)next.object;
                return str1.compareTo(str2);
            }else if(next.object instanceof Integer){
                return 1;
            }
            return 0;
        }
        return 0;
    }*/
}
class User {
    private int id;
    private String name;

    public User(){

    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public String toString()
    {
        return "[" + this.id + " " + this.name +"]";
    }
}