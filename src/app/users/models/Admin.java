package app.users.models;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {

    private boolean managerialLevel;


    public Admin(int id, String email, String password , String fullName, boolean managerialLevel) {
        super(id,email,password,fullName);
        setManagerialLevel(managerialLevel);

    }
    public Admin(String line){
        super(line);
        String[] props = line.split(",");
        setManagerialLevel(Boolean.parseBoolean(props[5]));
        String[] permissions = props[6].split(";");
        for(String p : permissions){
            this.addPermissions(Permissions.valueOf(p));
        }
    }
    public Admin(String email, String password, String fullName, boolean managerialLevel) {
        super(email,password,fullName);
        setManagerialLevel(managerialLevel);
    }

    @Override
    public String toString(){
        return "ADMIN"+","+super.toString()+","+isManagerialLevel();
    }

    public boolean isManagerialLevel() {
        return managerialLevel;
    }
    public void setManagerialLevel(boolean managerialLevel) {
        this.managerialLevel = managerialLevel;
    }

    @Override
    public void play(){

    }

}
