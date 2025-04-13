import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E26RemoveDuplicates {

    public static void main(String[] args) {
        int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(input);

        System.out.println(result);
        System.out.println(Arrays.toString(input));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int removeDuplicates2(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Integer val = map.get(nums[i]);

            if (val == null) {
                map.put(nums[i], nums[i]);
            } else {
                for (int j = i; j < length; j++) {
                    if (j != length - 1) {
                        nums[j] = nums[j + 1];
                        nums[j + 1] = 0;
                    }
                }

                i -= 1;
                length -= 1;
            }
        }

        return length;
    }

}
