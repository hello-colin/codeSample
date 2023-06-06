package hcl.niuke;

import java.util.Scanner;

/*
功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class 质数因子 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input=in.nextInt();

        while(input>1){
            boolean flag=false;
            //一直判断到sqrt(input)
//            for(int i=2;i<=input/i;i++){
//                if(input%i==0){
//                    input=input/i;
//                    System.out.print(i+" ");
//                    flag=true;
//                    break;
//                }
//            }

            for(int i=2;i<=Math.sqrt(input);i++){
                if(input%i==0){
                    input=input/i;
                    System.out.print(i+" ");
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.print(input);
                break;
            }
        }

    }
}
