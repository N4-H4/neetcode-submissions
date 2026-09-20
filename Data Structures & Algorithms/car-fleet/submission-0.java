class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] pair = new int[n][2];

        for(int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        Stack<Double> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            int p = pair[i][0];
            int s = pair[i][1];

            double time = (double)(target - p) / s;

            st.push(time);

            if(st.size() >= 2 && st.get(st.size() - 1) <= st.get(st.size() - 2)) {
                st.pop();
            }
        }

        return st.size();
    }
}