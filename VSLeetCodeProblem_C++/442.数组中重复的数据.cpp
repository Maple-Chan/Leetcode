/*
 * @lc app=leetcode.cn id=442 lang=cpp
 *
 * [442] 数组中重复的数据
 */

// @lc code=start

#include <vector>
#include <algorithm>
#include <iostream>
#include <hash_map>
using namespace std;
class Solution {

public:
    vector<int> findDuplicates(vector<int>& nums) {

    #if 0
    /**
     * 采用排序遍历的方法
     * 执行用时 :152 ms, 在所有 C++ 提交中击败了30.36%的用户
     * 内存消耗 :16.3 MB, 在所有 C++ 提交中击败了13.75%的用户
     */

    vector<int> dup;
    if(nums.size()<2){
        return dup;
    }
    sort(nums.begin(),nums.end());

    vector<int>::iterator it;
    for(it = nums.begin() + 1;it != nums.end();++it){
        if((*it) == (*(it - 1))){
            dup.push_back((*it));
        }
    }
    return dup;
    #endif

    #if 1
    /**
     * 采用hashtable的方法
     */

    vector<int> dup;
    if(nums.size()<2){
        return dup;
    }

    /**
     * 原理解释：
     *      
     *      
    */
    vector<int> res;
    for(int v:nums){ 
        v = abs(v);
        if(nums[v-1] < 0) 
            res.push_back(v);
        else 
            nums[v-1] = -nums[v-1];
    }
    return res;



    return dup;
    #endif



    }
};
// @lc code=end



int main(){
    vector<int> nums = {4,3,2,7,8,2,3,1};
    Solution so;

    vector<int> out = so.findDuplicates(nums);

    vector<int>::iterator it;
    for(it = out.begin();it != out.end();++it){
        cout << (*it)<< " ";
    }


    return 0;
}
