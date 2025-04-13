public class E121BestTimeBuyStock {

    public static void main(String[] args) {
        int[] input = {7, 6, 4, 3, 1};
        int result = maxProfit(input);

        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int diff = 0;
        int j = 0;

        for (int i = 1; i < prices.length; i++) {
            int auxDiff = prices[i] - prices[j];

            if (auxDiff > diff) {
                diff = auxDiff;
            }

            if (prices[j] > prices[i]) {
                j = i;
            }
        }

        return diff;
    }

    public static int maxProfit2(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int buy = 0;
        int diff = 0;

        for (int i = 0; i < prices.length; i++) {
            if (diff == 0 || prices[i] < prices[buy]) {
                for (int j = i + 1; j < prices.length; j++) {
                    int auxDiff = prices[j] - prices[i];
                    if (diff < auxDiff) {
                        buy = i;
                        diff = auxDiff;
                    }
                }
            }
        }

        return diff;
    }

}
