//#define Zconvert
#ifdef Zconvert


/*
 * @lc app=leetcode.cn id=6 lang=cpp
 *
 * ��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�

 * ���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�

	L   C   I   R
	E T O E S I I G
	E   D   H   N

	֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��

	����ʵ��������ַ�������ָ�������任�ĺ�����

 * [6] Z ���α任
 */


 /*
 1158/1158 cases passed (16 ms)
Your runtime beats 72.09 % of cpp submissions
Your memory usage beats 76.41 % of cpp submissions (12.8 MB)
 */

 // @lc code=start
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
	string convert(string s, int numRows) {
		/*
			numRows�У��м���numRows-2��
		*/
		vector<string> lines(numRows,"");
	
		if (1 == numRows || "" ==s || numRows >= s.length()) {
			return s;
		}

		int pushRow = 0;
		bool updown = true; //false�����½�
		for (char c : s) {
			lines[pushRow] += c;
			
			if (pushRow == numRows - 1 || pushRow == 0) {
				updown = !updown;

			}
			if (!updown)// �½�����
			{
				pushRow += 1;
			}
			else {
				pushRow -= 1;
			}

		}
		string retStr = "";
		for (string str : lines) {
			retStr += str;
		}


		return retStr;

	}
};




int main() {
	string sentence;
	while (cin >> sentence) {
		int num;
		cin >> num;

		Solution so;
		cout << so.convert(sentence, num) << endl;

		

	}



	return 0;
}




// @lc code=end








#endif //Zconvert