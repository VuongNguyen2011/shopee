/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nguyen
 */
public class Users {
    private int userID;
    private int nhanvienID;
    private String fullName;
    private String user;
    private String pass;
    private int lever;

    public int getNhanvienID() {
        return nhanvienID;
    }

    public void setNhanvienID(int nhanvienID) {
        this.nhanvienID = nhanvienID;
    }

    public Users(int userID, int nhanvienID, String fullName, String user, String pass, int lever) {
        this.userID = userID;
        this.nhanvienID = nhanvienID;
        this.fullName = fullName;
        this.user = user;
        this.pass = pass;
        this.lever = lever;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
    }

    public Users() {
    }

    public Users(int userID, String fullName, String user, String pass, int lever) {
        this.userID = userID;
        this.fullName = fullName;
        this.user = user;
        this.pass = pass;
        this.lever = lever;
    }
}
