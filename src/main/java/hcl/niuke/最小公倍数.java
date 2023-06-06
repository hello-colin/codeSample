package hcl.niuke;

import java.util.Scanner;

public class 最小公倍数 {
    public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            int m=in.nextInt();
            int n=in.nextInt();

            int res=m;
            while (res%n!=0){
                res=res+m;
            }

            System.out.println(res);
    }
}
