package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 向光性 on 2017/7/11.
 */
public class FileFactory {
    // 单例模式
    private static FileFactory instance = new FileFactory();
    private FileFactory(){}
    public static FileFactory getInstance() {
        return instance;
    }

    /**
     * 读文件
     *
     * @param filePath
     * @throws Exception
     */
    public List<String> readFile(String filePath){
        try {
            File file = new File(filePath);

            //判断文件是否存在
            if(file.isFile() && file.exists()){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                List<String> contents = new ArrayList<String>();
                String lineText = null;
                while((lineText = bufferedReader.readLine()) != null){
                    contents.add(lineText);
                }

                bufferedReader.close();
                return contents;
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件出错");
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 写文件
     *
     * @param filePath
     * @throws Exception
     */
    public boolean writeFile(String filePath, List<String> contents){
        try {
            File file = new File(filePath);
            //如果文件不存在则创建
            if (file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(filePath));
            for (int i = 0; i < contents.size(); i++) {
                bufferedWriter.write(contents.get(i));
            }

            bufferedWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("写入文件出错");
            e.printStackTrace();
        }
        return false;
    }
}
