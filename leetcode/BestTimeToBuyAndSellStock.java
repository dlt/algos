class Solution {
    // 3 4 5 3 6 8 4
    // mp = 1
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int b = 0;
        int s = 1;
        int len = prices.length;

        while (s < len && b < len) {
            int buy = prices[b];
            int sell = prices[s];

            if (sell > buy) {
                int profit = sell - buy;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
                if (s < len)
                    s++;
            } else {
                b = s;
                if (s < len)
                    s++;
            }
        }

        return maxProfit;
    }
}