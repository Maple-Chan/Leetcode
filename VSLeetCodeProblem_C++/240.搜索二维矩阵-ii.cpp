/*
 * @lc app=leetcode.cn id=240 lang=cpp
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start

#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        /**
         * 129/129 cases passed (152 ms)
         * Your runtime beats 41.19 % of cpp submissions
         * Your memory usage beats 100 % of cpp submissions (10.9 MB)
         * 
        */

        /**
         * 思路：从右上角开始查找，逐次排除某行某列。
         *      如果大于target则剔除这一列，如果小于target则剔除这一行。
         * 
         * [
         *   [1,   4,  7, 11, 15],
         *   [2,   5,  8, 12, 19],
         *   [3,   6,  9, 16, 22],
         *   [10, 13, 14, 17, 24],
         *   [18, 21, 23, 26, 30]
         *  ]
         * 
         * 
         */
        if(matrix.empty()){
            return false;
        }

        size_t col = matrix.at(0).size();
        size_t row = matrix.size();
        //cout <<"row:"<< row <<"col:"<<col<<endl;

        int colptr = col -1;
        int rowptr = 0;

        bool found = false;
        if(col > 0 && row > 0 ){
            while (rowptr < row && colptr >= 0)
            {
                /* code */
                if(target == matrix[rowptr][colptr]){
                    found = true;
                    break;
                } 
                if(target > matrix[rowptr][colptr]){
                    rowptr++;
                }else
                {
                    colptr--;
                }
            }
        }
        return found;
    }
};
// @lc code=end

int main(){

    Solution so;

    vector<vector<int>> matrix = {
        {1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };

    cout << "is found? "<<so.searchMatrix(matrix,5);




    return 0;
}