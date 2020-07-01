package leetcode_61_rotateRight;
/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * Accepted
         * 231/231 cases passed (1 ms)
         * Your runtime beats 80.08 % of java submissions
         * Your memory usage beats 5.41 % of java submissions (39.1 MB)
         */

         /**
          * 输入检查
          */
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }

        ListNode cur = head;

        // 计算节点个数
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // k % count == 0 , 则说明循环到了初始的位置
        if ((k % count) == 0) {
            return head;
        }

        // cur已经到了结尾，将链表成环
        cur.next = head;
        //如果k > N的情况，取模
        if (k > count) {
            k = k % count;
        }

        // 计算结果头节点的下标
        int indexHead = count - k;

        // cur遍历到头结点，pre指针的next（结果的尾节点）指向null
        cur = head;
        ListNode pre = cur;
        for (int i = 0; i < indexHead; ++i) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = null;

        head = cur;

        return head;
    }

    public static void main(String[] args) {

        // int[] num2 = { 1, 2 };
        // ListNode head = ListNode.createNodeList(num2);

        // Solution solution = new Solution();

        // int k = 2;

        // solution.rotateRight(head, k);

        // return;

    }
}
// @lc code=end
