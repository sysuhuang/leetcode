/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (33.16%)
 * Likes:    3249
 * Dislikes: 0
 * Total Accepted:    370.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	HashMap<Character,Integer> map = new HashMap<>();
    	int left = 0;
    	int max = 0;
    	for(int i = 0;i < s.length();i++) {
    		if(map.containsKey(s.charAt(i))) {
    			left = Math.max((map.get(s.charAt(i)))+1, left);
    		}
    		max = Math.max(i - left + 1, max);
    		map.put(s.charAt(i), i);
    	}
    	return max;
    }
}
// @lc code=end

