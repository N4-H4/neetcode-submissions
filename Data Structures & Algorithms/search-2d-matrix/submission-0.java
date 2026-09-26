class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int st = 0;
        int end = n - 1;

        while(st <= end) {
            int mid = (st + end) / 2;

            if(matrix[mid][m - 1] < target) {
                st = mid + 1;
            } else if(matrix[mid][m - 1] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        if(st == n) {
            return false;
        }
        int[] ar = matrix[st];

        st = 0;
        end = m - 1;

        while(st <= end) {
            int mid = (st + end) / 2;

            if(ar[mid] < target) {
                st = mid + 1;
            } else if(ar[mid] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}