package leetcode_53_maxSubArray;

/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {

        /** 
         * Accepted
         * 202/202 cases passed (1 ms)
         * Your runtime beats 95.07 % of java submissions
         * Your memory usage beats 38.2 % of java submissions (39.8 MB)
         * 
        */
        if(nums.length == 0){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }


        // int [][] dp = new int [nums.length][1];
        int tmpMax = nums[0];
        int ansMax = nums[0];

        

        for(int i=1;i<nums.length;++i){

            tmpMax = Math.max(nums[i], tmpMax + nums[i]); // 如果加上去还是最大的，那就依旧算上下一个元素的

            ansMax = Math.max(tmpMax, ansMax);

        }




        return ansMax;

    }

    public static void main(String[] args) {
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};

        Solution solution = new Solution();


        int max = solution.maxSubArray(nums);

        System.out.println(max);
    }
}
// @lc code=end

