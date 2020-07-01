package leetcode_31_nextorder;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */
/**
 * 从右向左，找到第一对相邻的升序数。
 * i,j 从右找一个比i位置大的第一个数，交换两个数字 
 * 把交换之后的数据，从小到大进行排序。
 * 
 * 如果没有升序，也就是i遍历完之后<0，则应该进行整个从小到大排序
 * 
 * 
 * 265/265 cases passed (1 ms)
 * Your runtime beats 99.56 % of java submissions
 * Your memory usage beats 53.13 % of java submissions (39.8 MB)
 * 
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        if(nums.length == 2){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }

        int i, j, k;
        i = nums.length - 2;
        j = nums.length - 1;
        k = nums.length - 1;

        while(i >= 0 && j >= 0 && nums[i] >= nums[j]){
            i--;
            j--;
            
        }
        if(i == -1){
            sort(nums, 0, nums.length);
            return;
        }

        while(i<k && nums[i] >= nums[k]){
            k--;
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;

        sort(nums, j, nums.length);

        

    }

    public void sort(int []nums,int j,int end){

        Arrays.sort(nums,j,end);

    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1};

        Solution solution = new Solution();

        solution.nextPermutation(nums);

    
        int[] numsack = { 1, 2, 5, 7,3, 6 };
        solution.sort(numsack, 0, numsack.length);

        return;
    }
}
// @lc code=end
