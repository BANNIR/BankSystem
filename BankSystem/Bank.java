/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;

/**
 *
 * @author Shahe
 */
public class Bank {
    private static ArrayList<AutomatedTellerMachine> atms = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    
    public static void addUser(String userName, String password){
        users.add(new User(userName, password));
    }
    public static ArrayList<User> getUsers(){
        return users;
    }
    
}
