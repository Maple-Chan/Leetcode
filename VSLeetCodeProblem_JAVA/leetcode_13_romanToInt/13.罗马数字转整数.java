package leetcode_13_romanToInt;
import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        /** 
         * Accepted //时间有点慢
         * 3999/3999 cases passed (10 ms)
         * Your runtime beats 24.88 % of java submissions
         * Your memory usage beats 5.56 % of java submissions (40.2 MB)
        */

        if(s == null || s.length() == 0){
            return 0;
        }

        Map<String, Integer> lib = new HashMap<>();
        lib.put("I", 1);
        // lib.put("IV", 4);
        lib.put("V", 5);
        // lib.put("IX", 9);
        lib.put("X", 10);
        // lib.put("XL", 40);
        lib.put("L", 50);
        // lib.put("XC", 90);
        lib.put("C", 100);
        // lib.put("CD", 400);
        lib.put("D", 500);
        // lib.put("CM", 900);
        lib.put("M", 1000);

        int sum = 0;
        String preSIString ="";
        for (int i = 0; i < s.length(); ++i) {
            String sI = s.substring(i, i + 1);
            
            
            sum+=lib.get(sI);

            if((sI.equals("V")  || sI.equals("X")) &&  preSIString.equals("I")  ){
                sum -=2;
            }
            else if((sI.equals( "L") || sI.equals("C")) &&  preSIString.equals("X")){
                sum -=20;
            }
            else if((sI.equals( "D") || sI.equals( "M")) &&  preSIString.equals("C")){
                sum -=200;
            }

            preSIString = sI;
        }

        return sum;
    }

    // private void romanToIntCore(String)

    public static void main(String[] args) {
        String rom = "LVIII";

        Solution solution = new Solution();

        int ret = solution.romanToInt(rom);

        System.out.println(ret);
        

    }
}
// @lc code=end
