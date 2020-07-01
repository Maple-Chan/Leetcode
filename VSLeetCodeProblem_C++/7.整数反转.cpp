/*
 * @lc app=leetcode.cn id=7 lang=cpp
 *
 * [7] 整数反转
 */

// @lc code=start


#include <iostream>
#include <string>
using namespace std;


class Solution {
public:
	int myAtoi(string str) {
		size_t size = str.size();
		string nums = "";
		bool sign;
		
		long retnum = 0;
		for (char c : str) {
			
			if (' ' == c && nums == "") {
				continue;
			}
			if (('-' != c && '+' != c) && c < 0x30 || c>0x39 ) {
				break;
			}
			
			nums += c;
		}
		if ("" != nums) {

			retnum = atol(nums.c_str());
			if (retnum > INT_MAX ) {
				retnum = INT_MAX;
			}
			if (retnum < INT_MIN) {
				retnum = INT_MIN;

			}
		}

		//if (!sign) {
		//	retnum = -retnum;
		//}
		
		return retnum;
	}
};


int main() {

	string str;
	Solution so;
	//cin.getline(str,2000);
	while (getline(cin,str)) {

		int num = so.myAtoi(str);

		cout << num << endl;
	}






	return 0;
}
// @lc code=end

