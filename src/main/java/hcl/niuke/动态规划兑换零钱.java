package hcl.niuke;

import java.util.HashSet;
import java.util.Set;

/*
给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
如果无解，请返回-1.
数据范围：数组大小满足 0≤n≤10000 ， 数组中每个数字都满足 0<val≤10000，0≤aim≤5000要求：时间复杂度 O(n×aim) ，空间复杂度 O(aim)。
     * 最少货币数
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
 */
public class 动态规划兑换零钱 {
    public int minMoney (int[] arr, int aim) {
        // write code here
        //如何使用最少arr元素 构成 aim值
        //dp[i] 代表给定钱数为i的时候最少货币数 就是凑成 i 元钱，需要dp[i] 张arr中面值纸币
        //没办法兑换 arr[i]  dp[i] = dp[i]
        //可以dp[i] = dp[i - arr[i]] + 1
        //dp[i] = min(dp[i], dp[i-a[j]])
        if(arr == null || arr.length == 0){
            return -1;
        }
        int[] dp = new int[aim+1];
        for(int i = 0;i<=aim;i++){
            dp[i] = 99999;
        }

        dp[0] = 0;
        for(int i = 1;i<=aim;i++){
            for(int j = 0;j< arr.length;j++){
                if(arr[j] <= i){
                    //给了一张 3 元钱，小于 需要找零的4 元钱，那 就等于 1 + 需要找零剩下的钱dp[i -arr[j]] 4 - 3
                    dp[i] = Math.min(dp[i], dp[i-arr[j]] +1);
                }
            }
        }
        return (dp[aim] > 99999) ?-1 : dp[aim];
    }

     public static void main(String[] args) {
        动态规划兑换零钱 test=new 动态规划兑换零钱();
        int[] arr={3};
        int aim=3;
        System.out.println(test.minMoney(arr,aim));

    }
}
