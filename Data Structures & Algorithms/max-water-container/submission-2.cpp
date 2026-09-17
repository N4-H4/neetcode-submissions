class Solution {
public:
    int maxArea(vector<int>& heights) {
       int n = heights.size();

        int p1 = 0;
        int p2 = n - 1;

        int ans = 0;
        
        while(p1 < p2) {
            int left = heights[p1];
            int right  = heights[p2];

            int dist = p2 - p1;

            ans = max(ans, dist * min(right, left));
            if(left > right) {
                p2--;
            } else 
                p1++;
            
        }

        return ans; 
    }
};
