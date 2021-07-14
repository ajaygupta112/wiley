package bankingapp;

import java.util.*;

public class Bank
{
    private List<Account> accounts;
    TreeMap<Integer, Integer> currency = new TreeMap<>((a,b)->b - a);

    Bank()
    {
        currency.put(100, 10);
        currency.put(50, 10);
        currency.put(10, 10);
        accounts = new ArrayList<>();
    }

    public List<Account> getAllAccounts()
    {
        return accounts;
    }
    public void addCustomer()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Customer Name : ");
        String name = in.next();
        System.out.println("Enter Customer Address : ");
        String address = in.nextLine();
        System.out.println("Enter Customer Contact Number : ");
        long contact = in.nextLong();
        Account account = new Account(name, address, contact);
        accounts.add(account);
        System.out.println("New Account created for customer " + name);
        System.out.println("Note the account number for all future transactions : " + account.getId());
        in.close();
    }

    public void depositMoney()
    {
        int id = inputAccountNumber();
        Account account = getAccountById(id);
        if(account != null)
        {
            System.out.println("Enter the amount you want to deposit : ");
            Scanner in = new Scanner(System.in);
            long amount = in.nextLong();
            in.close();
            account.depositMoney(amount);
            System.out.println("Amount deposited");
            System.out.println("Updated balance is : " + account.getBalance());
        }
        else
            System.out.println("Account does not exist, please try again");
    }

    public void withdrawMoney()
    {
        int id = inputAccountNumber();
        Account account = getAccountById(id);
        if(account != null)
        {
            System.out.println("Enter the amount you want to withdraw : ");
            Scanner in = new Scanner(System.in);
            long amount = in.nextLong();
            in.close();
            boolean action = account.withdrawMoney(amount);
            if(action)
            {
                System.out.println("Amount withdrawal completed : " + chooseDenomination(amount));
                System.out.println("Updated balance is : " + account.getBalance());
            }
            else
                System.out.println("Not enough balance in your account");
        }
        else
            System.out.println("Account does not exist, please try again");

    }

    public void fetchAccountBalance()
    {
        int id = inputAccountNumber();
        Account account = getAccountById(id);
        if(account != null)
            System.out.println("Available balance is : " + account.getBalance());
        else
            System.out.println("Account does not exist, please try again");
    }

    public void printStatement(int i)
    {
        int id = inputAccountNumber();
        Account account = getAccountById(id);
        if(account != null)
        {
            if(i == 0)
                System.out.println(account.getAllTransactions());
            else
                System.out.println(account.getLastTenTransactions());
        }
        else
            System.out.println("Account does not exist, please try again");
    }

    public void fetchUserDetails()
    {
        int id = inputAccountNumber();
        Account account = getAccountById(id);
        if(account != null)
        {
            System.out.println(account.getCustomer());
        }
        else
            System.out.println("Account does not exist, please try again");
    }

    /*public void closeBankAccount()
    {
        int id = inputAccountNumber();

    }*/

    public String chooseDenomination(long amount)
    {
        long tempAmount = amount;
        if(amount % currency.lastEntry().getKey() != 0)
            return "Enter balance in the multiple of " + currency.lastKey();
        if(amount > totalAvailableAmount())
            return "Available balance in the bank is less than the requested amount";
        String ans = "";
        TreeMap<Integer, Integer> denominationUsed = new TreeMap<>((a,b)->b - a);
        //while(amount > 0)
        //{
            for(int i : currency.keySet())
            {
                if(currency.get(i) > 0 && amount > 0)
                {
                    if(amount/i <= currency.get(i))
                    {
                        currency.put(i, currency.get(i) - (int)amount/i);
                        denominationUsed.put(i, (int)amount/i);
                        amount -= i*(amount / i);
                    }
                    else
                    {
                        denominationUsed.put(i, currency.get(i));
                        amount -= i*currency.get(i);
                        currency.put(i, 0);
                    }
                }
            }
        //}
        if(amount != 0)
            return "Denomination not available for " + tempAmount;
        int count = 1;
        for(int i : denominationUsed.keySet())
        {
            if(denominationUsed.get(i) > 0)
            {
                ans += i + "*" + denominationUsed.get(i);
                if(count < denominationUsed.size())
                    ans += " + ";
            }
            count++;
        }
        return ans;
    }

    public long totalAvailableAmount()
    {
        long sum = 0;
        for(Map.Entry<Integer, Integer> e: currency.entrySet())
            sum += e.getKey()*e.getValue();
        return sum;
    }

    public void addCurrency(int denomination, int count)
    {
        if(!currency.containsKey(denomination))
            currency.put(denomination,count);
        else
            currency.put(denomination, currency.get(denomination) + count);
    }

    private int inputAccountNumber()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the account number : ");
        return input.nextInt();
    }

    private Account getAccountById(int id)
    {
        return accounts.stream().filter(acc -> acc.getId() == id).findAny().orElse(null);
    }
}