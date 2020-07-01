package leetcode_81_search;

/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {

        /**
         * 1. 如果target< nums[0], 则从，max -> end 二分查找。反之，从0-> max 二分查找
         * 
         * 
         */

         /**
          * 
          * Accepted
          * 275/275 cases passed (1 ms)
          * Your runtime beats 66.83 % of java submissions
          * Your memory usage beats 50 % of java submissions (39.2 MB)
          */
        if(null == nums || nums.length == 0 ){
            return false;
        }
        if(nums.length ==1){
            return target==nums[0];
        }

        int arrayLenght = nums.length;



        int left = 0;
        int right = arrayLenght - 1;
        int mid = 0;


        /**
         * 相比于33题这里要分三种情况讨论
         * 
         * 对于题目中的问题，这里的时间复杂度从logN 可能会变为 N，也就是在下面第二种情况下
         * 
         */
        if(nums[0] == nums[arrayLenght -1] && target == nums[0]){
            return true;
        }
        else if(nums[0] == nums[arrayLenght -1] && target != nums[0]){
            //这种情况无法找到旋转点
            while(mid+1 < nums.length && nums[mid] <= nums[mid + 1]){
                ++mid;
            }
        }
        /**********************/
        else if(nums[0] != nums[arrayLenght -1]){
            //和33一样的条件，可以用二分找到旋转点，也就是mid

            while (left <= right) {
                mid = (left + right) / 2;
    
                if (mid+1 < arrayLenght && nums[mid + 1] < nums[mid]) {
                    break;
                }
    
                if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else if (nums[mid] <= nums[arrayLenght - 1]) {
                    right = mid - 1;
                }
    
            }

        }



        //找到mid之后进行二分，或者全部遍历（可以做保证能输出正确结果）。

        left = 0;
        right = nums.length - 1;

        if (nums[left] > target) {
            return searchCore(mid, right, nums, target);
        } else if (nums[right] < target) {
            return searchCore(left, mid, nums, target);
        } else if (nums[right] == target || nums[left] == target) {
            return true;
        }else{
            return searchCore(left, right, nums, target);
        }

    }

    boolean searchCore(int left, int right, int[] nums, int target) {
        // 这里的搜索变成二分搜索才是对的。
        for (int i = left; i <= right; ++i) {

            if (nums[i] == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1,1,3,1};
        int target =3;

        boolean retFlag = solution.search(nums, target);

        System.out.println(retFlag);

    }

}
// @lc code=end
