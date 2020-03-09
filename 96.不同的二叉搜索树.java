/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (65.08%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    32.8K
 * Total Submissions: 50.4K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int []arr = new int[n+1];
        arr[0] = arr[1] = 1;
        for(int i = 2; i < n+1; i++){
            int temp = 0;
            for(int j = 0; j < i; j++){
                temp += arr[j] * arr[i-1-j];
            }
            arr[i] = temp;
        }
        return arr[n];

    }
}
// @lc code=end

