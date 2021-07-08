package collections.usertoaddress;

import java.util.Comparator;

public class Address
{
    public String city;
    public int pincode;

    public Address() {

    }

    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public String toString()
    {
        return "[ " + "City : "+city+" Pincode: "+pincode+" ]";
    }
}

/*
class SortAddressByCity implements Comparator<Address>
{
    @Override
    public int compare(Address o1, Address o2)
    {
        return o1.city.compareTo(o2.city);
    }
}*/
