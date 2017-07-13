package object;

/**
 * Created by Alan on 2017/7/11.
 */
public class Manager {
   private String username = "admin";
   private String password;

    public Manager(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
