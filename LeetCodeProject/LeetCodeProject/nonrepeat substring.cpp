//#define nonrepeat_substring 
#ifdef nonrepeat_substring
/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

 // @lc code=start
/*
执行用时 :112 ms, 在所有 cpp 提交中击败了14.92%的用户
内存消耗 :22.1 MB, 在所有 cpp 提交中击败了14.00%的用户
*/
#include<iostream>
#include <vector>
#include<string>
using namespace std;

class Solution
{
public:
	int max = 1;
	int lengthOfLongestSubstring(string s)
	{
		if (0 == s.size()) {
			return 0;
		}
		/*
			解题思路：
				暴力，如果
		*/
		int length = 1;
		int index = 0;
		for (index; index < s.size();)
		{
			if (index + length > s.size()) {
				return max;
			}
			string subs = s.substr(index, length);
			bool isAllUniq = isUnique(subs);

			if (isAllUniq)
			{
				max = length++;
			}
			else
			{
				index++;
			}

		}

		return max;
	}

	bool isUnique(string subs)
	{
		if (1 == subs.size())
		{
			return true;
		}

		string::iterator it;
		string::iterator pass;
		for (it = subs.begin(); it != (subs.end() - 1); ++it)
		{
			for (pass = it + 1; pass != subs.end(); ++pass)
			{
				cout << *it << ":" << (*pass);
				if ((*it) == (*pass))
				{
					return false;
				}
			}
		}
		return true;
	}
};
// @lc code=end


int main() {
	string s;
	cin >> s;
	Solution so;
	int len = so.lengthOfLongestSubstring(s);
	cout << len;

	return 0;
}



#endif // nonrepeat_substring
