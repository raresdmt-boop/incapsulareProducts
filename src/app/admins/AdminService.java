package app.admins;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    private final File adminFile;
    private final ArrayList<Admin> admins;

    public AdminService() {
        admins = new ArrayList<>();
        adminFile = new File("C:\\mycode\\incapsulare\\teorie\\ProductsApp\\src\\app\\admins\\admins.txt");
        loadAdmin();
        saveAdmin();
    }

    public Admin getAdmin(String email) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email)) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(;i<admins.size()-1;i++){
            sb.append(admins.get(i).toString()+"\n");
        }
        sb.append(admins.get(i));
        return sb.toString();
    }

    private void loadAdmin(){
        try{
            Scanner sc = new Scanner(adminFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                try{
                    admins.add(new Admin(line));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
        }catch(Exception e){
            System.out.println("Error in loading admin file");
        }
    }
    private void saveAdmin(){
        try {
            FileWriter writer = new FileWriter(adminFile);
            PrintWriter pw = new PrintWriter(writer);
            pw.write(this.toString());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
