package hcl.niuke;

import java.util.Scanner;

/*
写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 */
public class 字符串出现次数 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        str=str.toLowerCase();
        String target=in.next();
        target=target.toLowerCase();
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==target.charAt(0)){
                count++;
            }
        }
        System.out.println(count);
    }
}
