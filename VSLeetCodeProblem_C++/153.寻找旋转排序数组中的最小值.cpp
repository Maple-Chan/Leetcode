/*
 * @lc app=leetcode.cn id=153 lang=cpp
 *
 * [153] 寻找旋转排序数组中的最小值
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。最小元素为0
 */

/**
 * 
 * 146/146 cases passed (8 ms)
 * Your runtime beats 41.73 % of cpp submissions
 * Your memory usage beats 17.38 % of cpp submissions (8.8 MB)
 * 
*/

// @lc code=start

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    /**
     * 用两个指针减少遍历的次数
    */
    int findMin(vector<int>& nums) {
        size_t leftPtr = 0;
        size_t rightPtr = nums.size() -1;
        size_t destinyPtr = 0;
        //cout << "debug:: in the findMin function!"<<endl;
        if(nums.size() < 1)
            cerr << "Invalid Input arry" << endl;

        if(nums.size()==1)
            return nums[0];
        
        while (nums[leftPtr] >= nums[rightPtr])
        {
            //cout << "debug:: still in the while!"<<endl;
            /* code */
            if(rightPtr - leftPtr == 1){
                //如果两个指针之差为1则说明已经找到了最小值
                destinyPtr = rightPtr;
                break;
            }

            size_t mid = (rightPtr + leftPtr) / 2;

            if(nums[mid]==nums[leftPtr] && nums[mid] == nums[rightPtr]){
                //如果三个相等没法判断的情况
                //采用顺序查找的方式
                int min = nums[0];
                
                for(size_t i=0;i<nums.size();++i){
                    if(min > nums[i]){
                        min = nums[i];
                    }
                }
                return min;
            }

            if(nums[mid] > nums[leftPtr]){
                leftPtr = mid;
            }
            if(nums[mid] < nums[rightPtr]){
                rightPtr = mid;
            }


        }
        return nums[destinyPtr];
    }
};
// @lc code=end

int main(){
    
    vector<int> nums = {1,2};

    Solution so;
    int min = so.findMin(nums);

    cout << min <<endl;
    return 0;
}