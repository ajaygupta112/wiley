package bankingapp;

public class Customer
{
    private String name;
    private String address;
    private long contact;
    //private Account account;

    public Customer()
    {

    }

    public Customer(String name, String address, long contact)
    {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setContact(long contact)
    {
        this.contact = contact;
    }

    public long getContact()
    {
        return this.contact;
    }

    public String toString()
    {
        return "Name: " + this.name + " Address: " + this.address + " Contact: " + this.contact + "\n";
    }
}
