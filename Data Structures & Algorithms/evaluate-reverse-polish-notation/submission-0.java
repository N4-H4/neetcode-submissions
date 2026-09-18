class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        int ans = Integer.parseInt(tokens[0]);

        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+")) {
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());

                int res = num1 + num2;

                st.push(Integer.toString(res));
            } else if(s.equals("-")) {
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());

                int res = num1 - num2;

                st.push(Integer.toString(res));
            } else if(s.equals("*")) {
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());

                int res = num1 * num2;

                st.push(Integer.toString(res));
            } else if(s.equals("/")) {
                int num2 = Integer.parseInt(st.pop());
                int num1 = Integer.parseInt(st.pop());

                int res = num1 / num2;

                st.push(Integer.toString(res));
            } else {
                st.push(s);
            }
        }

    
        return Integer.parseInt(st.peek());
    }
}