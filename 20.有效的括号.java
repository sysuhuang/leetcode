import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (41.01%)
 * Likes:    1424
 * Dislikes: 0
 * Total Accepted:    220K
 * Total Submissions: 535.9K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(stack.isEmpty())
                stack.push(s.charAt(i));
            else{
                char top = stack.peek();
                if(ismatch(top,s.charAt(i)))
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }           
        }
        return stack.isEmpty();
    }

    private Boolean ismatch(Character a, Character b){
        if((a == '(' && b == ')') || (a == '[') && (b == ']') || (a == '{' && b == '}'))
            return true;
        return false;
    }
}
// @lc code=end

