package leetcode_120_minimumTotal;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */
import java.util.*;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        /**
         * Accepted
         * 43/43 cases passed (3 ms)
         * Your runtime beats 75.31 % of java submissions
         * Your memory usage beats 8.7 % of java submissions (40 MB)
         * 
         */

        int[][] dp = new int[triangle.size()][triangle.size()];

        int i = triangle.size() - 1;

        for (; i >= 0; i--) {
            List<Integer> list = triangle.get(i);

            for (int j = 0; j < list.size(); ++j) {
                if (i == triangle.size() - 1)
                    dp[i][j] = list.get(j);
                else {
                    dp[i][j] = list.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }

        }

        return dp[0][0];
    }
}
// @lc code=end
