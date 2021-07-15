package bankingapp;

import java.util.Scanner;

public class DriverClass
{
    public static void main(String[] args)
    {
        DriverClass driver = new DriverClass();
        Bank bank = new Bank();
        //driver.userGeneratedValues(bank);
        driver.systemGeneratedData(bank);
    }

    public void systemGeneratedData(Bank bank)
    {
        /*bank.getAllAccounts().add(new Account("abc","ghaziabad",123456789));
        bank.getAllAccounts().add(new Account("xyz","pune",234567891));
        bank.getAllAccounts().add(new Account("gef","pune",345678912));
        bank.getAllAccounts().add(new Account("pqr","mumbai",456789123));
        bank.getAllAccounts().add(new Account("abc","ghaziabad",567891234));

        bank.getAllAccounts().get(0).depositMoney(10000);
        bank.getAllAccounts().get(0).depositMoney(10000);
        bank.getAllAccounts().get(0).withdrawMoney(2303);

        bank.getAllAccounts().get(1).depositMoney(10000);
        bank.getAllAccounts().get(1).depositMoney(10000);
        bank.getAllAccounts().get(1).withdrawMoney(2303);

        bank.getAllAccounts().get(2).depositMoney(10000);
        bank.getAllAccounts().get(3).depositMoney(10000);
        bank.getAllAccounts().get(4).depositMoney(10000);

        bank.getAllAccounts().get(2).withdrawMoney(1000);
        bank.getAllAccounts().get(3).withdrawMoney(2000);
        bank.getAllAccounts().get(4).withdrawMoney(3000);

        bank.getAllAccounts().stream().filter(acc->acc.getBalance()>0).forEach(o->System.out.println(o +"\n"+ o.getAllTransactions() + "\n"));
        bank.getAllAccounts().stream().filter(acc->acc.getBalance()>10000).forEach(System.out::println);*/

        String ans = bank.chooseDenomination(210);
        System.out.println(ans);
        System.out.println(bank.chooseDenomination(360));
        System.out.println(bank.chooseDenomination(200));
        System.out.println(bank.chooseDenomination(440));
        System.out.println(bank.totalAvailableAmount());
        System.out.println(bank.chooseDenomination(130));
        System.out.println(bank.chooseDenomination(100));
        System.out.println(bank.totalAvailableAmount());
        System.out.println(bank.totalAvailableAmount());
        System.out.println(bank.chooseDenomination(80));
        System.out.println(bank.chooseDenomination(200));

    }

    public void userGeneratedValues(Bank bank)
    {
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
            input.close();
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
                //case 8: bank.closeBankAccount();
                //      break;
                case 9: System.exit(0);
                default: System.out.println("Wrong input, please try again");
            }
        }
    }
}
