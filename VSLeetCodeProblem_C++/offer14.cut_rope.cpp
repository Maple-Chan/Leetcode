#define CUT_ROPE
#ifdef CUT_ROPE

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

class Solution
{
public:
    int cut_ropeByBP(int n)
    {
        if (2 > n)
        {
            return 0;
        }
        else if (2 == n)
        {
            return 1;
        }
        else if (3 == n)
        {
            return 2;
        }
        // 开始做动规

        vector<int> pd(n + 1, 0);
        pd[0] = 0;
        pd[1] = 1;
        pd[2] = 2;
        pd[3] = 3; //切3为一段的时候，切下来的是3。

        int max = 0;

        for (int i = 4; i <= n; ++i)
        {
            max = 0;
            for(int j=0;j <= i/2 ;++j){
                int p = pd[j] * pd[i-j];
                if (max < p)
                {
                    /* code */
                    max = p;
                }
                //cout<<"debug: max=" << max << "  index=" << i << endl;
                pd[i] = max;
            }   
        }
        //cout<<"debug: " << n << endl;
        max = pd[n];

        return max;

    }

    int cut_ropeByGreedy(int length)
    {
        if (2 > length)
        {
            return 0;
        }
        else if (2 == length)
        {
            return 1;
        }
        else if (3 == length)
        {
            return 2;
        }

        int timesOf3 = length / 3;

        if(length - timesOf3 * 3 == 1){
            timesOf3 -=1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int)pow(3,timesOf3) * (int)(pow(2,timesOf2));

    }
};

int main()
{
    int number = 10;
    Solution so;

    int out = so.cut_ropeByGreedy(number);

    cout << out << endl;


    return 0;
}

#endif