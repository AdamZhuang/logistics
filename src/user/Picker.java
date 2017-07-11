package user;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class Picker {
    private String name = "picker";
    private String password;
    private int picker_id;
    private String picker_name;
    private int picker_tel;
    private String picker_sex;

    public Picker(String name, String password, int picker_id, String picker_name, int picker_tel, String picker_sex) {
        this.name = name;
        this.password = password;
        this.picker_id = picker_id;
        this.picker_name = picker_name;
        this.picker_tel = picker_tel;
        this.picker_sex = picker_sex;
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

    public int getPicker_id() {
        return picker_id;
    }

    public void setPicker_id(int picker_id) {
        this.picker_id = picker_id;
    }

    public String getPicker_name() {
        return picker_name;
    }

    public void setPicker_name(String picker_name) {
        this.picker_name = picker_name;
    }

    public int getPicker_tel() {
        return picker_tel;
    }

    public void setPicker_tel(int picker_tel) {
        this.picker_tel = picker_tel;
    }

    public String getPicker_sex() {
        return picker_sex;
    }

    public void setPicker_sex(String picker_sex) {
        this.picker_sex = picker_sex;
    }
}
