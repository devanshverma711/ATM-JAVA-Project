import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account{
    static Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        data.put(1234567, 1234);
        data.put(7654321, 7654);

        boolean loginSuccess = false;

        System.out.println("Welcome to the ATM Project");

        while (!loginSuccess) {
            try {
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());

                if (data.containsKey(getCustomerNumber()) && data.get(getCustomerNumber()) == getPinNumber()) {
                    loginSuccess = true;
                    getAccountType();
                } else {
                    System.out.println("\nWrong Customer Number or PIN Number.\n");
                }

            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter numbers only.\n");
                menuInput.nextLine(); // Clear the buffer
            }
        }
    }

    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();
        
        switch(selection){
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank You for usinf the ATM, bye.");
            default -> {
                System.out.println("""
                                                                    Invalid Choice
                                                   """);
                getAccountType();
            }
        }
    }

    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Finds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();
         switch(selection){
            case 1 -> {
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this AMT, bye.");
            default -> {
                System.out.println("""
                                                                    Invalid Choice
                                                   """);
                getChecking();
            }
        }
    }
    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Finds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();
         switch(selection){
            case 1 -> {
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using this AMT, bye.");
            default -> {
                System.out.println("""
                                                                    Invalid Choice
                                                   """);
                getChecking();
            }
        }
    }
    int selection ;
}
