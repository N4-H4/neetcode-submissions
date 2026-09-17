class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        if(n % 2 == 1) return false;
        if(n == 0) return true;
        st.push(s.charAt(0));

        
            for(int i = 1; i < n; i++) {
                char ch = s.charAt(i);
                if(ch == '(' || ch == '[' || ch == '{') {
                    st.push(ch);
                } else {
                    if(st.empty()) return false;

                    if(ch == ')') {
                        if(st.peek() != '(') return false;
                        else st.pop();
                    } else if(ch == ']') {
                        if(st.peek() != '[') return false;
                        else st.pop();
                    } else if(ch == '}') {
                        if(st.peek() != '{') return false;
                        else st.pop();
                    } 
                }
                
            }
        
            if(st.size() == 0) return true; 
            return false;
        }
    }