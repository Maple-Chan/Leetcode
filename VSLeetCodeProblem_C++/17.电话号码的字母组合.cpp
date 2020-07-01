/*
 * @lc app=leetcode.cn id=17 lang=cpp
 *
 * [17] 电话号码的字母组�?
 * 
 * Accepted
 * 25/25 cases passed (4 ms)
 * Your runtime beats 69.69 % of cpp submissions
 * Your memory usage beats 12.73 % of cpp submissions (8.9 MB)
 * 
 */

// @lc code=start

#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

class Solution {
public:
    map<char,string> lib = {
        {'2',"abc"},{'3',"def"},
        {'4',"ghi"},{'5',"jkl"},{'6',"mno"},
        {'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}

    };


    vector<string> letterCombinations(string digits) {  
        vector<string> ret;
        if (digits == "")
        {
            /* code */
            return ret;
        }
        //还可以进行是否全是数字的判断: 但是这题不考虑



        int count = digits.length();

        // dig == "247"
        // 看成N维数组，如输入247则为三维数组。0,0,0；0,0,1；
        // 用回溯的方法。
        // 
        findCombineCore(0,digits,"",ret);

        return ret;
    }
    // 传入下标（第几个digit），源字符串, 要添加到的字符串，最后添加到的数组（也即是最后需要返回的数组）
    // 通过上述参数进行回溯，类似于数的分叉式的展开
    void findCombineCore(int index,const string &digits,string subcombined,vector<string> &ret){

        if(subcombined.length() == digits.length()){
            ret.push_back(subcombined);
            // cout <<"[info 2] subcombined: " + subcombined << endl;
            return;
        }

        int count = lib[digits[index]].length();

        for (size_t i = 0; i < count; i++)
        {
            subcombined = subcombined + lib[digits[index]][i];
            // cout << "sub: "<< subcombined<<endl;
            // cout<< "index: " <<index << " i: "<< i  << " after add:"<<subcombined<<endl;
            findCombineCore(index + 1,digits,subcombined, ret);
            subcombined = subcombined.substr(0,subcombined.length() -1);
            /* code */
        }
    }
};
// @lc code=end

int main(){

    Solution so;
    string digits = "23";
    so.letterCombinations(digits);
    

    system("pause");
    return 0;
}