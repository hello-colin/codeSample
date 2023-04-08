package hcl.niuke;

import java.util.Scanner;

/*
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
数据范围：保证结果在 1≤n≤2^31−1
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str=in.nextLine();
            int num=0;
            for(int i=2;i<str.length();i++){
                char a=str.charAt(i);
                num=num*16+toHex(a);
            }
            System.out.println(num);
        }
    }

    public static  int toHex(char a){
        if(a>='A'){
            return a-'A'+10;
        }
        else{
            return a-'0';
        }
    }
}
