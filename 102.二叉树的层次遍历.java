import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (61.04%)
 * Likes:    401
 * Dislikes: 0
 * Total Accepted:    86.5K
 * Total Submissions: 141.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
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


/* 
//iteration
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()){
            int size = list.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = list.poll();
                if(node.left != null)
                    list.offer(node.left);
                if(node.right != null)
                    list.offer(node.right);
                temp.add(node.val);
                    
            }    
            res.add(temp);
        }
        return res;

    }
} */

//recursion
class Solution {
    private ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return res;
        helper(root,0);
        return res;
    }
    private void helper(TreeNode node, int num){
        if(node == null)
            return;
        if(res.size() == num)
            res.add(new ArrayList<>());
        res.get(num).add(node.val);
        helper(node.left, num+1);
        helper(node.right, num+1);
    }
}
// @lc code=end

