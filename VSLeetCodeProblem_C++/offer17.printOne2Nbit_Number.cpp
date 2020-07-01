#define PRINTONE2NBIT_NUMBER

#ifdef PRINTONE2NBIT_NUMBER

#include <iostream>
#include "stdio.h"
#include <cstring>
using namespace std;


class Solution
{

    /* data */
    /**
     * 用string实现大数的输出。
    */
public:
    void print1ToMaxOfNDigits(int n){
        if(n <= 0){
            return;
        }
        // printf("get into main function\n");

        char* number = new char[n +1];
        
        // printf("start init\n");
        memset(number,'0',n);//每一位复制数字零
        number[n]='\0';//最后一位赋值结束符
        // printf("init finished\n");

        int calcount = 0;
        while (!incrementNumber(number) )
        {

            /* code */
            printf("now the number is:");
            printf("%s\n",number);

            printf("standard output: ");
            printNumberWithout0(number);
            printf("\n");
            // calcount ++;//只是为了防止越界
            // if(calcount > 100000000){
            //     break;
            // }
        }
        // printf("whole function finished");
        return;
    }

private:

    void printNumberWithout0(char* n){
        
        size_t strLength = strlen(n);

        bool isThefirstZero = true;

        for(size_t i=0; i <= strLength; ++i){
            
            if(isThefirstZero){

                if( n[i] != '0'){
                    isThefirstZero = false;
                    printf("%c",n[i]);
                }
            
            }else{
                printf("%s",n + i);
                break;
            }
        }
    }

    bool incrementNumber(char * incrementNumber){
        // printf("start increase function...\n");
        size_t strLength = strlen(incrementNumber);
        //int bitNumber = 0;
        bool overflow = false;
        int takeover = 0;

        int afterAdd = 0;

        // printf("start loop for add & check takeover\n");
        for (int i = strLength -1 ; i >= 0; --i)
        {
            // printf("loop i = %d\n",i);
            afterAdd = incrementNumber[i] - '0' + takeover;
            takeover = 0;
            /* code */
            if(i == strLength -1){//如果是第一位则要+1
                afterAdd++;
            }

            if(afterAdd == 10){

                if (i ==0){ // 如果在最高位的时候进位的话，说明溢出了
                    overflow = true;
                }
                else{
                    takeover = 1;
                    incrementNumber[i] = '0';
                    afterAdd = 0;
                    
                }

            }
            else if (afterAdd <= 9){
                incrementNumber[i] = '0' + afterAdd;
            }

        }
        // printf("ending increase function...");
        return overflow;
    }
};



int main(){
    int N =4;
    Solution so;
    
    so.print1ToMaxOfNDigits(N);

    return 0;
}

#endif