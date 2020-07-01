package leetcode_136_singleNumber;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums){
        /** 
         * //其余每个元素均出现**两次**。找出那个只出现了**一次**的元素。
         * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
         * O(N)
         * 
         * 解决思路：
         *      排序X，双指针也得基于排序X
         *      
         *         
         *      每个出现两次，两个一样的数字“ ^ ”就变成0,0与某个数异或就还是这个数。
         * 
         */ 



        for(int i=1;i<nums.length;++i){
            nums[0] = nums[0] ^ nums[i];
        }
        



        return nums[0]; // tmp
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        Solution solution =  new Solution();
        int out = 0;
        try {
            out = solution.singleNumber(nums);
        } catch (Exception e) {
            //TODO: handle exception
        }


        System.out.println(out);


    }
}
// @lc code=end

