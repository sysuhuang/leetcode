class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> res;
		int len = nums.size();
		map<int, int> need;
		for (int i = 0; i < len; i++) {
			int number = target - nums[i];
			if (need.find(number)==need.end())
				need[nums[i]] = i;
			else {
				res.push_back(i);
				res.push_back(need[number]);
				return res;
			}
		}
		return res;
	}
};

