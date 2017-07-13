package module;

import object.*;
import util.Data;
import util.JDBC;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 向光性 on 2017/7/12.
 */
public class ManagerSystem {
    public static String insertSqlConstruct(String tableName, List<String> columnName) {
        String sql;
        sql = "INSERT INTO " + tableName + " (";
        for (int i = 0; i < columnName.size(); i++) {
            if(i < columnName.size()-1) {
                sql = sql + "`" + columnName.get(i) + "`, ";
            } else {
                sql = sql + "`" + columnName.get(i) + "`)";
            }
        }
        sql = sql + " VALUES (";
        for (int i = 0; i < columnName.size(); i++) {
            if(i < columnName.size()-1){
                sql = sql + "?,";
            }else {
                sql = sql + "?);";
            }
        }
        return sql;
    }

    public static boolean isDataValid(List<String[]> data, int[] index) {
        for (int i = 0; i < data.size(); i++) {
            String[] tmp = data.get(i);
            try{
                for (int j = 0; j < index.length; j++) {
                    if(tmp[index[j]-1].equals("")){
                        continue;
                    }
                    Integer.parseInt(tmp[index[j]-1]);
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static List<List<Data>> cleanData(List<String[]> data, List<String> types) {
        List<List<Data>>newData = new ArrayList<List<Data>>();
        for (int i = 0; i < data.size(); i++) {
            // 创建Data数组
            List<Data> aData = new ArrayList<Data>();
            // 构建Data数组
            for (int j = 0; j < data.get(i).length; j++) {
                aData.add(new Data(types.get(j),data.get(i)[j]));
            }
            // 添加
            newData.add(aData);
        }
        return newData;
    }

    public static List<String[]> getTableData(int rowCount, int columnCount, JTable purchaserTable) {
        List<String[]> data = new ArrayList<String[]>();

        for (int i = 0; i < rowCount; i++) {
            int count = 0;
            for (int j = 0; j < columnCount; j++) {
                if(purchaserTable.getValueAt(i,j)==null || purchaserTable.getValueAt(i,j).equals("")){
                    count++;
                }
            }
            // 全为Null
            if(count==columnCount){
                continue;
            }
            // 添加数据
            String[] tmp = new String[columnCount];
            for (int j = 0; j < columnCount; j++) {
                tmp[j] = (String)purchaserTable.getValueAt(i,j);
            }
            data.add(tmp);
        }
        return data;
    }

    public static boolean isPkRepeat(List<String> mainKey) {
        boolean isRepeat = false;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < mainKey.size(); i++) {
            if(mainKey.get(i).equals("") || mainKey.get(i) == null){
                continue;
            }
            if(set.add(mainKey.get(i)) == false){
                JOptionPane.showMessageDialog(null, "主键重复，无法进行插入，请检查并修改数据", "警告", JOptionPane.ERROR_MESSAGE);
                isRepeat = true;
            }
        }
        return isRepeat;
    }

    public static List<String> getPK(int rowCount, int PKNum, JTable purchaserTable) {
        List<String> PK =  new ArrayList<String>();
        for (int i = 0; i < rowCount; i++) {
            boolean isNull = false;
            for (int j = 0; j < PKNum; j++) {
                if(purchaserTable.getValueAt(i,j) == null){
                    isNull = true;
                }
            }
            // 有空数据，跳过本次循环
            if(isNull){
                continue;
            }

            // 连接主键称一个字符串
            String tmp = "";
            for (int j = 0; j < PKNum; j++) {
                tmp = tmp.concat((String)purchaserTable.getValueAt(i,j));
            }
            PK.add(tmp);
        }
        return PK;
    }

    public static <T> List<T> getResultSetList(Class<T> c, String className,ResultSet rs) throws SQLException {
        List<T> list = new ArrayList<T>();
        if(className.equals("Purchaser")) {
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String password = rs.getString(2);
                String name = rs.getString(3);
                String sex = rs.getString(4);
                String tel = rs.getString(5);
                list.add((T)new Purchaser(id, password, name, sex, tel));
            }
        } else if(className.equals("Picker")){
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String password = rs.getString(2);
                String name = rs.getString(3);
                String sex = rs.getString(4);
                String tel = rs.getString(5);
                list.add((T)new Picker(id, password, name, sex, tel));
            }
        } else if(className.equals("Commodity")){
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String name = rs.getString(2);
                String company = rs.getString(3);
                list.add((T)new Commodity(id, name,company));
            }
        } else if(className.equals("PurchaseTable")){
            while (rs.next()) {
                String purchaserId = String.valueOf(rs.getInt(1));
                String commodityId = String.valueOf(rs.getInt(2));
                String purchaseDate = rs.getString(3);
                String quantity = String.valueOf(rs.getInt(4));
                String isdone = String.valueOf(rs.getInt(5));
                list.add((T)new PurchaseTable(purchaserId,commodityId, purchaseDate, quantity, isdone));
            }
        } else if(className.equals("PickTable")){
            while (rs.next()) {
                String purchaserId = String.valueOf(rs.getInt(1));
                String commodityId = String.valueOf(rs.getInt(2));
                String purchaseDate = rs.getString(3);
                String quantity = String.valueOf(rs.getInt(4));
                String isdone = String.valueOf(rs.getInt(5));
                list.add((T)new PickTable(purchaserId,commodityId, purchaseDate, quantity, isdone));
            }
        } else if(className.equals("Repository")){
            while (rs.next()) {
                String commodityId = String.valueOf(rs.getInt(1));
                String commodityName = rs.getString(2);
                String commodityQuantity = String.valueOf(rs.getInt(3));
                list.add((T)new Repository(commodityId, commodityName, commodityQuantity));
            }
        }
        return list;
    }

    public static <T> void showData(Class<T> c, String className, JDialog dialog, JTable table,String tableName) {
        try {
            String sql = "select * from " + tableName;
            //获取结果集
            ResultSet rs = JDBC.getInstance().excuteQuery(sql,null);
            //获取数据
            List<T> dataList = getResultSetList(c, className, rs);
            // 设置表格值
            setTableValue(c, className, table, dataList);

            dialog.repaint();
            dialog.pack();
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static <T> void setTableValue(Class<T> c, String className, JTable table, List<T> dataList) {
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                if(className.equals("Purchaser")){
                    table.setValueAt( ((Purchaser)dataList.get(i)).getData().get(j) , i, j);
                } else if(className.equals("Picker")){
                    table.setValueAt( ((Picker)dataList.get(i)).getData().get(j) , i, j);
                } else if(className.equals("Commodity")){
                    table.setValueAt( ((Commodity)dataList.get(i)).getData().get(j) , i, j);
                } else if(className.equals("PurchaserTable")){
                    table.setValueAt( ((PurchaseTable)dataList.get(i)).getData().get(j) , i, j);
                } else if(className.equals("PickTable")){
                    table.setValueAt( ((PickTable)dataList.get(i)).getData().get(j) , i, j);
                } else if(className.equals("Repository")){
                    table.setValueAt( ((Repository)dataList.get(i)).getData().get(j) , i, j);
                }
            }
        }

        for (int i = dataList.size(); i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("" , i, j);
            }
        }
    }

    public static <T> void confirm(Class<T> c, String className, JDialog dialog, JTable table, String tableName, List<String> columnName, int primaryKeyNum, int[] integerIndex) {
        // 获取表格数据
        int rowCount = table.getRowCount();
        int columnCount = table.getColumnCount();
        //取出所有主键
        List<String> PK = getPK(rowCount,primaryKeyNum, table);
        //判断主键是否重复
        if(isPkRepeat(PK)){
            return;
        }
        // 取出所有有效数据
        List<String[]> data = getTableData(rowCount, columnCount, table);
        // 验证数据合法性
        if (!isDataValid(data, integerIndex)){
            JOptionPane.showMessageDialog(null,"数据类型错误，请检查重新输入","",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 清空数据库
        String sql = "delete from " + tableName;
        JDBC.getInstance().excuteUpdate(sql,null);

        // 重构数据
        List<String> types = new ArrayList<String>();
        setTypesList(integerIndex, columnCount, types);
        List<List<Data>> newData = cleanData(data, types);

        // 重新插入数据
        sql = insertSqlConstruct(tableName, columnName);
        boolean isOk = true;
        for (int i = 0; i < newData.size(); i++) {
            if(JDBC.getInstance().excuteUpdate(sql,newData.get(i))==0){
                isOk = false;
            }
        }
        if(isOk) {
            JOptionPane.showMessageDialog(null, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
        try {
            showData(c,className, dialog,table,tableName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setTypesList(int[] integerIndex, int columnCount, List<String> types) {
        for (int i = 0; i < columnCount; i++) {
            boolean isString = true;
            for (int j = 0; j < integerIndex.length; j++) {
                if(i == integerIndex[j]-1){
                    isString = false;
                }
            }
            if(isString){
                types.add("String");
            } else {
                types.add("Integer");
            }
        }
    }


    public static void showPasswordChanngeDialog(JDialog passwordChangeDialog, JTextField oldPasswordTF,JTextField newPasswordTF,JTextField newPasswordAgainTF){
        passwordChangeDialog.pack();
        passwordChangeDialog.setVisible(true);
        //清空数据
        oldPasswordTF.setText("");
        newPasswordTF.setText("");
        newPasswordAgainTF.setText("");
    }

    public static void changePassword(JDialog passwordChangeDialog, JTextField oldPasswordTF,JTextField newPasswordTF,JTextField newPasswordAgainTF){
        try {
            //判断密码是否输入一致
            String newPassword1 = newPasswordTF.getText();
            String newPassword2 = newPasswordAgainTF.getText();
            if(!newPassword1.equals(newPassword2)){
                JOptionPane.showMessageDialog(null,"两次输入密码不一致","警告",JOptionPane.ERROR_MESSAGE);
            }

            //获取用户密码以及输入密码
            String sql = "select manager_passwd from manager";
            ResultSet rs = JDBC.getInstance().excuteQuery(sql,null);
            String realPassword = null;
            if(rs.next()){
                realPassword = rs.getString(1);
            }
            String inputedPassword = oldPasswordTF.getText();

            //判断密码正确与否
            if(!inputedPassword.equals(realPassword)){
                JOptionPane.showMessageDialog(null,"密码错误，请重新输入旧密码","警告",JOptionPane.ERROR_MESSAGE);
                return;
            }


            //写入密码
            sql = "UPDATE `logistics`.`manager` SET `manager_passwd`= ? WHERE `manager_username`='admin'";
            List<Data> data = new ArrayList<Data>();
            data.add(new Data("String",newPassword1));
            JDBC.getInstance().excuteUpdate(sql,data);
            JOptionPane.showMessageDialog(null,"修改成功！","提示",JOptionPane.INFORMATION_MESSAGE);
            passwordChangeDialog.dispose();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
