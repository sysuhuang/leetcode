import java.util.*;


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
/* 
//recursion
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
} */

//iteration
class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                list.offer(root.val);
                sum -= root.val;
                root = root.left;              
            }
            TreeNode node = stack.peek();
            if(isleaf(node) && sum == 0)
                res.offer(new LinkedList<>(list));
            if(node.right == null || node.right == prev){
                stack.pop();
                list.pollLast();
                prev = node;
                sum += node.val;
            }
            else
                root = node.right;
        }
        return res;

    }

    private boolean isleaf(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
}
/* class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {  
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        //存储节点
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair<TreeNode, Integer>(root, sum - root.val));
        //存储路径
        Stack<List<Integer>> num_stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        num_stack.push(list);

        while ( !stack.isEmpty() ) {
            Pair<TreeNode, Integer> top = stack.pop();
            TreeNode node = top.getKey();
            int curr_sum = top.getValue();
            List<Integer> num_list = num_stack.pop();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                res.add(num_list);
            if (node.right != null) {
                stack.push(new Pair<TreeNode, Integer>(node.right, curr_sum - node.right.val));
                List<Integer> right_list = new ArrayList<>(num_list); //一定要重新拷贝一份再存入
                right_list.add(node.right.val);
                num_stack.push(right_list);
            }
            if (node.left != null) {
                stack.push(new Pair<TreeNode, Integer>(node.left, curr_sum - node.left.val));
                List<Integer> left_list = new ArrayList<>(num_list); //一定要重新拷贝一份再存入
                left_list.add(node.left.val);
                num_stack.push(left_list);
            }
        }
        return res;
    }
} */

// @lc code=end

