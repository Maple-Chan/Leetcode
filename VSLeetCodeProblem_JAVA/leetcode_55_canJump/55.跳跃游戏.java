package leetcode_55_canJump;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        /** 
         * 解题思路：
         *      如果某个位置本身可达，则最远可达为 i+nums[i];
         *      记录最远可达的位置，如果这个位置 >= size - 1 则终点可达。
        */
        if(nums == null || nums.length > 1 && nums[0]==0){
            return false;
        }

        if(nums.length == 1){
            return true;
        }

        int maxIndex = nums[0];
        int size = nums.length;

        for (int i = 0; i < size - 1; ++i) {
            if(maxIndex < i){ // 判断i这个位置是不是可达，一个位置不可达不意味着后面的也是不可达
                return false; //1，0，1，0【下标为2的位置已经不可达】
            }

            if ( maxIndex < nums[i] + i ) { // 记录一个可以到达的最远的位置
                maxIndex = nums[i] + i;
            }
            if(maxIndex >= size-1){
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Solution solution = new Solution();
        boolean ret = solution.canJump(nums);

        System.out.println(ret);

    }
}
// @lc code=end
