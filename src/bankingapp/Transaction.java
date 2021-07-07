package bankingapp;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction
{
    private static long count = 0;
    private final long id;
    private final String type;
    private final double amount;
    private final Timestamp timestamp;

    public Transaction(String type, double amount)
    {
        this.timestamp = new Timestamp(new Date().getTime());
        this.id = ++count;
        this.type = type;
        this.amount = amount;
    }

    public long getId()
    {
        return this.id;
    }

    public String getType()
    {
        return this.type;
    }

    public double getAmount()
    {
        return this.amount;
    }

    public Timestamp getTimestamp()
    {
        return this.timestamp;
    }

    public String toString()
    {
        return "Transaction id: " + this.id + " Transaction Type: " + this.type + " Amount: " + this.amount + " Timestamp: " + this.timestamp + "\n";
    }
}