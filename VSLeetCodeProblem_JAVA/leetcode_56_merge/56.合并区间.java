package leetcode_56_merge;
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        /**
         * 169/169 cases passed (210 ms) Your runtime beats 5.05 % of java submissions
         * Your memory usage beats 42.46 % of java submissions (42.2 MB)
         */

        // 按照左侧值进行排序。
        if (intervals == null) {
            return null;
        }

        if (intervals.length <= 1) {
            return intervals;
        }

        List<List<Integer>> list = new ArrayList<>();

        sortCollection(intervals); // O(n2)

        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; ++i) { // O(n)
            if (intervals[i][0] <= right) {
                right = Math.max(intervals[i][1], right);
            } else {
                List<Integer> newItem = new ArrayList<>();

                newItem.add(left);
                newItem.add(right);
                list.add(newItem);

                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        List<Integer> newItem = new ArrayList<>();

        newItem.add(left);
        newItem.add(right);
        list.add(newItem);

        int[][] retInt = new int[list.size()][2];

        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < list.get(i).size(); ++j) {
                retInt[i][j] = list.get(i).get(j);
            }
        }

        return retInt;
    }

    public void sortCollection(int[][] intervals) {
        for (int i = 0; i < intervals.length; ++i) {
            // 冒泡
            /**
             * 第二个循环，(0 —— n - 1 - i)
             */
            for (int j = 0; j < intervals.length - 1 - i; ++j) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    swap(intervals[j], intervals[j + 1]);
                }
            }

        }

    }

    public void swap(int[] c1, int[] c2) {
        int temp0 = c1[0];
        c1[0] = c2[0];
        c2[0] = temp0;

        int temp1 = c1[1];
        c1[1] = c2[1];
        c2[1] = temp1;

    }

    public static void main(String[] args) {
        // int[][] intervals = { { 1, 9 }, { 2, 2 }, { 19, 20 }, { 10, 11 }, { 12, 20 },
        // { 0, 3 }, { 0, 1 }, { 0, 2 }, };
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }, };

        Solution solution = new Solution();

        // solution.sortCollection(intervals);
        solution.merge(intervals);

        return;
    }
}
// @lc code=end
