package bankingapp;

import java.util.*;
import java.util.stream.Collectors;

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

    public static void main(String[] args)
    {
    /*    accounts.add(new Account("abc","ghaziabad",123456789));
        accounts.add(new Account("xyz","pune",234567891));
        accounts.add(new Account("gef","pune",345678912));
        accounts.add(new Account("pqr","mumbai",456789123));
        accounts.add(new Account("abc","ghaziabad",567891234));

        accounts.get(0).depositMoney(10000);
        accounts.get(0).depositMoney(10000);
        accounts.get(0).withdrawMoney(2303);

        accounts.get(1).depositMoney(10000);
        accounts.get(1).depositMoney(10000);
        accounts.get(1).withdrawMoney(2303);

        accounts.get(2).depositMoney(10000);
        accounts.get(3).depositMoney(10000);
        accounts.get(4).depositMoney(10000);

        accounts.get(2).withdrawMoney(1000);
        accounts.get(3).withdrawMoney(2000);
        accounts.get(4).withdrawMoney(3000);

        //accounts.stream().filter(acc->acc.getBalance()>0).forEach(o->System.out.println(o +"\n"+ o.getAllTransactions() + "\n"));
        accounts.stream().filter(acc->acc.getBalance()>10000).forEach(System.out::println);

*/
        Bank bank = new Bank();
        String ans = bank.chooseDenomination(210);
        System.out.println(ans);
        System.out.println(bank.chooseDenomination(360));
        System.out.println(bank.chooseDenomination(200));
        System.out.println(bank.chooseDenomination(440));
        System.out.println(bank.totalAvailableAmount());
        System.out.println(bank.chooseDenomination(130));
        System.out.println(bank.chooseDenomination(100));
        System.out.println(bank.totalAvailableAmount());
        System.out.println(bank.chooseDenomination(160));
        /*while(true)
        {
            System.out.println("Choose the option");
            System.out.println("1. Create a Bank Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Fetch Account Balance");
            System.out.println("5. Print Mini-statement");
            System.out.println("6. Print all transaction history");
            System.out.println("7. Print User details");
            System.out.println("8. Close the Bank Account");
            System.out.println("9. Exit the system");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            switch(x)
            {
                case 1: bank.addCustomer();
                    break;
                case 2: bank.depositMoney();
                        break;
                case 3: bank.withdrawMoney();
                        break;
                case 4: bank.fetchAccountBalance();
                        break;
                case 5: bank.printStatement(10);
                        break;
                case 6: bank.printStatement(0);
                        break;
                case 7: bank.fetchUserDetails();
                        break;
                case 8: bank.closeBankAccount();
                        break;
                case 9: System.exit(1);
            }
        }*/
    }

    public void addCustomer()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Customer Name : ");
        System.out.println("Enter Customer Address : ");
        System.out.println("Enter Customer Contact Number : ");
    }

    public void depositMoney()
    {

    }

    public void withdrawMoney()
    {

    }

    public void fetchAccountBalance()
    {

    }

    public void printStatement(int i)
    {

    }

    public void fetchUserDetails()
    {

    }

    public void closeBankAccount()
    {

    }

    private void addCurrency(int denomination, int count)
    {
        if(!currency.containsKey(denomination))
            currency.put(denomination,count);
        else
            currency.put(denomination, currency.get(denomination) + count);
    }

    private int totalAvailableAmount()
    {
        int sum = 0;
        for(Map.Entry<Integer, Integer> e: currency.entrySet())
            sum += e.getKey()*e.getValue();
        return sum;
    }

    private String chooseDenomination(int amount)
    {
        int temp = amount;
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
                //System.out.println("Here");
                if(currency.get(i) > 0 && amount > 0)
                {
                    if(amount/i <= currency.get(i))
                    {
                        currency.put(i, currency.get(i) - amount/i);
                        denominationUsed.put(i, amount/i);
                        //System.out.println(i + " "  + amount/i);
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
            return "Denomination not available for " + temp;
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
}