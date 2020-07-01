//#define LongestPalindrome
#ifdef LongestPalindrome

/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */
/*
执行用时 :108 ms, 在所有 cpp 提交中击败了51.82%的用户
内存消耗 :9.8 MB, 在所有 cpp 提交中击败了65.89%的用户
*/
#include <iostream>
#include <string>
using namespace std;

 // @lc code=start
class Solution {
public:
	string longestPalindrome(string s) {
		bool DP[1000][1000] = {0}; //需要对数组进行初始化，不然的话提交不通过。
		size_t len = s.size();
		int max = 1,startIndex=0;

		if ("" == s || 1 == len) {//处理输入小于等于1个字符的情况
			return s;
		}
		for (int i = 0; i < len; ++i) {
			DP[i][i] = 1;

			if (i < len - 1 && s[i] == s[i + 1]) {//设置两个字符长度的回文
				DP[i][i + 1] = 1;
				max = 2;
				startIndex = i;
			}

		}

		for (int l = 3; l <= len; ++l) { //从三个长度的数据开始寻找更长的
			if (l == 7)
				cout << "aaabaaa";

			for (int i = 0; i + l -1 < len; ++i) {
				int j = i + l - 1;

				if (s[i] == s[j] && DP[i + 1][j - 1] == 1) {// 判断首尾和首尾靠内的那两个数据是不是都相同
					DP[i][j] = 1;
					max = l;
					startIndex = i;
				}
			}
		}
		return s.substr(startIndex, max);

	}


};
// @lc code=end


int main() {

	string s;
	cin >> s;
	Solution so;
	cout << so.longestPalindrome(s) << endl;


	return 0;
}



#endif // LongestPalindrome