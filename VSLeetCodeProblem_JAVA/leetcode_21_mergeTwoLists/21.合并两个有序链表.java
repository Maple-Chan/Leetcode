package leetcode_21_mergeTwoLists;


/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */
/**
 * Definition for singly-linked list.
 */


// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /**
         * Accepted
         * 208/208 cases passed (1 ms)
         * Your runtime beats 62.73 % of java submissions
         * Your memory usage beats 40.19 % of java submissions (39.8 MB)
         */
        ListNode retList = new ListNode(-1);
        ListNode cur = retList;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        while(l1!=null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2!=null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }


        return retList.next;
    }


    public static void main(String[] args) {
        // int[] num1 = {1,2,4};
        // int[] num2 = {1,3,4};


        // ListNode l1 = ListNode.createNodeList(num1);
        // ListNode l2 = ListNode.createNodeList(num2);


        // Solution solution = new Solution();

        // solution.mergeTwoLists(l1, l2);


        // return;

    }
}
// @lc code=end

