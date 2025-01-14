import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, current = 0;

        while (current <= right) {
            switch (nums[current]) {
                case 0 -> {
                    swap(nums, current, left);
                    left++;
                    current++;
                }
                case 2 -> {
                    swap(nums, current, right);
                    right--;
                }
                default -> current++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}