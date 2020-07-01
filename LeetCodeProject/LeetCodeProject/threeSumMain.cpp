/*
 * @lc app=leetcode.cn id=15 lang=cpp
 *
 * [15] 三数之和
 */

 // @lc code=start


//#define ThreeSumMain
#ifdef ThreeSumMain


#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

class Solution
{
public:
	vector<vector<int>> threeSum(vector<int> &nums)
	{
		vector<vector<int>> ret;

		/*
		* 处理特殊条件
		*   if nums = null or nums.length < 3 return []
		*/

		if (nums.size() < 3)
		{
			return ret;
		}

		m_sort(nums);
		//-1,-1,0,1
		for (size_t i = 0; i < nums.size(); ++i)
		{

			if (nums[i] > 0)
			{
				break; //如果 当前是大于零，无需在判断
			}
			if (i > 0 && nums[i] == nums[i - 1])
			{
				continue; //如果重复，下一个
			}
			size_t ptrL = i + 1;
			size_t ptrR = nums.size() - 1;
			while (ptrL < ptrR)
			{
				if (0 == nums[i] + nums[ptrL] + nums[ptrR])
				{
					vector<int> item = { nums[i], nums[ptrL], nums[ptrR] };
					ret.push_back(item);

					while (ptrL < ptrR && nums[ptrL] == nums[ptrL + 1])
					{
						ptrL += 1;
					}
					while (ptrL < ptrR && nums[ptrR] == nums[ptrR - 1])
					{
						/* code */
						ptrR -= 1;
					}
					ptrL += 1;
					ptrR -= 1;
				}
				else if (0 < nums[i] + nums[ptrL] + nums[ptrR])
				{
					ptrR -= 1;
				}
				else
				{
					ptrL += 1;
				}
			}
		}

		return ret;
	}
	void m_sort(vector<int> &nums)
	{
		/*排序*/
		sort(nums.begin(), nums.end());
	}
};
// @lc code=end

int main()
{
	Solution so;

	vector<int> nums = { 1, -1, -1, 0 };

	vector<vector<int>> vec = so.threeSum(nums);
	for (size_t i = 0; i < vec.size(); ++i)
	{
		cout << vec[i][0] << ",";
		cout << vec[i][1] << ",";
		cout << vec[i][2] << endl;
	}
	return 0;
}

#endif