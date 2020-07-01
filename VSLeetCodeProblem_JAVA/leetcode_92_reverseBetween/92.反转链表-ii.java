package leetcode_92_reverseBetween;
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

import java.util.List;

import org.w3c.dom.NodeList;

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /**
         * 
         * Accepted 44/44 cases passed (0 ms) Your runtime beats 100 % of java
         * submissions Your memory usage beats 8.7 % of java submissions (37.2 MB)
         * 
         */

        if (m >= n) {
            return head;
        }
        if (null == head) {
            return head;
        }
        if (m <= 0) {
            return head;
        }

        ListNode dumy = new ListNode(-1);
        dumy.next = head;

        ListNode cur = dumy;
        ListNode pre = dumy;

        int count = 1;
        boolean isNeedReverse = false;
        ListNode tempList_lastNode = null;

        ListNode tempList_dumyHead = pre;
        ListNode tempList_tail = pre;

        while (null != cur.next) {
            pre = cur;
            cur = cur.next;

            if (count != n && (count == m || isNeedReverse)) {

                isNeedReverse = true;

                ListNode tempList_newNode = new ListNode(cur.val);
                tempList_newNode.next = tempList_lastNode;

                tempList_lastNode = tempList_newNode;

                if (count == m) {
                    tempList_dumyHead = pre;
                    tempList_tail = tempList_newNode;
                }

            } else if (count == n) {

                isNeedReverse = false;

                ListNode tempList_newNode = new ListNode(cur.val);
                tempList_newNode.next = tempList_lastNode;

                tempList_dumyHead.next = tempList_newNode;

                tempList_tail.next = cur.next;

                break;
            }

            count++;
        }

        return dumy.next;
    }

    public static void main(String[] args) {

        // int[] nums = { 1, 2, 3, 4, 5 };

        // ListNode head = ListNode.createNodeList(nums);

        // Solution so = new Solution();

        // int m = 1, n = 5;

        // so.reverseBetween(head, m, n);

        // return;
    }
}
// @lc code=end
