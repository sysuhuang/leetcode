import java.util.*;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (70.42%)
 * Likes:    415
 * Dislikes: 0
 * Total Accepted:    114.8K
 * Total Submissions: 162.9K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}

/* //recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        helper(root,list);
        return list;
    }
    public void helper(TreeNode node, ArrayList<Integer> list){
        if(node == null)
            return;
        helper(node.left,list);
        list.add(node.val);
        helper(node.right, list);

    }
} */
/* //recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return list;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.right != null)
                stack.push(node.right);
            list.add(node.val);
            if(node.left != null)
                stack.push(node.left);
        }
        return list;
    }
}
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return list;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop(); 
            list.add(node.val);
            cur = node.right;

        }
        return list;


    }

}

// @lc code=end

