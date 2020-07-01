package leetcode_141_hasCycle;
/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
class Solution {
    public boolean hasCycle(ListNode head) {

        /**
         * 思路，一个快指针，一个慢指针，如果两个指针能相遇，说明有环
         * 
         */
        /**
         * Accepted
         * 17/17 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.49 % of java submissions (40.1 MB)
         */

        if (null == head || null == head.next) {
            return false;
        }

        ListNode slowPass = head;
        ListNode fastPass = head;

        while (null != fastPass && null != slowPass && fastPass.next != null) {
            slowPass = slowPass.next;
            fastPass = fastPass.next.next;

            if(slowPass == fastPass){
                return true;
            }
        }

        return false;
    }

}
// @lc code=end
