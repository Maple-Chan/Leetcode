package leetcode_94_inorderTraversal;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

import java.util.*;

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorderTraversalCore(root, list);

        return list;
    }

    private List<Integer> inorderTraversalCore(TreeNode root, List<Integer> list) {

        /**
         * Accepted
         * 68/68 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.79 % of java submissions (38 MB)
         * 
         */
        if (root == null) {
            return null;
        }

        inorderTraversalCore(root.left, list);

        list.add(root.val);

        inorderTraversalCore(root.right, list);

        return list;
    }

    // public static void main(String[] args) {
    // int[] nums = { 1, 2, -1, 4, 5 };

    // TreeNode root = TreeNode.createBSTree(nums);

    // Solution solution = new Solution();

    // List<Integer> ret = solution.inorderTraversal(root);

    // return;
    // }

}
// @lc code=end
