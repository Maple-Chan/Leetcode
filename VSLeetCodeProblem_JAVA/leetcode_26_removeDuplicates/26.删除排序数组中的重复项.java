package leetcode_26_removeDuplicates;
/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        /**
         * Accepted
         * 161/161 cases passed (1 ms)
         * Your runtime beats 98.22 % of java submissions
         * Your memory usage beats 5.74 % of java submissions (41.8 MB)
         *
         */

        if(null == nums || nums.length == 0) {
            return 0;
        }

        int index = 0;

        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == last){
                continue;
            }
            index++;
            nums[index] = nums[i];
            last = nums[index];
        }
        return ++index;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};

        Solution solution = new Solution();

        int ret = solution.removeDuplicates(nums);

        System.out.println(ret);

    }
}
// @lc code=end

