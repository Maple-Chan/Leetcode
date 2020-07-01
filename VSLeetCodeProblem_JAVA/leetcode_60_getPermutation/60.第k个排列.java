package leetcode_60_getPermutation;

import java.util.*;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-01 08:51:37
 * @version: 0.0.1
 */
class Solution {
    /**
     * Accepted 200/200 cases passed (1343 ms) Your runtime beats 6.89 % of java
     * submissions Your memory usage beats 9.68 % of java submissions (87.4 MB)
     * 
     * 太慢了，时间复杂度。学学计算时间复杂度
     */
    boolean isFinish = false;
    String out = "";

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i = n - 1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index * factorials[i];
        }
        return sb.toString();

    }

    public String getPermutationLow(int n, int k) {

        List<String> collections = new ArrayList<>();
        StringBuffer sBuffer = new StringBuffer();
        // String out = "";
        boolean[] isVisit = new boolean[n];
        getPermutationCore(n, k, isVisit, collections, sBuffer);

        return out;
    }

    public void getPermutationCore(int n, int k, boolean[] isVisit, List<String> collections, StringBuffer sBuffer) {
        if (isFinish) {
            return;
        }

        if (sBuffer.length() == n) {
            collections.add(sBuffer.toString());
        }
        if (collections.size() == k) {
            out = collections.get(k - 1);
            isFinish = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isVisit[i]) {
                continue;
            }
            if (isFinish) {
                return;
            }

            sBuffer.append(i + 1);
            isVisit[i] = true;

            getPermutationCore(n, k, isVisit, collections, sBuffer);

            sBuffer.deleteCharAt(sBuffer.length() - 1);
            isVisit[i] = false;

        }

        return;
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 9;

        Solution solution = new Solution();

        String out = solution.getPermutation(n, k);

        System.out.println(out);

    }
}
// @lc code=end
