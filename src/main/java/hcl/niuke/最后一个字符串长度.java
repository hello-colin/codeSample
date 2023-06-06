package hcl.niuke;
/*
计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 */

import java.util.Scanner;

public class 最后一个字符串长度 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        while(in.hasNextLine()){
            String str=in.nextLine();
            String[] strs=str.split(" ");
            System.out.println(strs[strs.length-1].length());
        }
    }
}
