package leetcode_27_removeElement;
/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                continue;
            }
            nums[index] = nums[i];
            ++index;
        }

        return index;
    }
}
// @lc code=end
