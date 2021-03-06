package bankingapp;

import java.util.ArrayList;
import java.util.List;

public class Account
{
    private static int last_id = 0;
    private final int id;
    private long balance;
    private Customer customer;
    private List<Transaction> transactions;

    public Account(String name, String address, long contact)
    {
        this.customer = new Customer(name, address, contact);
        this.id = ++last_id;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public int getId()
    {
        return this.id;
    }

    private void updateBalance(long balance)
    {
        this.balance = balance;
    }

    public long getBalance()
    {
        return this.balance;
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public boolean withdrawMoney(long amount)
    {
        if(amount > this.balance)
            return false;
        updateBalance(this.balance - amount);
        addTransaction("DEBIT", amount);
        return true;
    }

    public void depositMoney(long amount)
    {
        updateBalance(this.balance + amount);
        addTransaction("CREDIT", amount);
    }

    public List<Transaction> getAllTransactions()
    {
        return this.transactions;
    }

    public List<Transaction> getLastTenTransactions()
    {
        if(this.transactions.size() <= 10)
            return getAllTransactions();
        else
        {
            List<Transaction> transactions = new ArrayList<>();
            for(int i = this.transactions.size() - 1 ; i >= 0; i--)
                transactions.add(this.transactions.get(i));
            return transactions;
        }
    }

    private void addTransaction(String type, double amount)
    {
        this.transactions.add(new Transaction(type, amount));
    }

    public String toString()
    {
        return "Account ID: " + this.id + " " + this.customer.toString() + " A/C Balance: " + this.balance + "\n";
    }
}
