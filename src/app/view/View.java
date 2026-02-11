package app.view;

import app.users.Admin;
import app.users.User;
import app.users.UserService;

import java.util.Scanner;

public class View {

    protected String meniu;
    protected User user;
    protected Scanner sc;

    public View(){
        sc = new Scanner(System.in);
    }
    public View(User user,String meniu) {
        this.meniu = meniu;
        sc = new Scanner(System.in);
    }

    public void  play(){

    }



}
