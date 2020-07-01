/**
 * 寻找一个链表中存在的环的入口。
 * 
 * 
 */ 
#include <iostream>
using namespace std;

struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
        val(x), next(NULL) {
    }
};

class Solution {
public:
/**
 * 两个指针，一个快，一个慢。快的到了末尾节点，没有追上慢的，说明有环
 * 两个指针，一样快，假如环中有n个节点。P1先走n步，接着P1和P2同时走，当两者相遇的时候就是入口节点。（P1和P2在一开始的时候就可以比较，减少时间）
 * 
 * 
*/
    ListNode* EntryNodeOfLoop(ListNode* pHead)
    {
        ListNode *meetingNode = MeetingNode(pHead);
        if(nullptr == meetingNode){
            return nullptr;
        }

        //确定环中节点的个数：采用遍历的方法。
        int nodesInLoop = 1;
        ListNode* ptrNodeTemp = meetingNode;
        while (ptrNodeTemp->next != meetingNode)
        {
            ptrNodeTemp = ptrNodeTemp->next;
            ++ nodesInLoop;
        }
        
        ptrNodeTemp = pHead;
        ListNode* ptrNodeTwo = pHead;

        //先移动Node1
        for(int i=0;i<nodesInLoop;++i){
            ptrNodeTemp = ptrNodeTemp->next;
        }
        //在两个都移动,两者相遇就说明到了入口节点。
        /**
         * （因为P1先走N步，P1和P2永远相差一个循环，
         *  当P1指向（去掉循环）的结尾节点是，
         *  P2的next指向循环的起点）
         */

        while (ptrNodeTemp != ptrNodeTwo)
        {
            /* code */
            ptrNodeTemp = ptrNodeTemp->next;
            ptrNodeTwo = ptrNodeTwo->next;
        }
            


        return ptrNodeTemp;

    }

    /**
     *  通过MeetingNode函数判断是否有环。
     * 
    */
    ListNode* MeetingNode(ListNode* pHead){
        if(pHead == nullptr){
            return nullptr;
        }

        ListNode *ptrSlow = pHead->next, *ptrFast = pHead->next;
        if(ptrSlow == nullptr)
            return nullptr;
        
        while (ptrSlow != nullptr && ptrFast != nullptr)
        {
            /* code */
            if(ptrSlow == ptrSlow){
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