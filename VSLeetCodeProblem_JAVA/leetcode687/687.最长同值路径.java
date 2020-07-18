package leetcode687;
/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import sun.reflect.generics.tree.Tree;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * @description: 给定一个二叉树，找到最长的路径， 这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-08 23:16:34
 * @version: 0.0.1
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }

        int left = longestUnivaluePathCore(root.left, 1, 0);

        return left;
    }

    public int longestUnivaluePathCore(TreeNode rNode, int pathDeep, int maxDeep) {

        if (null == rNode) {
            return maxDeep;
        }
        int retleft = 0;
        int retright = 0;

        if (rNode.left != null && rNode.val == rNode.left.val) {
            maxDeep++;
            retleft = longestUnivaluePathCore(rNode.left, pathDeep + 1, maxDeep);
        } else if (rNode.left != null) {
            retleft = longestUnivaluePathCore(rNode.left, 1, 1);
        }
        if (rNode.right != null && rNode.val == rNode.right.val) {
            maxDeep++;
            retright = longestUnivaluePathCore(rNode.right, pathDeep + 1, maxDeep);
        } else if (rNode.right != null) {
            retright = longestUnivaluePathCore(rNode.right, 1, 1);
        }

        return Math.max(maxDeep, Math.max(retleft, retright));

    }

    public static void main(String[] args) {
        // Solution solution = new Solution();

        // int nums[] = { 1, 4, 1, 5, 5, 5 };

        // TreeNode root = TreeNode.createBSTree(nums);
        // root.inorderTraversal(root);

        // int ret = solution.longestUnivaluePath(root);
    }

}
// @lc code=end
