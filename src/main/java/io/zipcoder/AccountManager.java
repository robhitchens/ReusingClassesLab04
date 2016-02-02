package io.zipcoder;

/**
 * Created by roberthitchens3 on 2/2/16.
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountManager {
    private HashMap<Integer, Account> accounts;
    private Account account;
    private String option = "d to deposite \nw to make a withdrawal\n cb to check balance\n del to delete an account";
    public AccountManager(){
        accounts = new HashMap<Integer, Account>();
        run();
    }
    public void run(){
        String in = userInput("Please enter your pin: ", "");
        String enPin;
        while(!in.equals("q")){
            enPin = in;
            if(accounts.containsKey(Integer.parseInt(enPin, 10))){
                in = userInput(option, "");
                account = accounts.get(enPin);
                switch(in){
                    case "d":
                        makeDeposit(Double.parseDouble(userInput("enter amount to deposit: ","number")));
                        account = null;
                        break;
                    case "w":
                        makeWithdrawal(Double.parseDouble(userInput("enter amount to withdraw: ", "number")));
                        account = null; // do I need to do this?
                        break;
                    case "cb":
                        checkBalance();
                        break;
                    case "del":
                        deleteAccount(Integer.parseInt(enPin));//maybe refactor.
                        break;
                    default:
                        System.out.println("not an option.");
                }

            }else{
                System.out.println("pin entered is incorrect or account does not exist.");
                in = userInput("would you like to create an account?(y/n) : ", "");
                if(in.equals("y")){
                    createAccount(Integer.parseInt(userInput("enter pin: ", "number"), 10), Double.parseDouble(userInput("enter balance: ", "number")), userInput("what type of account would you like to create?: ", ""));
                }else{
                    System.out.println("alright.");
                }

            }
            in = userInput("type q to quit or enter pin: ", "");

        }

    }
    public String makeDeposit(double amount){
        account.changeBalance(amount, true);
        return "amount deposited in "+account.getType();
    }
    public String makeWithdrawal(double amount){
        boolean success = account.changeBalance(amount, false);
        String result;
        if(success){
            result = "okay";
        }else{
            result = "failed. amount exceeds balance.";
        }
        return result;
    }
    public void checkBalance(){//do i need????
        System.out.println("Balance is: "+account.getBalance());
    }
    public void createAccount(int pin, double balance, String type){
        if(type.equals("business")){
            account = new BusinessAccount(pin, balance);
            accounts.put(pin, account);
            account = null;
        }else if(type.equals("checking")){
            account = new CheckingAccount(pin, balance);
            accounts.put(pin, account);
            account = null;
        }else if(type.equals("savings")){
            account = new SavingsAccount(pin, balance);
            accounts.put(pin, account);
            account = null;
        }else{
            account = null;//is this necessary?
            System.out.println("erroir");
        }
    }
    public Account deleteAccount(int pin){// make account null after calling. maybe?
        account = accounts.remove(pin);
        return account;
    }
    public String userInput(String message, String type){//refactor and add filter
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String input = scanner.nextLine();

        if(type.equals("number")){
            String pattern = "(.*)\\d+(\\.\\d{1,2}?)?(.*)";//should find number with decimal value or number without decimal value.
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(input);
            boolean okay =false;
            while(!okay){
                if(m.find()){
                    okay = true;
                    return input;

                }else{
                    System.out.println("entered value is invalid enter new Value: ");
                    input = scanner.next();
                    m = p.matcher(input);
                }
            }

        }

        return input;
    }
}
