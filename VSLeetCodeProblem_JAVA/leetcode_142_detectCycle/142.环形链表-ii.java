package leetcode_142_detectCycle;
/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {

       

        return null;
    }

    public boolean hasCycle(ListNode head) {

        /**
         * 思路，一个快指针，一个慢指针，如果两个指针能相遇，说明有环
         * 
         */  
        

        if (null == head || null == head.next) {
            return false;
        }

        ListNode slowPass = head;
        ListNode fastPass = head;

        while (null != fastPass && null != slowPass && fastPass.next != null) {
            slowPass = slowPass.next;
            fastPass = fastPass.next .next;

            if(slowPass == fastPass){
                return true;
            }
        }

        return false;
    }
}
// @lc code=end
