package user;

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
}
