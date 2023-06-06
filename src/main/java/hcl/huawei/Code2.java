package hcl.huawei;

import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String s1=in.next();
        String s2=in.next();
        int k=in.nextInt();

        //寻找最右侧left

        int s1len=s1.length();
        int s2len=s2.length();
        int result=-1;


        if(s2len>=s1len+k){
            int i=s2.indexOf(s1);
            if(i==-1){
                result=-1;
            }else{
                if(i<k+s1len-1){
                    result=0;
                }else{
                    result=i-k;
                }
            }

        }

        System.out.println(result);

    }
}
