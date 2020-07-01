/*
 * @lc app=leetcode.cn id=509 lang=cpp
 *
 * [509] 斐波那契数
 */

// @lc code=start

#include <iostream>
using namespace std;

class Solution {
public:
    int fib(int N) {
        /**
         * 迭代方式
         * 
         * 31/31 cases passed (20 ms)
         * Your runtime beats 17.57 % of cpp submissions
         * Your memory usage beats 37.39 % of cpp submissions (8.3 MB)
         * 
        */
        // if( N <= 0)
        //     return 0;

        // if(N == 1)
        //     return 1;

        // if(N == 2)
        //     return 1;
        
        // return fib(N-1) + fib(N-2);

        /**
         * 循环方式
         * 
         * 31/31 cases passed (4 ms)
         * Your runtime beats 73.93 % of cpp submissions
         * Your memory usage beats 20.97 % of cpp submissions (8.3 MB)
         * 
         **/
        if(N == 1){
            return 1;
        }
        if(N == 2){
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        int result=0;
        for(int i=3;i< N + 1;++i){
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
        
    }
};
// @lc code=end

int main(){

    Solution so;
    cout << so.fib(10) <<endl;

    return 0;
}
