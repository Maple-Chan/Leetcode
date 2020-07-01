/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */

// @lc code=start

#include <cstdint>
#include <iostream>
using namespace std;
/**
 * 
 * 601/601 cases passed (0 ms)
 * Your runtime beats 100 % of cpp submissions
 * Your memory usage beats 58.53 % of cpp submissions (8.2 MB)
 * 
*/
class Solution {
public:
    int hammingWeight(uint32_t n) {
        
        /**
         * n-1， 把所有该为右边的1都变为零。这个过程能剔除一个一。
         * 右边都变成0，可以用n&(n-1) 做到
        */
       int count = 0;
       while (n)
       {
           /* code */
           ++ count;
           n = (n-1) & n;
       }
       return count;
    }
};
// @lc code=end


int main(){


    Solution so;
    int count = so.hammingWeight(1);

    cout <<"count: " <<count<<endl;

    count = so.hammingWeight(0x7FFFFFFF);

    cout <<"count: " <<count<<endl;

    count = so.hammingWeight(0xFFFFFFFF);

    cout <<"count: " <<count<<endl;


    count = so.hammingWeight(0x80000000);

    cout <<"count: " <<count<<endl;

    
    return 0;
}