package leetcode_109_sortedListToBST;
/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
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
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        /**
         * 思路： 1.X 就是有一个中序遍历，转换成二叉树（思路错误） 2. 找到列表中的中间节点作为root，在对左右进行递归 3.
         * 将链表转换为数组，在做类似上述2的方法。可以进行空间换时间，因为数组可以用下标 4. 当然也可以通过左旋右旋调整，但是不如上述2、3解法充分利用题目条件
         * 
         */
        /**
         * 1.Accepted. 32/32 cases passed (0 ms). Your runtime beats 100 % of java
         * submissions. Your memory usage beats 6.67 % of java submissions (41.4 MB).
         * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
         */

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        TreeNode root = buildTree(head, null);

        return root;

    }

    TreeNode buildTree(ListNode leftListNode, ListNode righListNode) {

        if (leftListNode == righListNode) {
            return null;
        }

        ListNode lowPtr = leftListNode;
        ListNode fastPtr = leftListNode;

        while (fastPtr != righListNode && fastPtr.next != righListNode) { // 找到列表中间元素用这个循环。
            lowPtr = lowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode midPtr = lowPtr; // 移动速度慢的节点就是中间节点。

        TreeNode subroot = new TreeNode(midPtr.val);

        subroot.left = buildTree(leftListNode, midPtr);
        subroot.right = buildTree(midPtr.next, righListNode);

        return subroot;
    }

    public static void main(String[] args) {
        // int nums[] = { -10,-3,0,5,9 };

        // ListNode head = ListNode.createNodeList(nums);

        // TreeNode bstTop = new Solution().sortedListToBST(head);

        // return;

    }

}
// @lc code=end
