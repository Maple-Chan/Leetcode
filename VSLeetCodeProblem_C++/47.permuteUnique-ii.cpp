/*
 * @lc app=leetcode.cn id=47 lang=cpp
 * [47] 全排列 II
 */
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// @lc code=start
class Solution
{
public:
    /**
     * Accepted
     * 30/30 cases passed (24 ms)
     * Your runtime beats 28.77 % of cpp submissions
     * Your memory usage beats 100 % of cpp submissions (7.8 MB)
     * 
     */

    vector<vector<int>> permuteUnique(vector<int> &nums)
    {
        vector<int> seq;
        vector<vector<int>> collection;
        vector<bool> isVisit(nums.size(), false);
        sort(nums.begin(),nums.end());

        permuteUniqueCore(nums, collection, seq, isVisit);

        return collection;
    }
private:
    void permuteUniqueCore(
        vector<int> &nums,
        vector<vector<int>> &collection,
        vector<int> &seq,
        vector<bool> &isVisit)

    {
        if (seq.size() == nums.size())
        {
            collection.push_back(seq);
        }

        for (int i = 0; i < nums.size(); ++i)
        {
            if (i>0 && nums[i]==nums[i-1] && isVisit[i-1] == true)
                continue;

            if( isVisit[i] == true)
                continue;

            seq.push_back(nums[i]);
            isVisit[i] = true;

            permuteUniqueCore(nums, collection, seq, isVisit);

            isVisit[i] = false;
            seq.pop_back();
        }
    }
};
// @lc code=end

int main(){
    vector<int> nums={1,1,2};



    Solution so;
    so.permuteUnique(nums);

    cout << "finished !";



    system("pause");
    return 0;
}