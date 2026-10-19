class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> seen = new HashSet<>();

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>(List.of(i)));
            else {
                List l = map.get(nums[i]);

                l.add(i);
            }
        }

        for(int i = 0; i < n; i++) {
            int num1 = nums[i];

            for(int j = i + 1; j < n; j++) {
                if(i != j) {
                    int num2 = nums[j];
                    int sum = num1 + num2;
                    int req = -(sum);

                    if(map.containsKey(req)) {
                        List<Integer> lis = map.get(req);


                        for(int idx : lis) {
                            if((idx != i && idx != j)) {
                                List<Integer> trip = new ArrayList<>(Arrays.asList(num1, num2, nums[idx]));

                            Collections.sort(trip);

                            if(seen.add(trip)) {
                                ans.add(trip);
                            }
                            break;
                        }

                    }
                }
            }
        }
        }
        return ans;
    }
}
