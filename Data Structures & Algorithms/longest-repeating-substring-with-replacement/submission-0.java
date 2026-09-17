class Solution { 
    public int characterReplacement(String s, int k) { 
        int temp = k; 
        int st = 0; 
 
        char maxi = s.charAt(0); 
 
        int ans = 0; 
 
        HashMap<Character, Integer> map = new HashMap<>(); 
 
        for(int i = 0; i < s.length();) { 
            char ch = s.charAt(i); 
            k = temp; 
             
            st = i; 
            
            while(i < s.length()) { 
                ch = s.charAt(i); 
                map.put(ch, map.getOrDefault(ch, 0) + 1); 
                 
                if(map.get(ch) > map.getOrDefault(maxi, 0)) { 
                    maxi = ch; 
                } 
 
                if((i - st + 1) - map.get(maxi) > k) {
                    map.put(s.charAt(st), map.get(s.charAt(st)) - 1);
                    st++;
                    
                }
  
                ans = Math.max(ans, i - st + 1); 
                i++; 
                 
            } 
            map.clear(); 
        } 
 
        return ans; 
    } 
}