package leetcode_29_divide;
/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        
        //特殊情况
        if(divisor == 0){
            System.err.println("divisor can not be 0! ");
        }
        else if(dividend == 0){
            return 0;
        }
        else if(dividend == divisor){
            return 1;
        }
        
        ///非特殊情况
        
        int sign = 1;
        if(dividend < 0 )
        {
            dividend = -dividend;
            sign = 0 - sign;
        }
        if(divisor<0){
            divisor = -divisor;
            sign = 0 - sign;
        }

        int result = 0;
        int divisorBak = divisor;
        while(dividend < divisorBak){
            dividend = dividend - divisorBak;
            divisorBak = divisorBak << 1;
            result ++;
            if(dividend < divisorBak){
                divisorBak = divisor;
            }
        }
        if(sign < 0){
            result = -result;
        }



        return result;
    }


    public static void main(String[] args) {
        
    }
    
}
// @lc code=end
