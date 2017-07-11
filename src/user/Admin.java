package user;

import util.FileFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class Admin {
    private String name = "admin";
    private String password;

    public Admin(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public static void main(String[] args){
//        Admin admin = new Admin("admin");
//        FileFactory fileFactory = FileFactory.getInstance();
//        List<String> list = new ArrayList<>();
//        list.add("admin");
//        fileFactory.writeFile("./data/adminPassword.txt",list);
//        List<String> s = fileFactory.readFile("./data/adminPassword.txt");
//        System.out.println(s.get(0));
//    }
}
