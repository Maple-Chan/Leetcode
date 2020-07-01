//#define LongestPalindrome
#ifdef LongestPalindrome

/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] ������Ӵ�
 */
/*
ִ����ʱ :108 ms, ������ cpp �ύ�л�����51.82%���û�
�ڴ����� :9.8 MB, ������ cpp �ύ�л�����65.89%���û�
*/
#include <iostream>
#include <string>
using namespace std;

 // @lc code=start
class Solution {
public:
	string longestPalindrome(string s) {
		bool DP[1000][1000] = {0}; //��Ҫ��������г�ʼ������Ȼ�Ļ��ύ��ͨ����
		size_t len = s.size();
		int max = 1,startIndex=0;

		if ("" == s || 1 == len) {//��������С�ڵ���1���ַ������
			return s;
		}
		for (int i = 0; i < len; ++i) {
			DP[i][i] = 1;

			if (i < len - 1 && s[i] == s[i + 1]) {//���������ַ����ȵĻ���
				DP[i][i + 1] = 1;
				max = 2;
				startIndex = i;
			}

		}

		for (int l = 3; l <= len; ++l) { //���������ȵ����ݿ�ʼѰ�Ҹ�����
			if (l == 7)
				cout << "aaabaaa";

			for (int i = 0; i + l -1 < len; ++i) {
				int j = i + l - 1;

				if (s[i] == s[j] && DP[i + 1][j - 1] == 1) {// �ж���β����β���ڵ������������ǲ��Ƕ���ͬ
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