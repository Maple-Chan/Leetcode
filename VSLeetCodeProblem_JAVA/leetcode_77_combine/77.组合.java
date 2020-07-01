package leetcode_77_combine;
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /**
         * 从 1-n 中的 k个数的组合 的所有可能 回溯
         */

        /**
         * Accepted
         * 27/27 cases passed (27 ms)
         * Your runtime beats 39.43 % of java submissions
         * Your memory usage beats 62.96 % of java submissions (40.9 MB)
         * 
         */

        List<List<Integer>> collection = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if(n == 1){
            item.add(1);
            collection.add(item);
            return collection;
        }
        // if(n<k){
        //     return null;
        // }






        combineCore(n, k, item, collection, 0);

        return collection;
    }

    private void combineCore(int n, int k, List<Integer> item, List<List<Integer>> collection, int startNumber) {

        if (k == item.size()) {
            collection.add(new ArrayList<Integer>(item));
            
            return;
        }

        for (int i = startNumber+1; i <= n; ++i) {
            item.add(i);

            combineCore(n, k, item, collection, i);

            item.remove(item.size() - 1);

        }

    }

    public static void main(String[] args) {
        Solution solution  = new Solution();

        int n = 4,k=2;

        List<List<Integer>> collection =  solution.combine(n, k);


        System.out.println(collection.size());

    }

}
// @lc code=end
