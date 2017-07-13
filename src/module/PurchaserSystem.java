package module;

import object.*;
import util.Data;
import util.JDBC;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/12.
 */
public class PurchaserSystem {
    public static void pickPlanConfirm(JFrame jFrame, JTable jTable,String purchaserId){
        // 获取表格
        List<String[]> list = getTableData(jTable);
        // 判断是否有无效数据
        if (!isValidData(list)) {
            return;
        }
        // 加上ID
        List<String[]> newList = getDataWithId(purchaserId, list);
        // 删除数据库数据
        JDBC.getInstance().excuteUpdate("delete from purchase",null);
        // 重新写入数据库
        writeToDB(newList);
        // 成功提示
        JOptionPane.showMessageDialog(null, "成功修改内容", "提示",JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isValidData(List<String[]> list) {
        for (int i = 0; i < list.size(); i++) {
            String[] tmp = list.get(i);
            if(tmp[0] == "" || tmp[0] == null){
                JOptionPane.showMessageDialog(null,"输入无效数据，请检查");
                return false;
            }
            if (tmp[tmp.length-1].equals("0")||tmp[tmp.length-1].equals("1")){
                //数据ok
            }else{
                JOptionPane.showMessageDialog(null,"输入无效数据，请检查");
                return false;
            }
        }
        return true;
    }

    private static int writeToDB(List<String[]> newList) {
        String sql = "INSERT INTO `logistics`.`purchase` (`commodity_id`, `purchaser_id`, `purchase_date`, `purchase_quantity`, `purchase_isdone`) VALUES (?,?,?,?,?);";
        for (int i = 0; i < newList.size(); i++) {
            List<Data> data = new ArrayList<Data>();
            data.add(new Data("Integer",newList.get(i)[0]));
            data.add(new Data("Integer",newList.get(i)[1]));
            data.add(new Data("String",newList.get(i)[2]));
            data.add(new Data("Integer",newList.get(i)[3]));
            data.add(new Data("Integer",newList.get(i)[4]));
            if(JDBC.getInstance().excuteUpdate(sql,data) == -1){
                return -1;
            }
        }
        return 0;
    }

    private static List<String[]> getDataWithId(String purchaserId, List<String[]> list) {
        List<String[]> newList = new ArrayList<String[]>();
        for (int i = 0; i < list.size(); i++) {
            String[] tmp = list.get(i);
            String[] newData = new String[tmp.length+1];
            newData[0] = purchaserId;
            for (int j = 1; j < newData.length; j++) {
                newData[j] = tmp[j-1];
            }
            newList.add(newData);
        }
        return newList;
    }

    public static List<String[]> getTableData(JTable table) {
        List<String[]> data = new ArrayList<String[]>();

        for (int i = 0; i < table.getRowCount(); i++) {
            int count = 0;
            for (int j = 0; j < table.getColumnCount(); j++) {
                if(table.getValueAt(i,j)==null || table.getValueAt(i,j).equals("")){
                    count++;
                }
            }
            // 全为Null
            if(count==table.getColumnCount()){
                continue;
            }
            // 添加数据
            String[] tmp = new String[table.getColumnCount()];
            for (int j = 0; j < table.getColumnCount(); j++) {
                tmp[j] = (String)table.getValueAt(i,j);
            }
            data.add(tmp);
        }
        return data;
    }

    public static void showData(JFrame jFrame, JTable table, String purchaserId){
        ResultSet rs = queryPickPlan(purchaserId);
        List<PurchaserTable> data = getResultSetList(rs);
        setTableValue(table, data);
        jFrame.repaint();
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static ResultSet queryPickPlan(String purchaserId){
        String sql = "select * from purchase where purchaser_id = ?;";
        List<Data> data = new ArrayList<Data>();
        data.add(new Data("Integer",purchaserId));
        return JDBC.getInstance().excuteQuery(sql,data);
    }

    public static List<PurchaserTable> getResultSetList(ResultSet rs) {
        try {
            List<PurchaserTable> list = new ArrayList<PurchaserTable>();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String password = rs.getString(2);
                String name = rs.getString(3);
                String sex = rs.getString(4);
                String tel = rs.getString(5);
                list.add(new PurchaserTable(id, password, name, sex, tel));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void setTableValue( JTable table, List<PurchaserTable> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt( dataList.get(i).getDataWithoutId().get(j) , i, j);
            }
        }
        for (int i = dataList.size(); i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("" , i, j);
            }
        }
    }
}
