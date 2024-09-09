class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        if (l < 0) {
            return 0;
        } else if (l >= nums.length) {
            return nums.length;
        } else if (nums[l] == target) {
            return l;
        } else if (nums[l] > target) {
            return l;
        } else {
            return l + 1;
        }
    }
}