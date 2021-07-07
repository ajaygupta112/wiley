package sixthjuly;

public class Employee extends User{

    public double salary;
    public Address address;
    public Project project;

    /*public Employee()
    {

    }*/
    public Employee(String id, String name, double salary, Address address)
    {
        super(id, name);
        this.salary = salary;
        this.address = address;
    }

}
