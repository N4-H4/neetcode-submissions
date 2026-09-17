class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        
        int sell = 1;
        int buy = 0;
        int ans = 0;

        while(sell < n) {
            if(prices[sell] > prices[buy]) {
                ans = max(ans, prices[sell] - prices[buy]);
            }
            else {
                buy = sell;
            }

            sell++;
        }

        return ans;
    }
};
