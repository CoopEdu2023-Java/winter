class Solution {
    public int search(int[] nums, int target) {
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
        if (l < nums.length && nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}