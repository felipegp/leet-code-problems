import java.util.Arrays;

public class E88MergedSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 0};
        int m = 0;
        int[] nums2 = {1, 2, 3, 4, 5};
        int n = 5;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int midx = m - 1;
        int nidx = n - 1;
        int right = m + n - 1;

        while (nidx >= 0) {
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];
                midx -= 1;
            } else {
                nums1[right] = nums2[nidx];
                nidx -= 1;
            }

            right -= 1;
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        for (int val : nums2) {
            int pos = getPos(nums1, val, m);
            addValAtPosAndShift(nums1, val, pos);
            m = m + 1;
        }
    }

    private static void addValAtPosAndShift(int[] nums, int val, int pos) {
        Integer curr = nums[pos];
        Integer next = 0;

        for (int i = pos; i < nums.length; i++) {
            if (i < nums.length - 1) {
                next = nums[i + 1];
                nums[i + 1] = curr;
                curr = next;
            } else {
                if (next != 0) {
                    nums[i] = curr;
                }
            }
        }

        nums[pos] = val;
    }

    private static int getPos(int[] nums, int val, int m) {
        int pos = 0;

        for (int i = 0; i < m; i++) {
            if (nums[i] >= val) {
                pos = i;
                break;
            }

            if (i + 1 == m) {
                pos = m;
            }
        }

        return pos;
    }

}
