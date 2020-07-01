package leetcode_80_removeDuplicates;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        /**
         * Accepted
         * 166/166 cases passed (1 ms)
         * Your runtime beats 97.79 % of java submissions
         * Your memory usage beats 8.33 % of java submissions (39.5 MB)
         * 
         */


        int index = 1;
        int sameCount = 1;

        for(int i=1;i<nums.length;++i){

            if(nums[i] == nums[i-1]){
                sameCount++;
            }
            else{
                sameCount = 1;
            }

            if(sameCount > 2){
                continue;

            }else{
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[] = {
            1,1,1,2,2,3
        };

        int index = solution.removeDuplicates(nums);


        System.out.println(index);

    }
}
// @lc code=end

