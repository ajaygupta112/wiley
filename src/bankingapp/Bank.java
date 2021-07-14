package bankingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank
{
    private List<Account> accounts;

    Bank()
    {
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
        while(true)
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
        }
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
}
