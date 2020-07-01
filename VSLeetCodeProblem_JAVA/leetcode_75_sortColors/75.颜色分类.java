package leetcode_75_sortColors;
/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        /**
         * Accepted
         * 87/87 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 6.67 % of java submissions (38.2 MB)
         * 
         */
        

        if(null == nums){
            return;
        }
        else if(nums.length == 1){
            System.out.println(nums[0]);
            return;
        }


        int[] countMark = new int[3];

        for (int i = 0; i < nums.length; ++i) {
            switch (nums[i]) {
                case 0:
                    countMark[0]++;
                    break;
                case 1:
                    countMark[1]++;
                    break;

                case 2:
                    countMark[2]++;
                    break;
                default:
                    break;
            }
        }
        int index = 0;

        for (int i = 0; i < countMark.length; ++i) {
            while(countMark[i] > 0 && index < nums.length){
                // System.out.print(i);
                // System.out.print(" ");
                nums[index] = i ;
                countMark[i]--;
                index++;

            }
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[] {
            2,0,2,1,1,0
        };

        Solution solution = new Solution();

        solution.sortColors(nums);



    }
}
// @lc code=end
