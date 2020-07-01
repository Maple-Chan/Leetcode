package leetcode_33_searchFromCircleSortedArray;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start

class Solution {
    final boolean _1 = true;
    final boolean _0 = false;

    /**
     * Accepted
     * 196/196 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 17.74 % of java submissions (39.3 MB)
     * 
     * 计算时间复杂度【】！！！！
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchMe(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        if(nums.length < 2){
            return target == nums[0]? 0:-1;
        }

        int ptrLeft = 0,ptrRight = nums.length - 1;
        int ptrMid = 0;


        if(_1){
            /**
             * 这个循环的时间复杂度是O(N)
             */
            while(ptrMid+1 < nums.length && nums[ptrMid] < nums[ptrMid + 1]){
                ++ptrMid;
            }
        }
        else{

        /**
         * 采用双指针法，减少时间复杂度
         * 
         */
        }

        


        /**
         * 重点在于区分，nums[ptrLeft]!= target 与 nums[ptrRight]!= target
         * 如果nums[ptrLeft] == target则要搜条件2
         * 如果nums[ptrRight] == target则要搜条件1。
         */
        if(nums[ptrLeft]!= target && nums[ptrLeft] > target){  //1. 
            return searchCore(nums,ptrMid+1, nums.length,target);
        }else if(nums[ptrRight]!= target && nums[ptrRight] < target){  //2.
            return searchCore(nums, 0, ptrMid+1, target);
        }else{   //2.
            return searchCore(nums, 0, nums.length, target);
        }

    }
    public int searchCore(int[] nums,int leftSide,int rightSide,int target){
        //这里的搜索变成二分搜索才是对的。
        for(int i=leftSide;i<rightSide;++i){

            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }



    /**
     * 直接进行二分的方法，还是上述找到中间值，然后分开搜索的快？（好像上面的时间复杂度不是logN）
     * 时间复杂度（LogN）
     * 196/196 cases passed (1 ms)
     * Your runtime beats 31.82 % of java submissions
     * Your memory usage beats 16.13 % of java submissions (39.7 MB)
     * @param nums
     * @param target
     * @return
     */
    public int search(int [] nums, int target){
        /** 
         * [4,5,6,7,0,1,2];
         * 0
        */
        int ptrLow = 0,ptrHigh = nums.length -1;/* 7*/
        int ptrMid = 0; 

        while(ptrLow <= ptrHigh){
            ptrMid = ptrLow + ((ptrHigh-ptrLow) >> 1);/* 3*/
            if(target == nums[ptrMid]){
                return ptrMid;
            }

            if(nums[ptrMid] < nums[ptrLow]){ //则在右端
                if(target > nums[ptrMid] && target <= nums[ptrHigh]){ // 二分
                    ptrLow = ptrMid + 1;
                }
                else{
                    ptrHigh = ptrMid - 1;
                }
            }
            else{
                if(target < nums[ptrMid] && target >= nums[ptrLow]){
                    ptrHigh = ptrMid - 1;
                }
                else{
                    ptrLow = ptrMid + 1;
                }
            }


        }


        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        Solution so = new Solution();

        int index = so.search(nums, target);

        System.out.println("Index is " + index);

    }
}
// @lc code=end

