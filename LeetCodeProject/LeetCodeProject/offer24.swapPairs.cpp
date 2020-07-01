#define SWAPPAIRS

#ifdef SWAPPAIRS




/*
 * @lc app=leetcode.cn id=24 lang=cpp
 *
 * [24] 两两交换链表中的节点
 */
#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

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
	ListNode* swapPairs(ListNode* head) {

		/*交换前两个节点*/
		ListNode* ptrPass = head;

		head = head->next;

		ptrPass->next = head->next;

		head->next = ptrPass;

		/*交换有前节点的两个节点*/

		ptrPass->next = swapPairsCore(ptrPass);


		return head;

	}

	ListNode* swapPairsCore(ListNode* preNode) {

		if (preNode->next != NULL) {
			ListNode* firstNode = preNode->next;

			if (firstNode->next == NULL) {
				return firstNode;
			}

			preNode->next = firstNode->next;

			ListNode* ptrPass = firstNode;

			firstNode = firstNode->next;

			ptrPass->next = firstNode->next;

			firstNode->next = ptrPass;

			ptrPass->next = swapPairsCore(ptrPass);
			
				

			return firstNode;
		}
		return NULL;


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

	head = so.swapPairs(head);

	so.disPlayList(head);

	system("pause");

	return 0;
}

#endif // SWAPPAIRS