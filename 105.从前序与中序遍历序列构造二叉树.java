import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.27%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    50.7K
 * Total Submissions: 78.5K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

    return helper(preorder,inorder);
    }

    public TreeNode helper(int[] preorder, int[] inorder){
        if(preorder.length == 0)
            return null;
        int pre = preorder[0];
        int index = 0;
        if(map.containsKey(pre))
            index = map.get(pre);
        else
            index = inorder.length;
        


        TreeNode node = new TreeNode(pre);   


        node.left = helper(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = helper(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));
        return  node;
    }

}
 */
class Solution {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private int [] preorder;
    private int [] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for (Integer val : inorder)
          map.put(val, idx++);
        return helper(0,preorder.length,0,inorder.length);     
    }

    public TreeNode helper(int pre_index, int pre_index2, int in_index, int in_index2){
        if(pre_index == pre_index2 && in_index == in_index2)
            return null;
            
        int value = preorder[pre_index];
        TreeNode node = new TreeNode(value);
        int index = map.get(value);
        node.left = helper(pre_index+1, pre_index+1+index-in_index, in_index, index);
        node.right = helper(pre_index+1+index-in_index, pre_index2, index+1, in_index2);
        return node;
    }
}
// @lc code=end

