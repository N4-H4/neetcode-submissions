class Solution {
    
    public int maxArea(int[] height) {
        int n = height.length;

        int p1 = 0;
        int p2 = n - 1;

        int ans = 0;
        
        while(p1 < p2) {
            int left = height[p1];
            int right  = height[p2];

            int dist = p2 - p1;

            ans = Math.max(ans, dist * Math.min(right, left));
            if(left > right) {
                p2--;
            } else if(left < right) {
                p1++;
            } else {
                p1++;
                p2--;
            }
        }

        return ans;
    }
}