
//#define oneplusone
#ifdef oneplusone

#include<iostream> 
#include<vector>


/*
执行用时 :208 ms, 在所有 cpp 提交中击败了38.31%的用户
内存消耗 :9 MB, 在所有 cpp 提交中击败了98.04%的用户
*/
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	int i,j;
    	vector<int> ret;
        for(i=0;i<nums.size();++i){
        	for(j=i + 1;j<nums.size();++j){
        		if(nums.at(i) + nums.at(j) == target){
        			ret.push_back(i);
        			ret.push_back(j);
        			return ret;
				}
			}
		}
		return ret;
    }
};

int main (){
	Solution so;
	vector<int> nums;
	
	nums.push_back(3);
	nums.push_back(2);
	nums.push_back(4);
	vector<int> ret = so.twoSum(nums,6);
	for(int i=0;i<2;++i) {
		cout<< ret.at(i);
	}
	
	return 0;
}

#endif // 0