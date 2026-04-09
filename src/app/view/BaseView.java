package app.view;

import java.util.Scanner;

public abstract class BaseView {

    protected final Scanner sc;

    protected BaseView() {
        this.sc = new Scanner(System.in);
    }

    protected void play() {

        boolean running = true;

        while(running){
            meniu();
            int option =Integer.parseInt(sc.nextLine());
            running = getOption(option);
        }
    }

    protected abstract void meniu();
    protected abstract boolean getOption(int option);

}
