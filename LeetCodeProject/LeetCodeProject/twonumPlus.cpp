
//#define twoNumberPlus
#ifdef  twoNumberPlus

/*
执行用时 :28 ms, 在所有 cpp 提交中击败了87.66%的用户
内存消耗 :10.3 MB, 在所有 cpp 提交中击败了85.85%的用户
*/
#include<iostream> 
#include<vector>

using namespace std;

 //Definition for singly-linked list.
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode *retlist = NULL;
		ListNode *newNode = NULL;

		ListNode *cur1 = l1;
		ListNode *cur2 = l2;
		ListNode *curRet = retlist;
		int newnum = 0,carry = 0;

		/*
			build the first node
		*/

		newnum = cur1->val + cur2->val;
		if (newnum >= 10) {
			carry = newnum / 10;
			newnum = newnum % 10;
		}

		retlist = new ListNode(newnum);
		curRet = retlist;

		cur1 = cur1->next;
		cur2 = cur2->next;

		/*
			两个列表都还有数据的情况
		*/
		while (NULL != cur1 && NULL != cur2)
		{	
			if(carry == 0  ) //判断进位
				newnum = cur1->val + cur2->val;
			else {
				newnum = cur1->val + cur2->val + carry;
				carry = 0;
			}

			//如果结果大于等于10 需要进行进位
			if (newnum >= 10) {
				carry = newnum / 10;
				newnum = newnum % 10;
			}
			else {
				carry = 0;
			}
			
			newNode = new ListNode(newnum);
			curRet->next = newNode;
			curRet = newNode;

			cur1 = cur1->next;
			cur2 = cur2->next;
		}

		/*
			只剩一个列表、两种情况
		*/
		while (NULL != cur1)
		{
			if (carry == 0)//判断进位
				newnum = cur1->val;
			else {
				newnum = cur1->val + carry;

				//如果结果大于等于10 需要进行进位，下同
				if (newnum >= 10) {
					carry = newnum / 10;
					newnum = newnum % 10;
				}
				else {
					carry = 0;
				}
			}
			newNode = new ListNode(newnum);
			curRet->next = newNode;
			curRet = newNode;

			cur1 = cur1->next;
		}

		while (NULL != cur2)
		{
			if (carry == 0)
				newnum = cur2->val;
			else {
				newnum = cur2->val + carry;
				if (newnum >= 10) {
					carry = newnum / 10;
					newnum = newnum % 10;
				}
				else {
					carry = 0;
				}
			}

			newNode = new ListNode(newnum);
			curRet->next = newNode;
			curRet = newNode;

			cur2 = cur2->next;
		}

		/* 
			所有数据拼接完毕，但是仍有进位的情况譬如1+99
		*/
		if (carry != 0) {
			curRet->next = new ListNode(carry);
		}

		return retlist;

	}

};


#endif //  twoNumberPlus