/*
 * @lc app=leetcode.cn id=142 lang=cpp
 *
 * [142] 环形链表 II
 */
#include <iostream>
using namespace std;
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(nullptr) {
    }
};
// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * TODO: 当前解决方法超时了！！！！！！！！
 * 
 * 
 */ 
class Solution {
public:
    /**
 * 两个指针，一个快，一个慢。快的到了末尾节点，没有追上慢的，说明有环
 * 两个指针，一样快，假如环中有n个节点。P1先走n步，接着P1和P2同时走，当两者相遇的时候就是入口节点。（P1和P2在一开始的时候就可以比较，减少时间）
 * 
 * 
*/
    ListNode* detectCycle(ListNode* pHead)
    {   
        // cout << "Enter detectCycle"<<endl;
        ListNode *metNode = meetingNode(pHead);
        if(nullptr == metNode){
            return nullptr;
        }
        // cout << "After MeetingNode"<<endl;
        //确定环中节点的个数：采用遍历的方法。
        int nodesInLoop = 1;
        ListNode* ptrNodeTemp = metNode;
        while (ptrNodeTemp != nullptr && ptrNodeTemp->next != metNode)
        {
            ptrNodeTemp = ptrNodeTemp->next;
            ++ nodesInLoop;
        }
        // cout << "After figure the number of Node in Loop"<<endl;
        ptrNodeTemp = pHead;
        ListNode* ptrNodeTwo = pHead;

        //先移动Node1  ptrNodeTemp!=nullptr && 
        for(int i=0;  i<nodesInLoop;++i){
            ptrNodeTemp = ptrNodeTemp->next;
        }
        //  cout << "After figure move the Node1"<<endl;
        //在两个都移动,两者相遇就说明到了入口节点。
        /**
         * （因为P1先走N步，P1和P2永远相差一个循环，
         *  当P1指向（去掉循环）的结尾节点是，
         *  P2的next指向循环的起点）
         */

        while (ptrNodeTemp!=nullptr && ptrNodeTwo !=nullptr &&ptrNodeTemp != ptrNodeTwo)
        {
            /* code */
            ptrNodeTemp = ptrNodeTemp->next;
            ptrNodeTwo = ptrNodeTwo->next;
        }
        //  cout << "After find the started Node"<<endl;
        return ptrNodeTemp;

    }

    /**
     *  通过MeetingNode函数判断是否有环。
     * 
    */
    ListNode* meetingNode(ListNode* pHead){
        if(pHead == nullptr){
            return nullptr;
        }

        ListNode *ptrSlow = pHead->next, *ptrFast = pHead->next;
        if(ptrSlow == nullptr)
            return nullptr;
        
        while (ptrSlow != nullptr && ptrFast != nullptr)
        {
            /* code */
            if(ptrSlow == ptrFast){
                return ptrFast;
            }

            ptrSlow = ptrSlow->next;

            // if(ptrSlow == nullptr) // 慢指针不需要判断，因为在下次进入循环的时候已经判断了。
            //     return nullptr;

            ptrFast == ptrFast->next;
            if(ptrFast == nullptr)
                return nullptr;
            else{
                ptrFast = ptrFast->next;
            }
        }
        return nullptr;
    }
};
// @lc code=end


