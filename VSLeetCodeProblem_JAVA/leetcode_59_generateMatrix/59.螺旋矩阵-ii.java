package leetcode_59_generateMatrix;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        /** 
         * Accepted
         * 20/20 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 7.14 % of java submissions (37.9 MB)
         * 
        */

        if(n == 1){
            return new int[][] {{1}};
        }

        int[][] ret = new int[n][n];

        /**
         * 解题思路： 依旧是回溯，isVisit直接可以用 int[x][y] == 0 判断。
         * 
         */ 
        // 右 下 左 上 -> 右
        int[] directionUD = { 0, 1, 0, -1 };
        int[] directionLR = { 1, 0, -1, 0 };

        int passRow = 0;
        int passCol = 0;
        int directionIndex = 0;
        int curNumber = 1;


        for (int i = 0; i < n * n; ++i) {
            if (passRow < 0 ||  passRow > n-1 || passCol < 0 || passCol > n-1 || ret[passRow][passCol] != 0) {
                //如果越界，或者访问过了，则退回一步
                passRow -= directionUD[directionIndex];
                passCol -= directionLR[directionIndex];

                directionIndex++;
                if (directionIndex == 4) {
                    directionIndex = 0;
                }
                passRow += directionUD[directionIndex];
                passCol += directionLR[directionIndex];
                // directionIndex = ++directionIndex % 4 ;

            }else{

            }

            ret[passRow][passCol] = curNumber++;
            passRow += directionUD[directionIndex];
            passCol += directionLR[directionIndex];
        }

        return ret;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 3;
        solution.generateMatrix(n);

        System.out.println("Finished! ");

    }
}
// @lc code=end
