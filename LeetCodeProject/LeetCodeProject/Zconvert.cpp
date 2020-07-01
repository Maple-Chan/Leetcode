//#define Zconvert
#ifdef Zconvert


/*
 * @lc app=leetcode.cn id=6 lang=cpp
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

	L   C   I   R
	E T O E S I I G
	E   D   H   N

	之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

	请你实现这个将字符串进行指定行数变换的函数：

 * [6] Z 字形变换
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
			numRows行，中间有numRows-2个
		*/
		vector<string> lines(numRows,"");
	
		if (1 == numRows || "" ==s || numRows >= s.length()) {
			return s;
		}

		int pushRow = 0;
		bool updown = true; //false代表下降
		for (char c : s) {
			lines[pushRow] += c;
			
			if (pushRow == numRows - 1 || pushRow == 0) {
				updown = !updown;

			}
			if (!updown)// 下降过程
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