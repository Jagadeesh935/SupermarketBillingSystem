package com.jk;

public class Admin {
    private static int idTracker = 1;
    private int adminId;
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.adminId = idTracker++;
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Admin Login Successful");
            return true;
        }

        System.out.println("Username and password Invalid");
        return false;
    }


    public String getUsername() {
        return username;
    }


}
