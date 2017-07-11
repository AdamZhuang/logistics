package util;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class Data {
    private String type;
    private String info;

    // 构造函数
    public Data(String type, String info) {
        this.type = type;
        this.info = info;
    }

    // get && set
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}