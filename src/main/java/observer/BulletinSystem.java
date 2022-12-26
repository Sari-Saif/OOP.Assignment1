package observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BulletinSystem
{
    // Main Menu options
    private final int CHANGE_BULLETIN = 1;
    private final int VIEW_BULLETIN = 2;
    private final int CREATE_ACCOUNT = 3;
    private final int DELETE_ACCOUNT = 4;
    private final int SUBSCRIBE = 5;
    private final int UNSUBSCRIBE = 6;
    private final int PRINT_ACCOUNTS = 7;
    private final int EXIT = 8;

    // Change bulletin options
    private final int INSERT = 1;
    private final int APPEND = 2;
    private final int DELETE = 3;
    private final int UNDO = 4;

    private Scanner _sc;
    private GroupAdmin _bulletin;
    private ArrayList<Account> _Accounts;
    private Set<String> _accountNames;

    private ConcreteMember _current;

    /**
     * C'TOR
     */
    BulletinSystem()
    {
        this._sc = new Scanner(System.in);
        this._bulletin = new GroupAdmin();
        this._Accounts = new ArrayList<Account>();
        this._accountNames = new HashSet<String>();
        this._current = new ConcreteMember();
        this._bulletin.register(this._current);
    }

    /**
     * This is the main loop of the sysrem.
     * It starts with the main menu inside loop
     * until the user type Exit.
     */
    public void start()
    {
        int choice = 0;

        do
        {
            choice = printMainMenu();

            switch (choice)
            {
                case CHANGE_BULLETIN:
                    changeBulletinHandler();
                    break;
                case VIEW_BULLETIN:
                    viewBulletin();
                    break;
                case CREATE_ACCOUNT:
                    createAccountHandler();
                    break;
                case DELETE_ACCOUNT:
                    deleteAccountHandler();
                    break;
                case SUBSCRIBE:
                    subscribeHandler();
                    break;
                case UNSUBSCRIBE:
                    unsubscribeHandler();
                    break;
                case PRINT_ACCOUNTS:
                    printAllAccounts();
                    break;
                case EXIT:
                    System.out.println("Bye bye :)");
                    break;
            }

        }while(choice != EXIT);
    }

    /**
     * prints the main menu and ask
     * user to choose an option
     * @return a valid integer choice
     */
    private int printMainMenu()
    {
        int choice = 0;

        do
        {
            System.out.println("1. Change Bulletin");
            System.out.println("2. View Bulletin");
            System.out.println("3. Create Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Register the account");
            System.out.println("6. Unregister the account");
            System.out.println("7. Print all accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = this._sc.nextInt();
            this._sc.nextLine();

            if (choice < 1 || choice > 8)
            {
                System.out.println("Invalid choice...");
            }
        }while(choice < 1 || choice > 8);

        return choice;
    }

    /**
     * func handler the changing of bulletin.
     * there is 4 types of change: insert, append, delete & undo.
     * So, user choose an option, and then the right action running.
     */
    private void changeBulletinHandler()
    {
        int choice = printChangeOptions();

        switch (choice)
        {
            case INSERT:
                System.out.print("Enter offset of insertion: ");
                int offset = this._sc.nextInt();
                this._sc.nextLine(); // clean the buffer
                System.out.print("Enter string to insertion: ");
                this._bulletin.insert(offset, this._sc.nextLine());
                break;
            case APPEND:
                System.out.print("Enter string to append: ");
                this._bulletin.append(this._sc.nextLine());
                break;
            case DELETE:
                System.out.print("Enter Start index to delete from: ");
                int start = this._sc.nextInt();
                this._sc.nextLine(); // clean the buffer
                System.out.print("Enter End index: ");
                int end = this._sc.nextInt();
                this._sc.nextLine(); // clean the buffer
                this._bulletin.delete(start, end);
                break;
            case UNDO:
                this._bulletin.undo();
                break;
            default:
                break;
        }
    }

    /**
     * function represent the 4 options of
     * changing buletin, and ask user to
     * choose one of them.
     * @return option type integer
     */
    private int printChangeOptions()
    {
        int choice = 0;
        System.out.println("1. Insert");
        System.out.println("2. Appned");
        System.out.println("3. Delete");
        System.out.println("4. Undo");
        System.out.println("Other number for cancel..");
        System.out.print("Enter your choice: ");

        choice = this._sc.nextInt();
        this._sc.nextLine();

        return choice;
    }

    /**
     * function prints the bulletin string.
     */
    private void viewBulletin()
    {
        System.out.println("Current state: " + this._current.get_usb());
    }

    /**
     * function create new account,
     * and append it to list of accounts.
     * User asked to type new name, until
     * it's new name.
     */
    private void createAccountHandler()
    {
        String name;
        boolean tryAgain = false;

        do
        {
            tryAgain = false;
            System.out.print("Enter new account name: ");
            name = this._sc.nextLine();

            if(this._accountNames.contains(name))
            {
                System.out.println("Account name is exist.. try again!");
                tryAgain = true;
            }
        }
        while(tryAgain);

        this._accountNames.add(name);
        this._Accounts.add(new Account(name));

        System.out.println("Your account was created");
    }

    /**
     * function ask user to choose an older account,
     * and then it unregister the account and then remove it
     * from the list that hold it before.
     */
    private void deleteAccountHandler()
    {
        int choice = 0;
        int numOfAccounts = this._Accounts.size();

        if(numOfAccounts == 0)
        {
            System.out.println("No accounts to delete...");
            return;
        }

        printAllAccounts();
        do
        {
            System.out.print("Enter Account number to delete: ");
            choice = this._sc.nextInt();
            this._sc.nextLine();

            if(choice < 0 || choice > numOfAccounts)
            {
                System.out.println("Invalid account... try again!");
            }
        }while (choice < 0 || choice > numOfAccounts);


        Account accountToDelete = this._Accounts.get(choice-1);
        this._bulletin.unregister(accountToDelete);
        this._Accounts.remove(accountToDelete);
    }

    /**
     * function handler the subscribe operation
     * of account to the bulletin.
     * User asked to choose a number of account
     * and when the number is legal, the
     * right account will register.
     */
    private void subscribeHandler()
    {
        int choice = 0;
        int numOfAccounts = this._Accounts.size();

        if(numOfAccounts == 0)
        {
            System.out.println("No accounts to subscibe...");
            return;
        }

        printAllAccounts();
        do
        {
            System.out.print("Enter Account number to subscribe: ");
            choice = this._sc.nextInt();
            this._sc.nextLine();

            if(choice < 0 || choice > numOfAccounts)
            {
                System.out.println("Invalid account... try again!");
            }
        }while (choice < 0 || choice > numOfAccounts);

        this._bulletin.register(this._Accounts.get(choice-1));
    }

    /**
     * function handler the unsubscribe operation
     * of account to the bulletin.
     * User asked to choose a number of account
     * and when the number is legal, the
     * right account will unregister.
     */
    private void unsubscribeHandler()
    {
        int choice = 0;
        int numOfAccounts = this._Accounts.size();

        if(numOfAccounts == 0)
        {
            System.out.println("No accounts to unsubscibe...");
            return;
        }

        printAllAccounts();
        do
        {
            System.out.print("Enter Account number to unsubscribe: ");
            choice = this._sc.nextInt();
            this._sc.nextLine();

            if(choice < 0 || choice > numOfAccounts)
            {
                System.out.println("Invalid account... try again!");
            }
        }while (choice < 0 || choice > numOfAccounts);

        this._bulletin.unregister(this._Accounts.get(choice-1));
    }


    private void printAllAccounts()
    {
        int numOfAccounts = this._Accounts.size();
        for(int i = 0; i < numOfAccounts; i++)
        {
            Account curr = this._Accounts.get(i);
            System.out.println((i+1) + ". " + curr.get_name() + ": " + curr.get_usb());
        }
    }
}
