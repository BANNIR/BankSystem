/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Shahe
 */
public class User {
    private String userID;
    private String userName;
    private String pin;
    private Account checkingAccount;
    private Account savingAccount;
    private String password;
    private ArrayList<Record> history;
    private static int nextId = 1;
    public User() {
        this.userID = null;
        this.userName = null;
        this.pin = null;
        this.password = null;
        this.checkingAccount = null;
        this.savingAccount = null;
        this.history = null;
    }

    public User(String userName, String password) {
        this.userID = String.format("%06d", nextId++);
        this.userName = userName;
        this.password = password;
        this.checkingAccount = new Account();
        this.savingAccount = null;
        this.history = new ArrayList<>();
    }
    public User(User user){
        this.userID = user.userID;
        this.userName = user.userName;
        this.pin = user.pin;
        this.password = user.password;
        this.checkingAccount = new Account(savingAccount);
        this.savingAccount = new Account(checkingAccount);
        this.history = new ArrayList<>(history);
    }
    
    public boolean equals(User user) {
        return this.userID.equals(user.userID)&&this.userName.equals(user.userName)&&this.password.equals(user.password)
                && this.savingAccount.equals(user.savingAccount) && this.checkingAccount.equals(user.checkingAccount) &&
                this.history.equals(user.history);
    }
    @Override
    public String toString(){
        String str = "";
        
        str += String.format("%-20s:%s\n", "User ID", userID);
        str += String.format("%-20s:%s\n", "User Name", userName);
        str += String.format("%-20s:%s\n", "Saving account", savingAccount);
        str += String.format("%-20s:%s\n", "Checking account", checkingAccount);
        str += String.format("%-20s:%s\n", "History", history);
        return str;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Account getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(Account checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Account getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(Account savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Record> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Record> history) {
        this.history = history;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }
    
    
}
