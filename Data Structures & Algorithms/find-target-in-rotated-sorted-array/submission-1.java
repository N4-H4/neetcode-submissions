class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int st = 0, end = n - 1;

        if(nums[st] < nums[end]) {
            while(st <= end) {
                int mid = (st + end) / 2;

                if(nums[mid] < target) {
                    st = mid + 1;
                } else if(nums[mid] > target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        } else {

            while(st <= end) { 
                int mid = (st + end) / 2; 
 
                if(nums[mid] < target) { 
                    if(nums[mid] <= nums[end]) { 
                        if(target <= nums[end]) {
                            st = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    } else {
                        st = mid + 1;
                    }
                } else if(nums[mid] > target) { 
                    if(nums[st] <= nums[mid]) { 
                        if(target >= nums[st]) {
                            end = mid - 1;
                        } else {
                            st = mid + 1;
                        }
                    } else {
                        end = mid - 1;
                    }
                } else {
                    return mid; 
                } 
                 
            } 
        } 


        return -1;
    }
}