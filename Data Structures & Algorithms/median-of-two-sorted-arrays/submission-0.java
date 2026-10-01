class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] ar = new int[n + m];

        int sz = ar.length;

        int p1 = 0;
        int p2 = 0;

        int i = 0;
        while(p1 < n && p2 < m && i < sz) {
            if(nums1[p1] <= nums2[p2]) {
                ar[i] = nums1[p1];
                p1++;
            } else {
                ar[i] = nums2[p2];
                p2++;
            }
            i++;
        }

        if(p1 < n) {
            for(int j = p1; j < n; j++) {
                ar[i] = nums1[j];
                i++;
            }
        } else if(p2 < m) { 
            for(int j = p2; j < m; j++) {
                ar[i] = nums2[j];
                i++;
            }
        }
        

        if(sz % 2 == 0) {
            return (ar[(sz - 1) / 2] + ar[((sz - 1) / 2) + 1]) / 2.0;
        }
        return ar[(sz - 1) / 2];
    }
}