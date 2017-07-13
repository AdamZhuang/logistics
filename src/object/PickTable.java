package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/13.
 */
public class PickTable {
    private String pickId;
    private String commodityId;
    private String pickDate;
    private String quantity;
    private String isdone;

    public PickTable(String pickId, String commodityId, String pickDate, String quantity) {
        this.pickId = pickId;
        this.commodityId = commodityId;
        this.pickDate = pickDate;
        this.quantity = quantity;
        this.isdone = "0";
    }

    public PickTable(String pickId, String commodityId, String pickDate, String quantity, String isdone) {
        this.pickId = pickId;
        this.commodityId = commodityId;
        this.pickDate = pickDate;
        this.quantity = quantity;
        this.isdone = isdone;
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        list.add(pickId);
        list.add(commodityId);
        list.add(pickDate);
        list.add(quantity);
        list.add(isdone);
        return list;
    }

    public List<String> getDataWithoutId(){
        List<String> list = new ArrayList<String>();
        list.add(commodityId);
        list.add(pickDate);
        list.add(quantity);
        list.add(isdone);
        return list;
    }
}
