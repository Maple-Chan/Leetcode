
//#define POW_X_N

#ifdef POW_X_N

/*
 * @lc app=leetcode.cn id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */

 // @lc code=start


 /**
  * 采用 >> 1 的方式，减少运行时间
  *
 */

#include <iostream>
using namespace std;

class DivZeroException {

	const char* what() {
		return "Math Error, /0";
	}
};


class Solution {
public:
	double myPow(double x, int n) {

		double result = 1.0;
		if (n < 0 && x - 0.0 < 0.0005f && x - 0.0 > -0.0000f) {
			throw DivZeroException();
		}

		if (n == INT_MIN) {
			//避免 INT_MIN 的相反数越界的问题

			++n;
			n = -n;

			// 后边又乘了两个x是因为上边的abs(n) 本来应该是偶数的，但是自己做了处理后相当于少了2个x
			result *= myPow(x*x, abs(n) / 2) *x * x;

			return 1.0 / result;
		}

		if (n < 0) {
			//需要算倒数
			unsigned int absEx = (unsigned int)(-n);
			result = this->unsignedPow(x, absEx);
			result = 1 / result;
		}
		else if (n > 0)
		{
			/* code */
			unsigned int absEx = (unsigned int)n;
			result = this->unsignedPow(x, absEx);
		}
		else
		{
			/* code */
			return 1.0f;
		}

		return result;
	}


	double unsignedPow(double x, unsigned int n) {

		if (n == 0)
			return 0;
		else if (n == 1) {
			return x;
		}

		double result = unsignedPow(x, n >> 1);
		result *= result; // 计算二次方
		if ((n & 0x01) == 1) { // 如果次方为奇数，则再最后输出的时候需要 * x;
			result *= x;
		}

		return result;
	}
};
// @lc code=end

int main() {

	Solution so;


	double result = so.myPow(1.0, INT_MIN);

	std::cout << "result：" << result << endl;

	return 0;
}

#endif // POW_X_N