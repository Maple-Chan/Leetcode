package leetcode_82_deleteDuplicates;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */
/**
 * Definition for singly-linked list.
 */

// @lc code=start

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
                ptr.next = temp.next;

            } else {

                ptr = ptr.next;

            }
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[] = { 1, 2, 3, 3, 4, 4, 5 };

        ListNode head = ListNode.createNodeList(nums);

        head = solution.deleteDuplicates(head);

    }
}
// @lc code=end
