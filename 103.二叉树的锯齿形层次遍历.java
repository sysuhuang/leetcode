import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (53.71%)
 * Likes:    159
 * Dislikes: 0
 * Total Accepted:    35.5K
 * Total Submissions: 66K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Boolean flag = true;
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
            if(flag)
                res.add(temp);
            else{
                
                Collections.reverse(temp);
                res.add(temp);
            }
            flag = !flag;
                

        }
        return res;
    }
}
// @lc code=end

