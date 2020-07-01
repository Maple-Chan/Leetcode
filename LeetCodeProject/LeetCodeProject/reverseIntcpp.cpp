//#define reverseinteger
#ifdef reverseinteger

/*
 * @lc app=leetcode.cn id=7 lang=cpp
 *
 * [7] 整数反转
 */

/*

*/

#include<iostream>
#include<stack>
using namespace std;


 // @lc code=start
class Solution {
public:
	int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10; //余出来的模，每多一位会乘以10，也就把他放到了高位去了
			x /= 10;
			if (rev > INT_MAX / 10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
			if (rev < INT_MIN / 10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;

	}
};
// @lc code=end

int main() {
	int num;

	while (cin >> num) {
		Solution so;
		int ret = so.reverse(num);

		cout << ret << endl;
	}



	return 0;
}




#endif 