class Solution {
    public int maxEle(int[] piles, int n) {
        int max = -1;

        for(int i = 0; i < n; i++) {
            max = Math.max(piles[i], max);
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int bananas = 1;

        int low = 1;
        int high = maxEle(piles, n);

        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;

            long sum = 0;
            for(int i = 0; i < n; i++) {
                sum += (piles[i] + (long)mid - 1) / mid;
            }

            if(sum <= h) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}