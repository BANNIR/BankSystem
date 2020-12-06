/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author Shahe
 */
public class AutomatedTellerMachine {
    private String atmID;
    private static int nextID = 1;
    
    public AutomatedTellerMachine(){
        this.atmID = String.format("%06d", nextID++);
    }

    public AutomatedTellerMachine(String atmID) {
        this.atmID = atmID;
    }
    public AutomatedTellerMachine(AutomatedTellerMachine automatedTellerMachine) {
        this.atmID = automatedTellerMachine.atmID;
    }
    public boolean equals(AutomatedTellerMachine automatedTellerMachine){
        return this.atmID.equals(automatedTellerMachine.atmID);
    }
    public void printWelcome(){
            System.out.println("Welcome to use our ATM");
    }
    public User readUserId(){
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please enter your user ID");
        String inputId = console.next();
        
        for (int i = 0; i < Bank.getUsers().size(); i++)
            if (inputId.equals(Bank.getUsers().get(i).getUserName()))
                return Bank.getUsers().get(i);
        return null;
    }
    public boolean inputPin(User user){
        Scanner console = new Scanner(System.in);
        int maxTry = 3;
        
        for (int i = 0; i < maxTry; i++){
            System.out.println("Enter your pin");
        String password = console.next();
        if (user.getPassword().equals(password))
            return true;
        System.out.println("Pin is wrong");
    }
    System.out.println("Wrong pin for 3 tries");
    return false;
    }
    public Account chooseAccount(User user){
        Scanner console = new Scanner(System.in);
        System.out.println("Please choose the account you want to operate with" + "\n\t1, Checking account" + "\n\t2, Saving account");
        int accountChoice = console.nextInt();
        return accountChoice == 1? user.getCheckingAccount() : user.getSavingAccount();
    }
    public int chooseOperation(){
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please choose the operation" + "\n\t1, Withdraw" + "\n\t2, Deposit" + "\n\t3, Display balance");
        int operation = console.nextInt();
        
        return operation;
    }
    public boolean withdraw(Account account){
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to withdraw");
        double amount = console.nextDouble();
        if (account.getBalance() < amount){
            System.out.println("Sorry you don't have enoug balance");
            return false;
        }
        account.setBalance(account.getBalance()- amount);
        System.out.println("Withdraw successful");
        return true;
        }
    public boolean deposit(Account account){
        Scanner console = new Scanner(System.in);
        System.out.println("How much deposit");
        Double amount = console.nextDouble();
        account.setBalance(account.getBalance()+ amount);
        System.out.println("Deposit successful");
        return true;
    }
    public void displayBalance(Account account){
        
    }
    @Override
    public String toString() {
        return String.format("%-10s: %s", "ATM ID", atmID);
    }

    public String getAtmID() {
        return atmID;
    }

    public void setAtmID(String atmID) {
        this.atmID = atmID;
    }

    public static int getNextID() {
        return nextID;
    }

    public static void setNextID(int nextID) {
        AutomatedTellerMachine.nextID = nextID;
    }
}

    

