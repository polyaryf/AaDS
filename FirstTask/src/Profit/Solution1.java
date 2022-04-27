package Profit;

public class Solution1 {
    static int maxProfit(int[] prices){
        int maxSum = 0;
        int minPrices = prices[0];
        int currentSum = 0;
        for (int i = 0; i < prices.length; i++) {
            currentSum = prices[i] - minPrices;
            if (prices[i] < minPrices){
                minPrices = prices[i];
            }
            if (maxSum < currentSum) maxSum = currentSum;
        }
        if (maxSum <= 0) return 0;
        else return maxSum;

    }


    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(maxProfit(prices));
    }
}
