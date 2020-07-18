package leetcode88;
/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-10 13:35:15
 * @version: 0.0.1
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 直接插入，然后冒泡排序，Log(N)^2
         */

        // Accepted
        // 59/59 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.06 % of java submissions (39.8 MB)

        /**
         * nums1 = [1,7,8,0,0,0], m = 3 nums2 = [2,5,6], n = 3
         * 
         * 
         * 
         * 归并排序。最好是想一下能不能直接插入，不需要额外的内存空间。 1. 如果是申请一个空间，然后归并的方法，那么时间复杂度，NLog(N)
         * 
         * 2. 尚未想到！
         */
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] temparray = new int[m];
        for (int i = 0; i < temparray.length; i++) {
            temparray[i] = nums1[i];
        }

        int indexM = 0;
        int indexN = 0;

        while (indexM < m && indexN < n) {
            if (temparray[indexM] > nums2[indexN]) {
                nums1[indexM + indexN] = nums2[indexN];
                indexN++;
            } else {
                nums1[indexM + indexN] = temparray[indexM];
                indexM++;
            }
        }

        while (indexM < m) {
            nums1[indexM + indexN] = temparray[indexM];
            indexM++;
        }

        while (indexN < n) {
            nums1[indexM + indexN] = nums2[indexN];
            indexN++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 0 };
        int m = 0;
        int[] nums2 = { 1 };
        int n = 1;
        solution.merge(nums1, m, nums2, n);

        System.out.println("finished");

    }
}
// @lc code=end
