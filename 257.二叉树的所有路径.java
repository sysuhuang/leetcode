import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (62.47%)
 * Likes:    218
 * Dislikes: 0
 * Total Accepted:    27.5K
 * Total Submissions: 43.9K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
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
    private ArrayList<String> res = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return res;
        list.offer(root.val);
        if(isleaf(root)){
            StringBuilder str = new StringBuilder("");
            for(int i = 0; i < list.size()-1; i++){
                str.insert(str.length(),(list.get(i)+"->"));
            }
            str.insert(str.length(),list.get(list.size()-1));
            res.add(str.toString());
        }
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);
        list.pollLast();
        return res;
            
        
    }
    private boolean isleaf(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
}
// @lc code=end

