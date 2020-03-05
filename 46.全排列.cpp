/*
 * @lc app=leetcode.cn id=46 lang=cpp
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (74.23%)
 * Likes:    552
 * Dislikes: 0
 * Total Accepted:    83.8K
 * Total Submissions: 112.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        backtrack(res,nums,0,nums.size());
        return res;
    }

    void backtrack(vector<vector<int>> &res, vector<int>& nums, int first, int len){
    	if(first == len)
    		res.push_back(nums);
    	for(int i = first; i < len; i++){
    		swap(nums[i],nums[first]);
    		backtrack(res,nums,first+1,len);
    		swap(nums[i],nums[first]);
		}
	}
};
// @lc code=end

