package leetcode_34_searchRange;

import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 88/88 cases passed (0 ms)
 * Your runtime beats 100 % of java submissions
 * Your memory usage beats 21.05 % of java submissions (43.4 MB)
 * 
 */

// @lc code=start
class Solution {
    /**

     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        /**
         * attr: 升序
         *       时间复杂度必须为LogN
         * 
         * method：二分查找改造。
         *         mid == target
         *         在找到target之后给两个指针分别向两侧方向移动进行查找
         * 
         * 
         */
        if(nums.length == 1){ //数组的问题，数量较少的时候必须要分开讨论
            return nums[0] == target?  new int[] {0,0}:new int[] {-1,-1};
        }


        int indexLow=0, indexHigh = nums.length -1;
        int indexMid = 0;
        int indexStart=0,indexEnd=0,indexHas=-1;

        while(indexLow <= indexHigh){
            indexMid = indexLow + ( (indexHigh - indexLow)>>1 );

            if(nums[indexMid] == target){
                indexHas = indexMid;
                break;
            }
            else if(nums[indexMid] < target){ //细节通过调试解决
                indexLow = indexMid + 1;
            }
            else {
                indexHigh = indexMid - 1;
            }
        }
        boolean hasOthersLeft = true;
        boolean hasOthersRight = true;
        indexStart = indexHas;
        indexEnd = indexHas;
        while(hasOthersLeft || hasOthersRight){
            
            if(indexStart >0 && nums[indexStart - 1] == target){
                indexStart = indexStart - 1;
            }
            else{
                hasOthersLeft = false;
            }

            if(indexEnd < nums.length - 1 && nums[indexEnd + 1] == target){
                indexEnd = indexEnd + 1;
            }
            else{
                hasOthersRight = false;
            }


        }


        if(indexHas == -1)
            return new int[] {-1,-1};
        else{
            return new int[] {indexStart,indexEnd};
        }
    }


    public static void main(String[] args) {

        // int [] nums = {5,7,7,8,8,10};
        // int [] nums = {1,2,3,4,5,6,7,8,9};
        // int target = 4;
        int [] nums = {1,4};
        int target = 4;
        Solution so = new Solution();

        int [] out = so.searchRange(nums, target);

        System.out.println(out[0]+"," + out[1]);

        return;
    }
}
// @lc code=end

