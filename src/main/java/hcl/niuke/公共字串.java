package hcl.niuke;

import java.util.Scanner;

public class 公共字串 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str1=in.next();
        String str2=in.next();

        int[][]dp=new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<str1.length();i++){
            dp[i][0]=0;
        }

        for(int j=0;j<str2.length();j++){
            dp[0][j]=0;
        }

        int res=0;
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){

                if(str2.charAt(j-1)==str1.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }

                res=Math.max(res,dp[i][j]);

            }
        }
        System.out.println(res);
    }
}
