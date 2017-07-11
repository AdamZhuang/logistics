package user;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class Purchaser {
    private String name = "purchaser";
    private String password;
    private int purchaser_id;
    private String purchaser_name;
    private int purchaser_tel;
    private String purchaser_sex;

    public Purchaser(String name, String password, int purchaser_id, String purchaser_name, int purchaser_tel, String purchaser_sex) {
        this.name = name;
        this.password = password;
        this.purchaser_id = purchaser_id;
        this.purchaser_name = purchaser_name;
        this.purchaser_tel = purchaser_tel;
        this.purchaser_sex = purchaser_sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPurchaser_id() {
        return purchaser_id;
    }

    public void setPurchaser_id(int purchaser_id) {
        this.purchaser_id = purchaser_id;
    }

    public String getPurchaser_name() {
        return purchaser_name;
    }

    public void setPurchaser_name(String purchaser_name) {
        this.purchaser_name = purchaser_name;
    }

    public int getPurchaser_tel() {
        return purchaser_tel;
    }

    public void setPurchaser_tel(int purchaser_tel) {
        this.purchaser_tel = purchaser_tel;
    }

    public String getPurchaser_sex() {
        return purchaser_sex;
    }

    public void setPurchaser_sex(String purchaser_sex) {
        this.purchaser_sex = purchaser_sex;
    }
}
