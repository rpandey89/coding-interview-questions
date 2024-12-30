package practice2022.ds.arrays;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int smallestPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price >= smallestPrice) {
                maxProfit = price - smallestPrice;
            } else {
                smallestPrice = price;
            }
        }

        return maxProfit;
    }
}
