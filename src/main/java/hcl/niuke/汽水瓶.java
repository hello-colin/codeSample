package hcl.niuke;

import java.util.Scanner;

//某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
//        小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
//        数据范围：输入的正整数满足
//        1≤n≤100
//
//        注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
// 输入a表示有a个输入
//10   3,(1)   1(1),
public class 汽水瓶 {

    public static int getResult(int num){
        if(num==2){
            return 1;
        }
        if(num<2){
            return 0;
        }

        int temp=num/3;
        int left=num%3+temp;
        return temp+ getResult(left);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int[] nums=new int[10];
        int cases=0;
        while(in.hasNext()){
            int num=in.nextInt();
            if(num==0)break;
            nums[cases++]=num;
        }

        for(int i=0;i<cases;i++){
            int out=getResult(nums[i]);
            System.out.println(out);
        }

    }
}
