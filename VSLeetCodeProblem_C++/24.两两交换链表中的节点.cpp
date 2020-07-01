#define SWAPPAIRS

#ifdef SWAPPAIRS




/*
 * @lc app=leetcode.cn id=24 lang=cpp
 *
 * [24] 两两交换链表中的节点
 * 
 * Accepted
 * 55/55 cases passed (4 ms)
 * Your runtime beats 70.63 % of cpp submissions
 * Your memory usage beats 100 % of cpp submissions (6.4 MB)
 * 
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
		if(head == NULL ||head->next == NULL)
			return head;
		
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
			ListNode* firstNode = preNode->next;//获取交换的第一个节点

			if (firstNode->next == NULL) {
				return firstNode;
			}

			preNode->next = firstNode->next; //为上一轮交换后的第二个节点赋值

			ListNode* ptrPass = firstNode;  

			firstNode = firstNode->next;  //第一个节点指针的指向变成第二个节点

			ptrPass->next = firstNode->next;  //第一个节点的next第二个节点的next，也就是还没轮到交换的那一个指针

			firstNode->next = ptrPass; //第二个节点的下一个节点变成第一个节点

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