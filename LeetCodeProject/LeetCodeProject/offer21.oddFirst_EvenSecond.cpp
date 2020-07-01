//#define ODD_FIRST_EVEN_SCEOND

#ifdef ODD_FIRST_EVEN_SCEOND


#include <vector>
#include <iostream>
using namespace std;

/*
	思路：两个指针
*/
class Solution {
public:
	vector<int> exchange(vector<int>& nums) {
		int indexLeft = 0, indexRight = nums.size() - 1;

		while (indexLeft < indexRight)
		{
			bool leftodd = !isEven(nums[indexLeft]);
			bool righteven = isEven(nums[indexRight]);
			if (leftodd) {
				indexLeft++;
			}
			if (righteven) {
				indexRight--;
			}
			if (!leftodd && !righteven) {
				int tmp = nums[indexLeft];
				nums[indexLeft] = nums[indexRight];
				nums[indexRight] = tmp;
			}


		}
		return nums;
	}
	bool isEven(int& num) {
		return !(num % 2);
	}
};


int main() {
	Solution so;
	vector<int> nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
	
	vector<int> qoute = so.exchange(nums);

	for (int i = 0; i < nums.size(); ++i) {
		cout << nums[i] << " ";
	}
	cout << endl;

	system("pause");
	return 0;
}

#endif // ODD_FIRST_EVEN_SCEOND
