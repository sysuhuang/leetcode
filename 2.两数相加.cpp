/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (36.79%)
 * Likes:    3993
 * Dislikes: 0
 * Total Accepted:    343.5K
 * Total Submissions: 933.7K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode *p1 = l1;
		ListNode *p2 = l2;
		ListNode *start = new ListNode(0);
		ListNode *current = start;
		int flag = 0;
		while (p1 != NULL || p2 != NULL) {
			int val1 = p1 == NULL ? 0 : p1->val;
			int val2 = p2 == NULL ? 0 : p2->val;
			int sum = val1 + val2 + flag;
			flag = sum > 9 ? 1 : 0;
			sum = sum - flag * 10;
			ListNode *temp = new ListNode(sum);
			current->next = temp;
			current = temp;
			if(p1)
				p1 = p1->next;
			if(p2)
				p2 = p2->next;
		}
		if (flag == 1) {
			ListNode *temp = new ListNode(1);
			current->next = temp;
		}
		return start->next;
	}
};
// @lc code=end

