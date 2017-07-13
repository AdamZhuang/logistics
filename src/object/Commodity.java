package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class Commodity {
    private String id;
    private String name;
    private String company;

    public Commodity(String id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        list.add(id);
        list.add(name);
        list.add(company);
        return list;
    }
}
