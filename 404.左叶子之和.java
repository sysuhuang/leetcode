import java.util.Stack;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (53.84%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    19.5K
 * Total Submissions: 35.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
 * 
 * 
 */

// @lc code=start
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    int value = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,false);
        return value;
    }
    void helper(TreeNode node, boolean flag){
        if(node == null)
            return;
        if(isleaf(node)&&flag)
            value += node.val;
        helper(node.left, true);
        helper(node.right,false);


    }
    boolean isleaf(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
}
// @lc code=end

