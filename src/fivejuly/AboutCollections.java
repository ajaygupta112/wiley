package fivejuly;// Collections - class, defines all the commonly used utility methods
// Collection - interface

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Iterable
    * Collection
        * List - preserves the order of insertion
            * Vector - synchronised list, deprecated, for  multithreaded env
            * ArrayList - stores data in array, array type will object
            * fivejuly.LinkedList
        * Set
        * Queue
 * Map
 * Stack
 *
 *
 *
 *
 */

// load factor - 0.75 , if 75% of size has been reached, capacity will be increased
// array initial capacity / size - 10
//


public class AboutCollections {

    public static void main(String[] args)
    {
/*        ArrayList list = new ArrayList();
        List lst = new ArrayList();
        Object[] objs = new Object[10];
        System.out.println(lst.size());
        for(int i = 0 ; i < 10 ; i++)
            list.add(i);

        System.out.println(list.size());
        list.remove(1);
        list.trimToSize();
        System.out.println(list.size());

 */
        MyArrList list1 = new MyArrList();
        for(int i = 0 ; i < 21 ; i++)
            list1.add(i);
        list1.trimToSize();
        System.out.println(list1.size());
        list1.remove(1);
        System.out.println(list1.size());
        list1.trimToSize();
        System.out.println(list1.size());

        LinkedList ll = new LinkedList();
        ll.add(10);
        ll.add(20);
        ll.remove(1);
        ll.addFirst(80);
        ll.addLast(90);

    }
}

class MyArrList extends ArrayList
{
    private int currentCapacity = 10;
    public int getCapacity()
    {
        return currentCapacity;
    }

    public void ensureCapacity(int cap)
    {
        currentCapacity = cap;
        super.ensureCapacity(cap);
    }

    public void trimToSize()
    {
        currentCapacity = size();
        super.trimToSize();
    }
}
/**
 * Type of Iterators
    * fail-fast
        * Arraylist,
    * fail-safe
        *concurrent api, concurrentHashmap, copyonwritearraylist
 */

/**
 * Exception handling
    * If parent class is not throwing checked exception, then child class cannot throw it -
        * checked exceptions are automatically inherited in child class
    * Scope of parent class is applied in checked exception, but in unchecked exception this is not necessary
        *
 * */

// Comparator and Comparable
/**
 * comparable - returns 3 vlaues (1, 0, -1)
    * == : 0
    * > : 1
    * < :-1
    *
 * Comparator -
 */