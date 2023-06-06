package hcl.niuke;

import java.util.Scanner;

/*
输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。

数据范围：保证在 32 位整型数字范围内
 */
public class int存储1的个数 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int num=in.nextInt();
        int count=0;
        while (num>0){
            if(num%2==1){
                count++;
            }
            num=num/2;
        }
        System.out.print(count);
    }
}
