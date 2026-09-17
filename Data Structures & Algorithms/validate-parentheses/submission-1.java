class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
           
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else {
                if(st.size() == 0) return false;
                if(st.peek() == '(' && c == ')' || st.peek() == '{' && c == '}' || st.peek() == '[' && c == ']') st.pop();
                else return false;
            }
        }
        if(st.size() == 0) return true;
        return false;
    }
}