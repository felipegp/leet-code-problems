import java.util.Arrays;

public class E1480RunningSum {

    public static void main(String[] args) {
        int[] input = {3, 1, 2, 10, 1};
        var result = sumArrayBest(input);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sumArray(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = i == 0 ? nums[i] : sum + nums[i];
            result[i] = sum;
        }

        return result;
    }

    private static int[] sumArrayBest(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

}
