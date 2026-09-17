class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int st = 0;
        int end = n - 1;

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = st; i <= end; i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        if(map2.equals(map1)) return true;
        st++;
        end++;

        while(end < m) {
            char ch1 = s2.charAt(end);
            char ch2 = s2.charAt(st - 1);
            map2.put(ch1, map2.getOrDefault(ch1, 0) + 1);
            

            if(map2.containsKey(ch2)) {
                map2.put(ch2, map2.get(ch2) - 1);

                if(map2.get(ch2) == 0) {
                    map2.remove(ch2);
                }
            }

            if(map2.equals(map1)) return true;

            st++;
            end++;
        }

        return false;
    }
}