class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int st = 0;

        for(int i = 0; i < n; i++) { 
            char key = s.charAt(i); 
            map.put(key, map.getOrDefault(key, 0) + 1); 
 
            while(map.get(key) > 1) { 
                char ch = s.charAt(st);
                map.put(ch, map.get(ch) - 1); 
                st++; 
            } 
            
            ans = Math.max(ans, i - st + 1); 
        } 

        return ans;
    }
}