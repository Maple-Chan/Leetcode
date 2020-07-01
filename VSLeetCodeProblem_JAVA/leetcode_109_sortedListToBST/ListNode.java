package leetcode_109_sortedListToBST;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode createNodeList(int[] nums) {
        int lenthOfArray = nums.length;

        ListNode head = new ListNode(nums[0]);
        ListNode ptr = head;

        int index = 1;
        while (index < lenthOfArray) {

            ptr.next = new ListNode(nums[index]);

            ptr = ptr.next;

            index++;
        }

        return head;
    }
}
