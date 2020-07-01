/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

 // @lc code=start

#include <string>
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
