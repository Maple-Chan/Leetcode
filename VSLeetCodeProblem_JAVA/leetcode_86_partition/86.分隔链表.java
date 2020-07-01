package leetcode_86_partition;
/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 小于x按顺序接在上一次小于x的后面，大于等于的就保持不变。


        /**
         * Accepted
         * 166/166 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.55 % of java submissions (39.2 MB)
         * 
         * 
         */

        ListNode fakeHead = new ListNode(-1);

        fakeHead.next = head;

        ListNode cur = head;

        ListNode minroList = new ListNode(-1);
        ListNode maxmaList = new ListNode(-1);
        ListNode curMin = minroList;
        ListNode curMax = maxmaList;
        // ListNode tail = cur;

        while (null != cur) {
            
            if (cur.val < x) {
                curMin.next = cur;
                curMin = cur;

            } else {
                curMax.next = cur;
                curMax = cur;
                
            }
            // tail = cur;
            cur = cur.next;
        }
        curMin.next = null;
        curMax.next = null;


        curMin.next = maxmaList.next;



        return minroList.next;

    }

    public static void main(String[] args) {

        // int[] nums = {
        //     1,4,3,2,2,5
        // };

        // ListNode head = ListNode.createNodeList(nums);

        // Solution solution = new Solution();


        // int x = 3;
        // ListNode ret = solution.partition(head, x);


        return;
    }
}
// @lc code=end
