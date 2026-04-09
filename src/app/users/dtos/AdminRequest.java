package app.users.dtos;

public class AdminRequest extends UserRequest{

    private boolean managerialLevel;

    public AdminRequest(String email, String password, String fullName, boolean managerialLevel){
        super(email,password,fullName);
        setManagerialLevel(managerialLevel);
    }
    public AdminRequest(String line){
        super(line);
        String[] props = line.split(",");
        setManagerialLevel(Boolean.parseBoolean(props[5]));
    }

    @Override
    public String toString(){
        return "ADMIN"+","+super.toString()+","+isManagerialLevel();
    }

    public boolean getManagerialLevel() {
        return managerialLevel;
    }

    public boolean isManagerialLevel() {
        return managerialLevel;
    }
    public void setManagerialLevel(boolean managerialLevel) {
        this.managerialLevel = managerialLevel;
    }

}
