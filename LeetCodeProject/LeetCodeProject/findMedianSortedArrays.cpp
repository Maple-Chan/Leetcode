/*
 * @lc app=leetcode.cn id=4 lang=cpp
 *
 * [4] 寻找两个有序数组的中位数
 */

/*
2085/2085 cases passed (48 ms)
Your runtime beats 9.77 % of cpp submissions
Your memory usage beats 72.97 % of cpp submissions (10.6 MB)
*/
//#define findMedian
#ifdef findMedian

 // @lc code=start
#include <vector> 
#include <iostream>
using namespace std;

class Solution {
public:
	double findMedianSortedArrays(std::vector<int>& nums1, std::vector<int>& nums2) {
		//首先先进行归并排序
		size_t len1 = nums1.size();
		size_t len2 = nums2.size();
		size_t len = len1 + len2;
		std::vector<int> newarry;

		int pass1 = 0 , pass2 = 0;
		
		for (int i = 0; i < len; ++i) {
			if (pass1 < len1 && pass2 < len2) {
				if (nums1.at(pass1) <= nums2.at(pass2)) {
					newarry.push_back(nums1.at(pass1));
					pass1++;
				}
				else if (nums1.at(pass1) > nums2.at(pass2)) {
					newarry.push_back(nums2.at(pass2));
					pass2++;
				}
			}
			else if(pass1 < len1 && pass2 >= len2){
				newarry.push_back(nums1.at(pass1));
				pass1++;
			}
			else if(pass2 < len2 && pass1 >= len1){
				newarry.push_back(nums2.at(pass2));
				pass2++;
			}
		}

		if (len % 2) {

			return newarry.at(len / 2);
		}
		else {//偶数
			return (newarry.at(len / 2 -1) + newarry.at(len / 2 )) / (double)2;
		}
		return -1;
	}
};
// @lc code=end



int main() {
	std::vector<int> nums1;
	std::vector<int> nums2;
	//nums1.push_back(2);
	//nums1.push_back(3);
	nums2.push_back(1);
	nums2.push_back(4);
	nums2.push_back(6);

	Solution so;
	double medium = so.findMedianSortedArrays(nums1, nums2);
	
	cout << medium << endl;

	return 0;
}


#endif // findMedian
