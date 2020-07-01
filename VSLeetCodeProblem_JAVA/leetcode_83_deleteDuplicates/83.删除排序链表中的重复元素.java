package leetcode_83_deleteDuplicates;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode ptr = fakeHead;

        while (ptr.next != null && ptr.next.next != null) {
            if (ptr.next.val == ptr.next.next.val) {
                ListNode temp = ptr.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                ptr.next = temp;
            } else {
                ptr = ptr.next;
            }

        }

        return fakeHead.next;
    }

    public static void main(String[] args) {

    }
}
// @lc code=end
