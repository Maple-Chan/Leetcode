
//#define POW_X_N

#ifdef POW_X_N

/*
 * @lc app=leetcode.cn id=50 lang=cpp
 *
 * [50] Pow(x, n)
 */

 // @lc code=start


 /**
  * ���� >> 1 �ķ�ʽ����������ʱ��
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
			//���� INT_MIN ���෴��Խ�������

			++n;
			n = -n;

			// ����ֳ�������x����Ϊ�ϱߵ�abs(n) ����Ӧ����ż���ģ������Լ����˴�����൱������2��x
			result *= myPow(x*x, abs(n) / 2) *x * x;

			return 1.0 / result;
		}

		if (n < 0) {
			//��Ҫ�㵹��
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
		result *= result; // ������η�
		if ((n & 0x01) == 1) { // ����η�Ϊ������������������ʱ����Ҫ * x;
			result *= x;
		}

		return result;
	}
};
// @lc code=end

int main() {

	Solution so;


	double result = so.myPow(1.0, INT_MIN);

	std::cout << "result��" << result << endl;

	return 0;
}

#endif // POW_X_N