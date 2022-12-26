package observer;

import java.util.ArrayList;
import java.util.Scanner;

public class BulletinSystem
{
    private final int CHANGE_BULLETIN = 1;
    private final int VIEW_BULLETIN = 2;
    private final int CREATE_ACCOUNT = 3;
    private final int DELETE_ACCOUNT = 4;
    private final int SUBSCRIBE = 5;
    private final int UNSUBSCRIBE = 6;
    private final int PRINT_ACCOUNTS = 7;
    private final int EXIT = 8;
    private Scanner _sc;
    private GroupAdmin _bulletin;
    private ArrayList<ConcreteMember> _people;

    private ConcreteMember _current;

    BulletinSystem()
    {
        this._sc = new Scanner(System.in);
        this._bulletin = new GroupAdmin();
        this._people = new ArrayList<ConcreteMember>();
        this._current = new ConcreteMember();
        this._bulletin.register(this._current);
    }

    public void start()
    {
        // TODO: big while with switch case
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
                    // TODO
                    break;
                case DELETE_ACCOUNT:
                    // TODO
                    break;
                case SUBSCRIBE:
                    // TODO
                    break;
                case UNSUBSCRIBE:
                    // TODO
                    break;
                case PRINT_ACCOUNTS:
                    // TODO
                    break;
                case EXIT:
                    System.out.println("Bye bye :)");
                    break;
            }

        }while(choice != EXIT);
    }

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


    private void changeBulletinHandler()
    {
        int choice = printChangeOptions();

        switch (choice)
        {
            case 1:
                // TODO: insert
                break;
            case 2:
                System.out.print("Enter string to append: ");
                this._bulletin.append(this._sc.nextLine());
                break;
            case 3:
                // TODO: Delete
                break;
            case 4:
                this._bulletin.undo();
                break;
            default:
                break;
        }
    }

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

    private void viewBulletin()
    {
        System.out.println("Current state: " + this._current.get_usb());
    }
}
