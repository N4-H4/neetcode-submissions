class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] ans = new int[n];

        int[] st = new int[n];
        int top = -1;

        for(int i = 0; i < n; i++) {
            while(top >= 0 && temperatures[i] > temperatures[st[top]]) {
                ans[st[top]] = i - st[top--];
            }

            st[++top] = i;
        }
        return ans;
    }
}