package hcl.niuke;

import java.util.Scanner;

public class 兔子数量 {
    public static void main(String[] args) {
        int[] num=new int[12];
        Scanner in=new Scanner(System.in);

        int n=in.nextInt();
        num[0]=1;
        num[1]=1;
        for(int i=2;i<12;i++){
            num[i]=num[i-2]+num[i-1];
        }

        System.out.print(num[n]);
    }
}
