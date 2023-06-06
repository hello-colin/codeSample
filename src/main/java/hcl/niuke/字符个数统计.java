package hcl.niuke;

import java.util.BitSet;
import java.util.Scanner;

/*
编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 */
public class 字符个数统计 {
    public static void main(String[] args) {
        int[] num=new int[127];
        Scanner in=new Scanner(System.in);
        String str=in.next();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            num[ch]++;
        }
        int count=0;
        for(int i=0;i<127;i++){
            if(num[i]!=0){
                count++;
            }
        }

        System.out.println(count);
    }
}
