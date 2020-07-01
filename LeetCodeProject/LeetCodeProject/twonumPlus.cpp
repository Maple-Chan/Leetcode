
//#define twoNumberPlus
#ifdef  twoNumberPlus

/*
ִ����ʱ :28 ms, ������ cpp �ύ�л�����87.66%���û�
�ڴ����� :10.3 MB, ������ cpp �ύ�л�����85.85%���û�
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
			�����б��������ݵ����
		*/
		while (NULL != cur1 && NULL != cur2)
		{	
			if(carry == 0  ) //�жϽ�λ
				newnum = cur1->val + cur2->val;
			else {
				newnum = cur1->val + cur2->val + carry;
				carry = 0;
			}

			//���������ڵ���10 ��Ҫ���н�λ
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
			ֻʣһ���б��������
		*/
		while (NULL != cur1)
		{
			if (carry == 0)//�жϽ�λ
				newnum = cur1->val;
			else {
				newnum = cur1->val + carry;

				//���������ڵ���10 ��Ҫ���н�λ����ͬ
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
			��������ƴ����ϣ��������н�λ�����Ʃ��1+99
		*/
		if (carry != 0) {
			curRet->next = new ListNode(carry);
		}

		return retlist;

	}

};


#endif //  twoNumberPlus