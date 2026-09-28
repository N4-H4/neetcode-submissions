class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int ans = nums[0];
        
        int st = 0;
        int end = n - 1;

        if(n == 1) return nums[0];

        while(st <= end) {
            int mid = (st + end) / 2;

            if(mid < n - 1) {
                if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            }

            if(nums[mid] == ans) return ans;

            if(nums[mid] > ans) {
                st = mid + 1;
            } else if(nums[mid] < ans) {
                ans = nums[mid];
                end = mid - 1;
            }
        }

        return ans;
    }
}