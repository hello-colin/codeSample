package hcl.niuke;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class 识别有效的IP地址和掩码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            String str=in.nextLine();
            String[] ips=str.split("~");
            String ip1=ips[0];
            String ip2=ips[1];


        }
    }

    public static boolean error(String s){

        return false;

    }

    public static String ipToBinary(String s){
        StringBuilder out=new StringBuilder();
        String[] ipArray=s.split("\\.");
//        for(String ip:ipArray){
//            out.append()
//        }
        return null;
    }

    public static String getBinary(int num){
        LinkedList<String> out=new LinkedList<>();
        while (num>0){
            if(num%2==1)
                out.addFirst("1");
            else out.addFirst("0");
            num=num/2;
        }
        StringBuilder s=new StringBuilder();
        if(out.size()<8){
            for(int i=0;i < 8 - out.size();i++){
                s.append("0");
            }
        }
        for(int i=0;i<out.size();i++){
            s.append(out.get(i));
        }
        return null;
    }
}
