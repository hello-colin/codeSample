package hcl.niuke;

import java.util.Scanner;


public class 动态规划矩阵 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m=in.nextInt();
            int n=in.nextInt();
            int[][] arrays=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arrays[i][j]=in.nextInt();
                }
            }

            int[][] grid =new int[m][n];
            grid[0][0]=arrays[0][0];
            for(int i=1;i<m;i++){
                grid[i][0]= grid[i-1][0]+arrays[i][0];
            }
            for(int j=1;j<n;j++){
                grid[0][j]= grid[0][j-1]+arrays[0][j];
            }

            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    grid[i][j]=Math.min(grid[i-1][j], grid[i][j-1])+arrays[i][j];
                }
            }

            System.out.println(grid[m-1][n-1]);
        }
    }
}
