import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (58.93%)
 * Likes:    176
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 56.9K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        helper(root,sum);
        return res;
    }
    private void helper(TreeNode node, int sum){
        if(node == null)
            return;
        list.offer(node.val);
        if(sum == node.val && isleaf(node)){
            res.offer(new LinkedList<>(list));
        }
        helper(node.left, sum - node.val);
        helper(node.right, sum - node.val);
        list.pollLast();
            
        
    }
    private boolean isleaf(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
}
// @lc code=end

