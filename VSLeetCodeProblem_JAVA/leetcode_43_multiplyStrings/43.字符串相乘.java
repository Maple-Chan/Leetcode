package leetcode_43_multiplyStrings;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start

class Solution {
    /** 
     * 311/311 cases passed (5 ms)
     * Your runtime beats 74.44 % of java submissions
     * Your memory usage beats 7.41 % of java submissions (39.6 MB)
     * 
     * 
    */
    public String multiply(String num1, String num2) {
        /**
         * 简化成两个一位数相乘，乘出的十位进位到高位的字符相加，如果高位相加之后也变成两位，也需要进位。
         * 
         */
        int multiplier1Length = num1.length() - 1;
        int multiplier2Length = num2.length() - 1;
        int[] result = new int[multiplier1Length + multiplier2Length + 2];

        for (int i = multiplier1Length; i >= 0; --i) {
            for (int j = multiplier2Length; j >= 0; --j) {

                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                multi += result[i + j + 1]; // 先把高位的数相加

                result[i + j + 1] = multi % 10; // 数值低位直接赋值
                result[i + j] += multi / 10; // 数值高位相加

            }
        }

        // 去掉最前的“0”
        StringBuffer sBuffer = new StringBuffer();

        boolean flagNotPrefix = false;
        // 转换成String输出。
        for (int i : result) {
            if (flagNotPrefix || i != 0) {
                flagNotPrefix = true;
                sBuffer.append(i);
            }
        }

        if(sBuffer.length() == 0){ // 上面这种去前缀 ”0“的方式把原先值为零变为了空字符串，所以应该补回去
            sBuffer.append("0");
        }


        return sBuffer.toString();
    }

    public static void main(String[] args) {
        String num1 = "111";
        String num2 = "10";

        Solution solution = new Solution();

        String outString= solution.multiply(num1, num2);

        System.out.println(outString);
    }
}
// @lc code=end
