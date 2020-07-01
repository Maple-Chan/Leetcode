package leetcode_39_combinationSum;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */
import java.util.*;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

// @lc code=start
class Solution {
    /**
     * 解决思路：
     *      采用回溯法，遍历每个元素，将元素进行累加并放入到一个数组中，
     *      target采用减法，当target==0时，说明当前序列满足元素组合等于target。
     *  
     *      才此题，递归中遍历时，可以使用重复的数，但是不能重复当前数使用之前的数（使用重复之前的，输出的集合就会重复）。
     *      因此需要一个index（index = i）对递归的遍历起点进行控制，如果不能重复使用，则index = i + 1
     * 
     */


    /**
     * #采用剪枝能减少运行时间，但是需要进行排序才能用剪枝
     * Accepted
     * 168/168 cases passed (3 ms)
     * Your runtime beats 92.41 % of java submissions
     * Your memory usage beats 9.43 % of java submissions (40 MB)
     * 
     */

    /** 
     *  #没有采用剪枝，时间更久。无序排序
     * Accepted
     * 168/168 cases passed (9 ms)
     * Your runtime beats 17.98 % of java submissions
     * Your memory usage beats 9.43 % of java submissions (40.1 MB)
     * 
    */
    

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combList = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        Arrays.sort(candidates);
        combinationSumCore(combList,combination, 0,candidates, target);


        return combList;
    }

    private void combinationSumCore( List<List<Integer>> combList,List<Integer> combination,int index,int[] candidates,int nextTarget){
        
        if(nextTarget == 0){
            combList.add(new ArrayList<>(combination)); // Java传的是引用，所以必须在这里new一个，不然combList的值将被引用给删掉。
        }
        if(nextTarget < 0){
            return ;
        }

        for(int i = index;i< candidates.length ;++i){  // 这里index（而不是0） 的作用，可以减少输出的重复集合。（原因，不会重复向前查找，之后从当前和当前下标之后进行遍历，允许当前的原因就是可重复）

            if (nextTarget - candidates[i] < 0){
                break;
            }

            // /** 
            //  * 在这个题目中不需要进行小剪枝的原因是，原始数组中就不存在重复的数。
            //  * 
            // */
            // if( i > index && candidates[i] == candidates[i - 1]){ //剪枝减少结果集合中的重复，1'_7 和 1''_7
            //     continue;
            // }


            combination.add(candidates[i]);

            // 如何index=i 变成了 i+1，则变成了不可以重复使用原始集合里面的数。
            combinationSumCore(combList, combination,i, candidates, nextTarget - candidates[i]);

            combination.remove( combination.indexOf(candidates[i]) );
        }
    }


    public static void main(String[] args) {
        int [] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Solution solution = new Solution();
        List<List<Integer>> ret = solution.combinationSum(candidates, target);

        for(int i=0;i<ret.size();++i){
            for(int j=0;j<ret.get(i).size();++j){
                System.out.print(ret.get(i).get(j) + " ");
            }
            System.out.println();

        }
        System.out.println("The end of the program! \n");

    }
}
// @lc code=end

