/*
 * @lc app=leetcode.cn id=10 lang=cpp
 *
 * [10] 正则表达式匹配
 */
#include <string>
#include <iostream>
using namespace std;

// @lc code=start
class Solution {
public:
    bool isMatch(string s, string p) {
        int sindex=0,pindex=0;
        if(s[0] == '\0' || p[pindex] == '\0')
            return false;

        return matchCore(s,sindex,p,pindex);

    }
    bool matchCore(string s,int sindex, string p,int pindex){
        if(s[sindex] == '\0' && p[pindex] == '\0'){
            return true;
        }
        if(s[sindex] != '\0' && p[pindex] == '\0'){
            return false;
        }

        if(p[pindex + 1] == '*'){
            if(p[pindex] == s[sindex] ||(p[pindex] == '.' && s[sindex]!='\0')){
                return matchCore(s,sindex+1,p,pindex+1) || // move to next state.
                    matchCore(s,sindex+1,p,pindex) ||
                    matchCore(s,sindex,p,pindex+2);

            }
            else
            {
                return matchCore(s,sindex,p,pindex+2); 
            }
        }
        if(s[sindex] == p[pindex] || (p[pindex] == '.' && s[sindex] != '\0')){
            return matchCore(s,sindex+1,p,pindex+1);
        }




        return false;
    }
};
// @lc code=end


int main(){
    
	Solution so;
    string s;
    string p;

	while (cin >> s, cin >> p)
	{
		/* code */
		cout << so.isMatch(s, p) << endl;
	}



    return 0;
}