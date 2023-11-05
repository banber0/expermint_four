// FileOperations.java
import java.io.*;

public class FileOperations {
    public static void writeFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(data + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //异常处理结构
    }

    public static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }//循环读取内容  null表示文件结束
            reader.close();//关闭文件读取器
        } catch (IOException e) {
            e.printStackTrace();//文件读取发生异常 捕获异常并打印错误信息
        }
        return content.toString();//以字符串的形式返回文件内容
    }
}
