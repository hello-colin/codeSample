package hcl.niuke;

import java.util.Scanner;

public class 字符串编辑距离 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str1=in.next();
        String str2=in.next();


        int[][] dp=new int[str1.length()][str2.length()];

        dp[0][0]=0;
        for(int i=1;i<str1.length();i++){
            dp[i][0]=i;
        }


        for(int i=1;i<str2.length();i++){
            dp[0][i]=i;
        }
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){

                if(str1.charAt(i)==str2.charAt(i)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i][j-1]+1,dp[i-1][j]+1));
                }
            }
        }

        System.out.print(dp[str1.length()][str2.length()]);
    }
}
