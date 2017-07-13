package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/13.
 */
public class PurchaseTable {
    private String purchaserId;
    private String commodityId;
    private String purchaseDate;
    private String quantity;
    private String isdone;

    public PurchaseTable(String purchaserId, String commodityId, String purchaseDate, String quantity, String isdone) {
        this.purchaserId = purchaserId;
        this.commodityId = commodityId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.isdone = isdone;
    }

    public PurchaseTable(String purchaserId, String commodityId, String purchaseDate, String quantity) {
        this.purchaserId = purchaserId;
        this.commodityId = commodityId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.isdone = "0";
    }

    public List<String> getData(){
        List<String> list = new ArrayList<String>();
        list.add(purchaserId);
        list.add(commodityId);
        list.add(purchaseDate);
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
