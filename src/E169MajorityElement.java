import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E169MajorityElement {

    public static void main(String[] args) {
        int[] input = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(input);

        System.out.println(result);
        System.out.println(Arrays.toString(input));
    }

    public static int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int val : nums) {
            int count = map.getOrDefault(val, 0);
            map.put(val, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey();
            }
        }

        return 0;
    }

}
