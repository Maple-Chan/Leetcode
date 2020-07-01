
//#define RECONSTRUCTTREE

#ifdef RECONSTRUCTTREE


/**
 * Definition for binary tree
 *
 * */

#include <vector>
#include <exception>
#include <iostream>
using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};



class Solution {
public:
	/*
	* 1 2 4 7 3 5 6 8
	* 4 7 2 1 5 3 8 6
	*
	*/
	TreeNode* reConstructBinaryTree(const vector<int> &pre, const vector<int> &vin) {

		//输入参数判断
		if (pre.size() < 0 || vin.size() < 0 || pre.size() != vin.size()) {
			return nullptr;
		}

		// 
		size_t size = pre.size();
		TreeNode* root = ConstructCore(pre, 0, size - 1, vin, 0, size -1);

		return root;



	}
	/**
	 * 
	 *
	*/
	TreeNode* ConstructCore(const vector<int> &pre, size_t beginPre, size_t endPre,
		const vector<int> & vin, size_t beginVin, size_t endVin)
	{
		if (beginPre > endPre || beginVin > endVin) {
			return nullptr;
		}

		TreeNode* root = new TreeNode(pre[beginPre]);
		root->left = root->right = nullptr;

		if (beginPre == endPre) {
			if (beginVin == endVin && pre[beginPre] == vin[beginVin]) {
				cout << root->val << endl;
				return root;
			}
			else
			{
				cout << "Invalid Input" << endl;
				return nullptr;
			}

		}


		size_t rootIndexVin = beginVin;

		for (int passData = beginVin; passData <= endVin; ++passData)
		{
			if (vin[passData] == pre[beginPre]) {
				rootIndexVin = passData;
				break;
			}
		}

		int leftLength = rootIndexVin - beginVin;
		int rigthLength = endVin - rootIndexVin;

		if (leftLength > 0) {
			root->left = ConstructCore(
				pre, beginPre + 1, leftLength + beginPre,
				vin, beginVin, rootIndexVin - 1
			);
		}
		if (rigthLength > 0 ) {

			root->right = ConstructCore(
				pre, endPre - rigthLength + 1, endPre,
				vin, rootIndexVin + 1, endVin
			);
		}


		return root;
	}


};


int main() {

	vector<int> pre= { 1, 2, 4, 7, 3, 5, 6, 8 };
	vector<int> vin= { 4, 7, 2, 1, 5, 3, 8, 6 };


	Solution so;
	TreeNode* head = so.reConstructBinaryTree(pre,vin);

	return 0;
}



#endif // RECONSTRUCTTREE
