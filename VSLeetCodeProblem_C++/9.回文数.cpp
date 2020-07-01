/*
 * @lc app=leetcode.cn id=9 lang=cpp
 *
 * 11509/11509 cases passed (212 ms)
 * Your runtime beats 5.64 % of cpp submissions
 * Your memory usage beats 100 % of cpp submissions (6.2 MB)
 * 
 * [9] 回文数
 */

#include <iostream>
using namespace std;

// @lc code=start
class Solution {
public:
    bool isPalindrome(int x) {

        /*  低运行时间，低内存 */
        if(x < 0)
            return false;
        int temp1 = x;
        int temp2 = 0;
        while(temp1 >= 10)
        {    
            temp2 *= 10;
            temp2 += temp1%10;
            temp1 /= 10;
        }
        
        return temp2 == x/10 && temp1 == x%10;  // 等同于 temp2 == x ，除去了越界的风险。

        #if 0
        /*  超长运行时间  */
        if(x < 0){
            return false;
        }

        int base1 = 1,base2 = 10;


        while (x / base1 >= 10)
        {
            /* code */
            if(base1 * 10 < INT32_MAX)
                base1 *=10;
            // cout << "After Init base1: " << base1 << endl;
        }

        
        cout << "Initiated base1: " << base1 << endl;

        while (base1 >= 1 ) 
        {
            cout << "x / base1" << x / base1 << 
                "== x % base2" <<  x % base2<< endl;
            if(x / base1 == x % base2)
            {   
                x = (x % base1) / base2;
                cout << "x:  " << x << endl;
                base1/=100;
            }
            else{
                return false;
            }
        }
        return true;

        #endif
    }
};
// @lc code=end

int main(){

    Solution so;
    int num;

    // cout << INT32_MAX <<endl;
    
    while (cin >> num)
    {
        /* code */
        bool out = so.isPalindrome(num);
        cout << out << endl;
    }
    
    


    return 0;
}
