package bankingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank
{
    public static List<Account> accounts = new ArrayList<>();
    public static void main(String[] args)
    {

        accounts.add(new Account("abc","ghaziabad",123456789));
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
                case 1: addCustomer();
                    break;
                case 2: depositMoney();
                        break;
                case 3: withdrawMoney();
                        break;
                case 4: fetchAccountBalance();
                        break;
                case 5: printStatement(0);
                        break;
                case 6: printStatement(1);
                        break;
                case 7: fetchUserDetails();
                        break;
                case 8: closeBankAccount();
                        break;
                case 9: System.exit(1);
            }
        }
    }

    public static void addCustomer()
    {

    }

    public static void depositMoney()
    {

    }

    public static void withdrawMoney()
    {

    }

    public static void fetchAccountBalance()
    {

    }

    public static void printStatement(int i)
    {

    }

    public static void fetchUserDetails()
    {

    }

    public static  void closeBankAccount()
    {

    }
}
