public class E1672RichestCustomer {
    public static void main(String[] args) {
        int[][] input = {{7, 1, 3}, {2, 8, 7}, {1, 9, 10}};
        int result = getRichest(input);

        System.out.println(result);
    }

    private static int getRichest(int[][] accounts) {
        int richestTotal = 0;

        for (int[] customer : accounts) {
            int customerTotal = 0;

            for (int bank : customer) {
                customerTotal += bank;
            }

            if (customerTotal > richestTotal) {
                richestTotal = customerTotal;
            }
        }

        return richestTotal;
    }
}
