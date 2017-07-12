package user;

/**
 * Created by Alan on 2017/7/11.
 */
public class Manager {
    private String name;
    private String password;
    private int manager_id;
    private String manager_name;
    private String manager_sex;
    private int manager_tel;
    private int repository_id;

    public Manager(String name, String password, int manager_id, String manager_name, String manager_sex, int manager_tel, int repository_id) {
        this.name = name;
        this.password = password;
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.manager_sex = manager_sex;
        this.manager_tel = manager_tel;
        this.repository_id = repository_id;
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

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_sex() {
        return manager_sex;
    }

    public void setManager_sex(String manager_sex) {
        this.manager_sex = manager_sex;
    }

    public int getManager_tel() {
        return manager_tel;
    }

    public void setManager_tel(int manager_tel) {
        this.manager_tel = manager_tel;
    }

    public int getRepository_id() {
        return repository_id;
    }

    public void setRepository_id(int repository_id) {
        this.repository_id = repository_id;
    }
}
