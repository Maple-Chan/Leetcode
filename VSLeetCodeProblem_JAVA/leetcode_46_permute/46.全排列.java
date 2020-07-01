package leetcode_46_permute;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

import java.util.*;

// @lc code=start
class Solution {
    /** 
     * 25/25 cases passed (3 ms)
     * Your runtime beats 45.12 % of java submissions
     * Your memory usage beats 7.32 % of java submissions (39.8 MB)
     * 
     * 
    */
    
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> item = new ArrayList<>();
        List<List<Integer>> collection = new ArrayList<>();

        if (nums.length <= 0) {
            collection.add(new ArrayList<>(item));
            return collection;
        }

        boolean[] isUsed = new boolean[nums.length];
        permuteCore(collection, item, nums, isUsed);

        return collection;
    }

    public void permuteCore(List<List<Integer>> collection, List<Integer> item, int[] nums, boolean[] isUsed) {

        if (nums.length == item.size()) {
            collection.add(new ArrayList<>(item));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (isUsed[i] == false) {
                item.add(nums[i]);
                isUsed[i] = true;
            } else {
                continue;
            }

            permuteCore(collection, item, nums, isUsed);

            item.remove(item.indexOf(nums[i]));

            isUsed[i] = false;

        }

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        Solution solution = new Solution();

        List<List<Integer>> collection = solution.permute(nums);

        return;

    }
}
// @lc code=end
