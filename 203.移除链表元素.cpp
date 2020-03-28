#include<iostream>
/*
 * @lc app=leetcode.cn id=203 lang=cpp
 *
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (44.32%)
 * Likes:    358
 * Dislikes: 0
 * Total Accepted:    67.1K
 * Total Submissions: 150K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * 
 * 
 */

// @lc code=start

/* struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
}; */


class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {      
        ListNode *first = new ListNode(0);
        first->next = head;
        ListNode *prev = first;
        ListNode *todelete = nullptr;
        ListNode *cur = head;
        while(cur){
            if(cur->val == val){
                todelete = cur;
                prev->next = cur->next; 


            }
            else
                prev = cur;
            cur = cur->next; 
            if(todelete){
                delete todelete;
                todelete = nullptr;
            }
    

        } 
        return first->next;
    }
};
// @lc code=end

