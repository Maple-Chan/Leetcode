#define my_atoi

#ifdef my_atoi

/*
执行用时 :8 ms, 在所有 cpp 提交中击败了68.16%的用户
内存消耗 :8.5 MB, 在所有 cpp 提交中击败了78.08%的用户
*/
/*

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
*/


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



#endif // my_atoi
