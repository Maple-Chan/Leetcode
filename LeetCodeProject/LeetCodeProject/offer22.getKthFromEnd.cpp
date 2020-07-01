//#define REMOVENTHFROMEND

#ifdef REMOVENTHFROMEND




/*
 * @lc app=leetcode.cn id=19 lang=cpp
 *
 * [19] ɾ������ĵ�����N���ڵ�
 *
 * ɾ��������N���ڵ���ҵ�������N���ڵ㲻ͬ��ɾ����Ҫ��ȡĿ��ڵ����һ���ڵ㡣
 */

#include <iostream>
#include <vector>
using namespace std;

/* * Definition for singly-linked list. */
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};
// @lc code=start




class Solution {
public:
	ListNode* removeNthFromEnd(ListNode* head, int n) {
		if (head == NULL) {
			return NULL;
		}
		/*
			��������n��������ĳ���
		*/

		ListNode* ptrPass = head;

		ListNode* preTarget = ptrPass;

		int countPass = n;
		while (ptrPass->next != NULL && countPass != 0)
		{
			ptrPass = ptrPass->next;
			countPass--;
		}

		if (countPass > 1) {
			cout << "n larger than the length of the list" << endl;
			return NULL;
		}

		if (countPass == 1) {
			ListNode* deleteHead = head;

			head = head->next;

			delete deleteHead;

			deleteHead = NULL;

			return head;
		}


		preTarget = head;
		while (ptrPass->next != NULL)
		{
			/* code */
			preTarget = preTarget->next;
			ptrPass = ptrPass->next;

		}

		cout << "find the pointer before the target :" << preTarget->val << endl;

		// ִ��ɾ��

		ListNode* toBeDeleteNode = preTarget->next;

		preTarget->next = toBeDeleteNode->next;

		delete toBeDeleteNode;
		toBeDeleteNode = NULL;

		return head;

	}

	void disPlayList(ListNode* head) {
		ListNode* ptrPass = head;
		cout << ptrPass->val << " ";

		while (ptrPass->next != NULL)
		{
			ptrPass = ptrPass->next;
			cout << ptrPass->val << " ";
		}

		cout << endl;
	}


	ListNode* createList(vector<int> vec) {
		if (vec.empty()) {
			return nullptr;
		}

		size_t sizevec = vec.size();
		int passData = 0;
		ListNode* Head = new ListNode(vec[passData]);
		ListNode* curptr = Head;
		passData++;


		ListNode* newNode = nullptr;
		while (passData < sizevec)
		{
			/* code */
			newNode = new ListNode(vec[passData]);
			curptr->next = newNode;
			curptr = newNode;
			passData++;
		}
		return Head;
	}
};
// @lc code=end


int main() {

	vector<int> nums = { 1,2,3,4,5,6,7 };

	Solution so;

	ListNode* head;

	head = so.createList(nums);

	so.disPlayList(head);

	head = so.removeNthFromEnd(head, 7);

	so.disPlayList(head);

	system("pause");
	return 0;
}

#endif // REMOVENTHFROMEND