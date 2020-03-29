/*
 * @lc app=leetcode.cn id=69 lang=cpp
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (37.59%)
 * Likes:    336
 * Dislikes: 0
 * Total Accepted:    109.1K
 * Total Submissions: 290K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int mySqrt(int x) {
        if(x == 0)
            return 0;
        int left = 1, right = x;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
};
// @lc code=end

