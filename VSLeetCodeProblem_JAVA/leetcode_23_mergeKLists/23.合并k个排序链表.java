package leetcode_23_mergeKLists;
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int length = lists.length;

        return mergeKListsCore(0,length-1,lists);
    }

    public ListNode mergeKListsCore(int left, int right, ListNode[] lists) {
        if (left == right) {
            return lists[left];
        }
        if (left > right){
            return null;
        }



        int mid = (left + right) >> 1;

        return mergeTwoLists(mergeKListsCore(left, mid, lists), mergeKListsCore(mid + 1, right, lists));
    }

    // public ListNode mergeKLists(ListNode[] lists) {
    // if(lists == null || lists.length == 0){
    // return null;
    // }
    // if(lists.length == 1){
    // return lists[0];
    // }

    // int length = lists.length;

    // // 最大堆，往堆上存数据，按顺序存入返回的list

    // int passList = 0;
    // // mHeap fakeHead = new mHeap(-1);

    // for(passList = 1;passList<length;++passList){

    // lists[passList] = mergeTwoLists(lists[passList-1], lists[passList]);

    // }

    // return lists[length-1];
    // }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /**
         * Accepted 208/208 cases passed (1 ms) Your runtime beats 62.73 % of java
         * submissions Your memory usage beats 40.19 % of java submissions (39.8 MB)
         */
        ListNode retList = new ListNode(-1);
        ListNode cur = retList;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }

        return retList.next;
    }

}
// @lc code=end
