
/***
 * 题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *      例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 提示：从前往后替换的话，时间效率低（n<sup>2</sup>），
 *      需要重复遍历后面的字符。所以可以考虑从后面向前替换新增字符。
 *      一个空格替换为%20三个字符，需要新增两个位置 
 */ 


#include <string.h>
#include <stdio.h>


class Solution {
public:
	void replaceSpace(char *str,int length) {

        if(str == nullptr || length < 0) // 错误输入处理
            return;
            
        size_t count_space = 0;
        for (size_t i = 0; i < length; i++)
        {
            /* code */
            if(*(str+i) == ' ')
                count_space++;
        }
        // info :printf("%d\n",count_space);
        char* retstr = new char[length + count_space * 2];
        retstr[length + count_space * 2] = '\0';

        /**
         *  执行从后替换逻辑 
         * 
         */
        // debug :length = 14
        unsigned ptr = length + count_space * 2 - 1;
        for (size_t i = length -1 ; i <= ptr; i--)
        {
            // debug :printf("%s \n",str+i);
            /* code */
            if( *(str + i) == ' ' ){
                *(retstr + ptr) = '0'; ptr--;
                *(retstr + ptr) = '2'; ptr--;
                *(retstr + ptr) = '%'; ptr--;
            }
            else
            {
                /* code */
                
                *(retstr + ptr) = *(str +i);
                ptr--;
            }
        }
        printf(" retstr is :%s \n",retstr);
	}
};



int main(){
    char str[] = "We are happy!";

    Solution solution;
    solution.replaceSpace(str,14);

    return 0;
}