class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    HashMap<String, ArrayList<Integer>> times;

    public TimeMap() {
        this.map = new HashMap<>();
        this.times = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> inner = map.getOrDefault(key, new HashMap());
        
        inner.put(timestamp, value);
        map.put(key, inner);

        ArrayList<Integer> list = times.getOrDefault(key, new ArrayList<>());
        list.add(timestamp);
        times.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        HashMap<Integer, String> inner = map.get(key);

        if(inner == null) {
            return "";
        }

        ArrayList<Integer> list = times.get(key);

        int st = 0;
        int end = list.size() - 1;

        int ans = -1;

        while(st <= end) {
            int mid = (st + end) / 2;

            if(list.get(mid) <= timestamp) {
                ans = list.get(mid);
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if(ans != -1) return inner.get(ans);
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */