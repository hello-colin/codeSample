package hcl.niuke;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输
出。
数据范围： 1≤n≤1000  ，输入的数字大小满足 1≤val≤500
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while(in.hasNext()){
            int N=in.nextInt();
            Integer[]array=new Integer[N];
            for(int i=0;i<N;i++){
                array[i]=in.nextInt();
            }
            deal(N,array);

        }


    }

    public static void deal(int n,Integer[]array){
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.equals(o2)){
                    return 0;
                }
                return o1-o2;
            }
        });

        for(int i=0;i<array.length-1;i++){
            if(array[i].equals(array[i+1]))
                continue;
            System.out.println(array[i]);
        }
        System.out.println(array[array.length-1]);

    }
}
