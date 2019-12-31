class Solution {
public:
    int maxProfit(vector<int>& prices) {
    	if(prices.empty())
    		return 0;
        int len = prices.size();
        int minprice = prices[0];
        int profit = 0;
        for(int i = 1; i < len; i++){
        	int temp = prices[i] - minprice;
        	if(temp > profit)
        		profit = temp;
        	if(prices[i] < minprice)
        		minprice = prices[i];
        	  	
		}
		return profit;
    }
};
