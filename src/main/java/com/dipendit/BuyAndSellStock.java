package com.dipendit;

public class BuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("Max Profit: " + maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (currentPrice < prices[j]) {
                    maxProfit = Math.max(maxProfit, prices[j] - currentPrice);
                }
            }
        }

        return maxProfit;
    }
}
