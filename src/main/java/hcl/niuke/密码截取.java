package hcl.niuke;

import java.util.Scanner;

/*
Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，
而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 */
public class 密码截取 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String str=in.next();

        boolean[][]dp=new boolean[str.length()][str.length()];
        for(int i=0;i<str.length();i++){
            dp[i][i]=true;
        }

        int res=0;

        for(int j=1;j<str.length();j++){
            for(int i=0;i<j;i++){
                if(str.charAt(i)==str.charAt(j) && ((j-i==1) || dp[i+1][j-1])){
                    dp[i][j]=true;
                    res=Math.max(res,j-i+1);
                }
            }
        }
    }
}
