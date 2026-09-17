class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int p1 = 0;
        int p2 = 0;

        HashSet<Character> set = new HashSet<>();
        int ans = 0;

        while(p1 < n && p2 < n) {

            if(set.contains(s.charAt(p2))) {
                set.remove(s.charAt(p1));
                p1++;
                
            } else {
                set.add(s.charAt(p2));
                ans = Math.max(ans, (p2 - p1) + 1);
                 p2++;
            }
           
        }

        return ans;
    }
}