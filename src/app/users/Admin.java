package app.users;

public class Admin extends User{

    private boolean managerialLevel;

    public Admin(int id, String email, String password, String fullName, boolean managerialLevel){
        super(id,email,password,fullName);
        setManagerialLevel(managerialLevel);
    }
    public Admin(String line){
        super(line);
        String[] props = line.split(",");
        setManagerialLevel(Boolean.parseBoolean(props[5]));
    }

    @Override
    public String toString(){
        return super.toString()+","+isManagerialLevel()+",";
    }

    public boolean isManagerialLevel() {
        return managerialLevel;
    }
    public void setManagerialLevel(boolean managerialLevel) {
        this.managerialLevel = managerialLevel;
    }

}
