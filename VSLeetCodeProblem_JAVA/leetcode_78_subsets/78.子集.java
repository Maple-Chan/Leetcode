package leetcode_78_subsets;
/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        /**
         * 
         * Accepted
         * 10/10 cases passed (1 ms)
         * Your runtime beats 99.24 % of java submissions
         * Your memory usage beats 5.45 % of java submissions (39.9 MB)
         * 
         */

        List<List<Integer>> collection = new ArrayList<>();

        List<Integer> item = new ArrayList<>();

        
        if (null == nums) {
            collection.add(new ArrayList<>(item));
            return collection;
        }


        subsetsCore(nums, collection, item, 0);

        return collection;
    }

    private void subsetsCore(int[] nums, List<List<Integer>> collection, List<Integer> item, int index) {

        collection.add(new ArrayList<>(item));

        for (int i = index; i < nums.length; ++i) {
            item.add(nums[i]);

            subsetsCore(nums, collection, item, i + 1);

            item.remove(item.size() - 1);
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = { 1, 2, 3 };

        List<List<Integer>> collection = solution.subsets(nums);

        System.out.println(collection.size());

    }
}
// @lc code=end
