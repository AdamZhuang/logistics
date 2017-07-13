package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/13.
 */
public class Repository {
    private String commodityId;
    private String commodityName;
    private String commodityQuantity;


    public Repository(String commodityId, String commodityName, String commodityQuantity) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityQuantity = commodityQuantity;
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        list.add(commodityId);
        list.add(commodityName);
        list.add(commodityQuantity);
        return list;
    }
}
