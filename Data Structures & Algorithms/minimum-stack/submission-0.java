class MinStack {
    int idx = 0;
    int[] stack;
    int[] minStack;

    public MinStack() {
         stack = new int[30000];
         minStack = new int[30000];
    }
    
    public void push(int value) {
        stack[idx] = value;
        if(idx == 0) {
            minStack[idx] = value;
        } else {
            if(minStack[idx-1] <= value) {
                minStack[idx] = minStack[idx - 1];
            } else {
                minStack[idx] = value;
            }
        }
        idx++;
    }
    
    public void pop() {
        stack[idx] = 0;
        minStack[idx] = 0;
        idx--;
    }
    
    public int top() {
        return stack[idx-1];
    }
    
    public int getMin() {
       return minStack[idx-1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */