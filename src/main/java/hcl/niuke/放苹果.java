package hcl.niuke;

import java.util.Scanner;

public class 放苹果 {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();

        int[][]dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j<i){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-i];
                }
            }
        }

        System.out.print(dp[m][n]);
    }
}
