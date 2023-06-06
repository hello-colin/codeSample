package hcl.huawei;

import java.util.Scanner;

public class Code222 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String target=in.next();
        String source=in.next();
        int k=in.nextInt();

        int targetlen=target.length();
        int sourcelen=source.length();
        if(sourcelen<targetlen+k){
            System.out.println(-1);
            return;
        }


        int[] count=new int[128];


        for(int i=0;i<targetlen;i++){
            int c=target.charAt(i);
            //遍历次数
            count[c]++;
        }


        int total=targetlen;

        int maxI=sourcelen-targetlen-k;
        int subStrLen=targetlen+k;


        for(int j=0;j<subStrLen;j++){
            int c=source.charAt(j);

            if(count[c]-->0){
                total--;
            }

            if(total==0){
                System.out.println(0);
                return;
            }
        }


        for(int i=1;i<=maxI;i++){
            int remove=source.charAt(i-1);
            int add=source.charAt(i-1+subStrLen);

            if(count[remove]++>=0){
                total++;
            }


            if(count[add]-->0){
                total--;
            }
            if(total==0){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }
}
