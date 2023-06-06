package hcl.niuke;

import java.util.Scanner;

/*
输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
保证输入的整数最后一位不是 0 。
 */
public class 提取不重复的整数 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        int[] exist=new int[10];
        String num=in.next();
        for(int i=num.length()-1;i>=0;i--){
    //        int key=Integer.parseInt(num.charAt(i)+"");
            int key=num.charAt(i)-'0';

            if(exist[key]==0){
                System.out.print(key);
                exist[key]=1;
            }
        }
    }
}
