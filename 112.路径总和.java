import java.util.Stack;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (49.16%)
 * Likes:    251
 * Dislikes: 0
 * Total Accepted:    56.5K
 * Total Submissions: 114.9K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \      \
 * ⁠       7    2      1
 * 
 * 
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        Stack<TreeNode> node_stack = new Stack<>();
        Stack<Integer> num_stack = new Stack<>();
        node_stack.push(root);
        num_stack.push(sum - root.val);
        while(!node_stack.isEmpty()){
            TreeNode node = node_stack.pop();
            int num = num_stack.pop();
            if(num == 0 && isleaf(node))
                return true;
            if(node.left != null){
                node_stack.push(node.left);
                num_stack.push(num - node.left.val);
            }
            if(node.right != null){
                node_stack.push(node.right);
                num_stack.push(num - node.right.val);
            }
        }
        return false;

        
    }
    private boolean isleaf(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        return false;
    }

}
// @lc code=end

