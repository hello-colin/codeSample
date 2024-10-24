package hcl.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class 输出 {
    public static void main(String[] args) {
        String filename="ba/1.txt";
        try{

            List<String> task=new ArrayList<>();


            File file=new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write("哈哈哈00");
            bufferedWriter.close();
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
