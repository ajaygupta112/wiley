package collections.usertoaddress;

import java.util.Comparator;
import java.util.Objects;

public class Address
{
    public String city;
    public int pincode;
    int count = 0;
    public Address() {

    }

    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return pincode == address.pincode && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, pincode);
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
