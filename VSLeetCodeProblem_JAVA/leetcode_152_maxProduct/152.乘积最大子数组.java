package leetcode_152_maxProduct;

import sun.security.pkcs11.Secmod.DbMode;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        /**
         * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组 （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
         * 
         * 解题思路： 子数组可以是1,2,3...唯一要求就是必须是连续的！！！
         * 
         * DP
         */
        if(nums.length == 0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        /**
         * DP
         *    动态规划一般记录，每次的局部最优解，这题可以通过"表格复用"来减少空间复杂度。
         */

        int max = nums[0];      // 存储最后的max
        int maxPro = nums[0];
        int minPro = nums[0];

        int preMax = maxPro;    
        int preMin = minPro;

        for (int i = 1; i < nums.length; ++i) {
            
            preMax = maxPro;
            preMin = minPro;

            if(nums[i] >= 0){
                maxPro = Math.max(nums[i], nums[i] * maxPro);
                minPro = Math.min(nums[i], nums[i] * minPro);
            }
            else{
                maxPro = Math.max(nums[i], nums[i] * preMin);  //不记录上次的值，就会出现，-4 -3 -2
                minPro = Math.min(nums[i], nums[i] * preMax);  //-4 -3 --> 12 * -3 =  -36 , 在下次-2 时就变成了最大72；

            }

            max = Math.max(max, maxPro);

        }




        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};

        Solution solution = new Solution();

        int ret = solution.maxProduct(nums);

        System.out.println(ret);

    }
}
// @lc code=end
