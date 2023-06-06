package hcl.huawei;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Code1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int T=in.nextInt();
        int n=in.nextInt();

        int[][] dp=new int[T+1][n+1];
        int[] time=new int[n];
        int[] weight=new int[n];
        for(int i=0;i<n;i++){
            int value_t=in.nextInt();
            int value_w=in.nextInt();
            time[i]=value_t;
            weight[i]=value_w;
        }

        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }

        for(int i=0;i<=T;i++){
            dp[i][0]=0;
        }


        for(int i=1;i<=T;i++){
            for(int j=1;j<=n;j++){
                if(i-time[j-1]>=0){
                    dp[i][j]=Math.max(dp[i-time[j-1]][j-1]+weight[j-1],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[T][n]);



    }
}
