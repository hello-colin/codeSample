package hcl.niuke;

import java.util.Scanner;

/*
蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。

例如，当输入5时，应该输出的三角形为：

1 3 6 10 15

2 5 9 14

4 8 13

7 12

11
 */
public class 蛇形矩阵 {
    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i;j++){
//                System.out.print( (j+i+1)*(j+i+2)/2-(i+1)*(i+2)/2 +  (i*(i+1))/2     +1  );
//                System.out.print(' ');
//            }
//            System.out.print('\n');
//        }
//    }

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][]table=new int[n][n];
        fill(table,1,0,n-1);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(table[i][j]!=0){
                    System.out.print(table[i][j]);
                    System.out.print(' ');
                }
            }
            System.out.print('\n');
        }

    }

    public static void fill(int[][] table,int num,int n,int maxN){
        int i=n;
        for(int j=0;j<=n;j++){
            table[i--][j]=num++;
        }
        if(n==maxN){
            return;
        }
        fill(table,num,n+1,maxN);
    }

}
