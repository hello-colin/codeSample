package hcl.niuke;

public class 动态规划最长上升子序列 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定数组的最长严格上升子序列的长度。
     * @param arr int整型一维数组 给定的数组
     * @return int整型
     */
    public int LIS (int[] arr) {

        // write code here
        if(arr.length==0)
            return 0;
        int[]dp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
        }
        int max=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
