package leetcode35;
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */


// @lc code=start
/**
 * @description: 二分
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-08 19:47:19
 * @version: 0.0.1
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 二分查找

        int left = 0;
        int right = nums.length - 1;

        int mid = 0;
        while (left <= right) {
            // 在right作为可访问边界时，也就是right = mid -1时，
            // 循环结束条件为left<=right

            // mid = (right + left) / 2;
            mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 7, 12, 15, 18 };
        Solution solution = new Solution();
        int target = 13;

        int index = solution.searchInsert(nums, target);

        System.out.println(index);

    }

}
// @lc code=end
