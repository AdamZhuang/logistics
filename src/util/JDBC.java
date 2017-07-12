package util;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class JDBC {
    private static Connection conn = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    // 单例模式
    private static JDBC instance = new JDBC();
    private JDBC() {
        init();
    }
    public static JDBC getInstance() {
        return instance;
    }

    // 初始化
    private void init() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://localhost:3306/logistics?characterEncoding=utf8&useSSL=false";
            String user = "root";
            String password = "1108";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭
    public void close() {
        try {
            if (rs != null) {
                rs.close(); // 关闭结果集
            }
            if (pst != null) {
                pst.close(); // 关闭 preparedStatement
            }
            if (conn != null) {
                conn.close(); // 关闭连接
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 查询数据
    public ResultSet excuteQuery(String sql, List<Data> info) {
        try {
            pst = conn.prepareStatement(sql);
            dataprocess(sql,info);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 更新数据
    public int excuteUpdate(String sql, List<Data> info) {
        boolean isdone = false;
        try {
            // 构造prepared
            pst = conn.prepareStatement(sql);
            // 设置未知参数
            dataprocess(sql, info);
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void dataprocess(String sql, List<Data> info) {
        if(info == null){
            return;
        }
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i).getType().equals("Integer")) {
                try {
                    pst.setInt(i+1, Integer.parseInt(info.get(i).getInfo()));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e){
                    e.printStackTrace();
                }
            } else if (info.get(i).getType().equals("String")) {
                try {
                    String tmp = info.get(i).getInfo();
//                    if(tmp.equals("")){
//                        tmp = " ";
//                    }
                    pst.setString(i+1, tmp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}