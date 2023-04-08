package hcl.niuke;

public class 动态规划买股票的最好时机 {

    public int maxProfit (int[] prices) {
        // write code here
        int[]dp1=new int[prices.length];
        int[]dp2=new int[prices.length];


        //从左侧找一次交易，从右侧找一次交易
        //从左往右为卖点
        //从右往左为买点
        //第一次，寻求最高利润
        int p=0;//利润
        int minPrices=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]-minPrices>p){
                p=prices[i]-minPrices;
            }
            dp1[i]=p;
            if(prices[i]<minPrices){
                minPrices=prices[i];
            }
        }

        p=0;
        int maxPrices=prices[prices.length-1];

        for(int j=prices.length-2;j>0;j--){
            if(maxPrices-prices[j]>p){
                p=maxPrices-prices[j];
            }

            dp2[j]=p;

            if(prices[j]>maxPrices){
                maxPrices=prices[j];
            }
        }


        int fp=0;

        for(int i=0;i<prices.length;i++){
            fp=Math.max(dp1[i]+dp2[i],fp);
        }
        return fp;

    }

    public static void main(String[] args) {
        动态规划买股票的最好时机 function=new 动态规划买股票的最好时机();
        int[]prices={8,9,3,5,1,3};
        System.out.println(function.maxProfit(prices));
    }
}
