package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class Purchaser {
    private String id;
    private String password;
    private String name;
    private String sex;
    private String tel;

    public Purchaser(String id, String password, String name, String sex, String tel) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        list.add(id);
        list.add(password);
        list.add(name);
        list.add(sex);
        list.add(tel);
        return list;
    }
}
