public class E27RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = removeElement(nums, val);

        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length - 1;

        for (int i = length; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = -1;

                if (i < length) {
                    int aux = nums[length];
                    nums[length] = -1;
                    nums[i] = aux;
                }

                length -= 1;
            }
        }

        return length + 1;
    }

}
