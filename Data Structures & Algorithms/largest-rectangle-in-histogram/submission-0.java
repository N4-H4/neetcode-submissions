class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.empty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();

                maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
            }
            st.push(i);
        }

        while(!st.empty()) {
            int nse = n;
            int element = st.pop();
            int pse = st.empty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, (nse - pse - 1) * heights[element]);
        }

        return maxArea;
    }
}