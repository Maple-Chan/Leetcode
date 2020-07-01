package leetcode_16_threesumclosest;
/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start

/**
 * Java 双指针的方式
 * 
 * 125/125 cases passed (13 ms)
 * Your runtime beats 15.32 % of java submissions
 * Your memory usage beats 5.01 % of java submissions (38.3 MB)
 */

import java.util.*;

class Solution {
    class mException extends Exception {
        public String getCode() {
            return "new Exception";
        }

        public mException(String message) {
            super(message);
        }
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int len = nums.length;

        try {

            if (3 > len) {
                throw new mException("Invalid Input! Length of array < 3");
            }

            // int [] nums= {-1,2,1,-4};-4 -1 1 2
            int i = 0, startIndex = i + 1, endIndex = len - 1;

            int closestNum = nums[i] + nums[startIndex] + nums[endIndex];
            int tempNum = 0;

            for (; i < nums.length; ++i) {
                startIndex = i + 1;
                endIndex = len - 1;

                while (i != startIndex && startIndex != endIndex && i != endIndex) {
                    tempNum = nums[i] + nums[startIndex] + nums[endIndex];

                    // 计算两个数值的距离
                    if (Math.abs(target - tempNum) < Math.abs(target - closestNum)) {
                        closestNum = tempNum;
                    }

                    if (tempNum < target) {
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                }

            }
            return closestNum;

        } catch (mException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] nums = { -1, 2, 1, -4 };
        Solution so = new Solution();
        int target = 1;
        System.out.println(so.threeSumClosest(nums, target));

    }
}
// @lc code=end
