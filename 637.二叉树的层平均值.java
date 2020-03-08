import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 *
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (63.26%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    14.4K
 * Total Submissions: 22.7K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 
 * 
 * 注意：
 * 
 * 
 * 节点值的范围在32位有符号整数范围内。
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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<Double>();
        if(root == null)
            return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()){
            double sum = 0;
            int size = list.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = list.poll();
                if(node.left != null)
                    list.offer(node.left);
                if(node.right != null)
                    list.offer(node.right);
                sum += node.val; 
                    
            }    
            res.add(sum/size);
        }
        return res;
    }
}
// @lc code=end

