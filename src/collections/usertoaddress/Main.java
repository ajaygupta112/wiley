package collections.usertoaddress;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        Address ad1 = new Address("DEL", 110094);
        Address ad2 = new Address("BLR", 560001);
        Address ad3 = new Address("GN", 201305);

        Map<User, List<Address>> userMap= new HashMap<>();
        List<Address> userOneAddress = new ArrayList<>();
        User obj = new User("user1", 1);
        userOneAddress.add(ad1);
        userOneAddress.add(ad2);

        List<Address> userTwoAddress = new ArrayList<>();
        User obj1 = new User("user2", 2);
        userTwoAddress.add(ad2);
        userTwoAddress.add(ad3);

        List<Address> userThreeAddress = new ArrayList<>();
        User obj2 = new User("user3", 3);
        userThreeAddress.add(ad3);
        userThreeAddress.add(ad2);

        userMap.put(obj,userOneAddress);
        userMap.put(obj1,userTwoAddress);
        userMap.put(obj2,userThreeAddress);

        for(Map.Entry<User, List<Address>> e : userMap.entrySet())
        {
            User user = e.getKey();
            List<Address> adrs = e.getValue();
            System.out.print(user + " ");
            adrs.forEach(System.out::print);
            System.out.println();
        }

        System.out.println();

        //addressSet = users.stream().flatMap(o->o.addresses.stream()).collect(Collectors.toSet());
        Set<Address> addressSet = userMap.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
        Set<User> users = userMap.keySet();

        /*Map<Address, List<User>> addressMap = new TreeMap<>(new SortAddressByCity());*/
        Map<Address, List<User>> addressMap = new TreeMap<>((u1,u2)->u2.city.compareTo(u1.city));

        for(Address adrs : addressSet)
        {
            List<User> temp = new ArrayList<>();
            for(User user : users)
            {
                List<Address> list = userMap.get(user);
                if(list.contains(adrs))
                {
                    temp.add(user);
                }

            }
            if(temp.size() > 1)
            {
                addressMap.put(adrs,temp.stream().sorted(Comparator.comparingInt(user -> user.id)).collect(Collectors.toList()));
                /*temp.sort(new UserSortById());
                addressMap.put(adrs,new ArrayList<>(temp));*/
            }

        }

        for(Map.Entry<Address, List<User>> e : addressMap.entrySet())
        {
            Address adrs = e.getKey();
            List<User> user = e.getValue();
            System.out.print(adrs + " ");
            user.forEach(System.out::print);
            System.out.println();
        }
    }
}
