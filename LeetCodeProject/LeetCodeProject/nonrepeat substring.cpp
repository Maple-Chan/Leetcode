//#define nonrepeat_substring 
#ifdef nonrepeat_substring
/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] ���ظ��ַ�����Ӵ�
 */

 // @lc code=start
/*
ִ����ʱ :112 ms, ������ cpp �ύ�л�����14.92%���û�
�ڴ����� :22.1 MB, ������ cpp �ύ�л�����14.00%���û�
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
			����˼·��
				���������
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
