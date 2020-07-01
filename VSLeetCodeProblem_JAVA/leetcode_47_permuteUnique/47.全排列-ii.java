package leetcode_47_permuteUnique;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> collectionList = new ArrayList<>();
        List<Integer> collection = new ArrayList<>();
        boolean[] isVisit = new boolean[nums.length];
        // boolean [] isRepeat = new boolean[nums.length];
        Arrays.sort(nums);
        int level = 0;
        permuteUniqueCore(nums, collectionList, collection, isVisit, level);

        return collectionList;
    }

    public void permuteUniqueCore(int[] nums, List<List<Integer>> collectionList, List<Integer> collection,
            boolean[] isVisit, int level

    ) {
        if (level == nums.length) {
            collectionList.add(new ArrayList<>(collection));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (isVisit[i] == false) {
                

                if (i > 0 && nums[i] == nums[i - 1] && isVisit[i - 1] == true) {
                    continue;
                }

                collection.add(nums[i]);
                isVisit[i] = true;
                permuteUniqueCore(nums, collectionList, collection, isVisit, level + 1);

                isVisit[i] = false;

                collection.remove(collection.indexOf(nums[i]));
                

            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1 };

        Solution solution = new Solution();

        List<List<Integer>> collection = solution.permuteUnique(nums);

        for (int i = 0; i < collection.size(); ++i) {
            for (int j = 0; j < collection.get(0).size(); ++j) {
                System.out.print(" "+collection.get(i).get(j));
            }
            System.out.println("");
        }

        return;
    }
}
// @lc code=end
