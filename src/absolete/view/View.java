package absolete.view;

import absolete.User;

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
