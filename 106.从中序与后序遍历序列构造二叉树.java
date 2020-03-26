import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (66.97%)
 * Likes:    175
 * Dislikes: 0
 * Total Accepted:    28.8K
 * Total Submissions: 42.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int [] inorder;
    private int [] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int idx = 0;
        for (Integer val : inorder)
          map.put(val, idx++);
        return helper(0,inorder.length-1,0,postorder.length-1);     
    }

    public TreeNode helper(int in_index, int in_index2, int post_index, int post_index2){
        if(post_index > post_index2 && in_index > in_index2)
            return null;         
        int value = postorder[post_index2];
        TreeNode node = new TreeNode(value);
        int index = map.get(value);
        node.left = helper(in_index, index-1, post_index,post_index+index-in_index-1);
        node.right = helper(index+1,in_index2, post_index+index-in_index, post_index2-1);
        return node;
    }
}
// @lc code=end

