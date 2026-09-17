class Solution { 
    public int[] maxSlidingWindow(int[] nums, int k) { 
        int n = nums.length; 
        int[] ans = new int[n - k + 1]; 
 
        int st = 0; 
        int end = st + k - 1; 
         
        int idx = 0; 
        int currMax = Integer.MIN_VALUE; 
 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        PriorityQueue<Integer> remove = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = st; i <= end; i++) { 
            pq.offer(nums[i]); 
        } 
 
        currMax = pq.peek(); 
 
        ans[idx] = currMax; 
 
        st++;       
 
        while(end++ < n - 1) { 
            idx++; 
            int prev = nums[st - 1]; 
            int next = nums[end]; 
 
            pq.offer(next);
            remove.offer(prev);

            while(!pq.isEmpty() && pq.peek().equals(remove.peek())) {
                pq.poll();
                remove.poll();
            }

            currMax = pq.peek();

            ans[idx] = currMax; 
 
            st++; 
              
        } 
        return ans; 
    } 
}