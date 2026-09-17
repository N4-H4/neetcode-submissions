class Solution { 
    boolean check(HashMap<Character, Integer> mapS, HashMap<Character, Integer> mapT) { 
        for(char ch : mapT.keySet()) { 
            if(mapS.getOrDefault(ch, 0) < mapT.get(ch)) { 
                return false; 
            } 
        } 
        return true; 
    } 
 
    public String minWindow(String s, String t) {  
        String ans = "";  
        int minLen = Integer.MAX_VALUE;  
        int m = s.length();  
        int n = t.length();  
  
        if(m < n) return "";  
  
        HashMap<Character, Integer> mapT = new HashMap<>();  
  
        for(int i = 0; i < n; i++) {  
            char ch = t.charAt(i);  
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);  
        }         
  
        HashMap<Character, Integer> mapS = new HashMap<>();  
  
        int st = 0;  
  
        for(int end = 0; end < m; end++) {  
            
            char ch = s.charAt(end);  
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);  

            while(check(mapS, mapT)) {  
                
                int len = end - st + 1;  
                
                if(len < minLen) {  
                    ans = s.substring(st, end + 1);  
                    minLen = len;  
                }  

                char left = s.charAt(st);  
                mapS.put(left, mapS.get(left) - 1);  

                if(mapS.get(left) == 0) {  
                    mapS.remove(left);  
                }  

                st++;  
            }  
        } 
  
        return ans;  
    } 
}