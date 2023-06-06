package hcl.niuke;

import java.util.Scanner;

/*
写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整
 */
public class 取近似值 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        float input=in.nextFloat();


  //    float input=55.5f;

        int out=(int)input;
        if(input-out>=0.5){
            out++;
        }
        System.out.print(out);
    }

}
