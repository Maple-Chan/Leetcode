package leetcode_36_isValidSudoku;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        /**
         * 自己定义三个哈希表，一个记录某行某个数、一个记录某列某个数、一个记录某个box某个数
         * 
         */
        /**
         * Java 几种定义二维数组的方式
         */
        boolean[] rowHash[] = new boolean[9][10];
        boolean[][] colHash = new boolean[9][10];
        boolean boxHash[][] = new boolean[9][10];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char charInBoard = board[i][j];
                if (charInBoard != '.') {
                    int number = charInBoard - '0';
                    if (rowHash[i][number] || colHash[j][number] || boxHash[i / 3 * 3 + j / 3][number]) {
                        return false;
                    }
                    else{
                        rowHash[i][number] = true;
                        colHash[j][number] = true;
                        boxHash[i / 3 * 3 + j / 3][number] = true;
                    }

                }

            }
        }

        return true;
    }
    public static void main(String[] args) {
        
        char [][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
          };


          Solution solution = new Solution();


          boolean valid = solution.isValidSudoku(board);

          System.out.println("the validation is : " + valid);


        
    }
}
// @lc code=end

