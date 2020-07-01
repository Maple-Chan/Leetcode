//#define ROBOTMOVERANGE

#ifdef ROBOTMOVERANGE

#include <iostream>
#include <vector>
#include <string>
using namespace std;
/**
 * 当前代码没有经过测试
 * 
 * 
*/

class Solution
{

public:
    size_t rangOfMove(
        size_t threahold,
        size_t rows,
        size_t cols)
    {
        
        vector<bool> init_visit(cols,false);
        vector<vector<bool>> visited (rows,init_visit);

        int count = rangOfMoveCore(threahold,rows,cols,0,0,visited);

        return count;
    }
private:
    /* data */
    size_t rangOfMoveCore(
        size_t threshold,
        size_t rowstotal,
        size_t colstotal,
        size_t row,
        size_t col,
        vector<vector<bool>> &visited

    ){
        int count = 0;
        if(/*在可运动范围之内*/true)
        {
            visited[row][col] = true;

            count = 1 + rangOfMoveCore(
                threshold,rowstotal,colstotal,
                row,col - 1,visited
            ) + rangOfMoveCore(
                threshold,rowstotal,colstotal,
                row,col + 1,visited
            ) + rangOfMoveCore(
                threshold,rowstotal,colstotal,
                row - 1,col,visited
            ) + rangOfMoveCore(
                threshold,rowstotal,colstotal,
                row + 1,col,visited
            );
        }
        return count;

    }


    bool check(
        size_t threshold,size_t rowstotal,
        size_t colstotal,size_t row,size_t col,
        vector<vector<bool>> visited){
            if(row>=0 && col >= 0 &&
                row < rowstotal && col < colstotal && 
                getDigitSum(row) + getDigitSum(col) <= threshold &&
                 !visited[row][col])
                 {
                     return true;
                 }
            return false;
        }
    int getDigitSum(int number){
        int sum = 0;
        while (number > 0)
        {
            /* code */
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }


};


int main(){

    Solution so;

    cout << "cout: " <<endl;
    cout << so.rangOfMove(18,10,10) <<endl;

    return 0;
}

#endif ROBOTMOVERANGE