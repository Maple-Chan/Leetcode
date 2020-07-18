package leetcode104;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int deepMax = 0;

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return deepMax;
        }
        deepMax = maxDpethCore(root, 0);

        return deepMax;

    }

    private int maxDpethCore(TreeNode subRoot, int depth) {
        // Accepted
        // 39/39 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.75 % of java submissions (39.9 MB)

        if (null == subRoot) {
            return depth;
        }
        return Math.max(maxDpethCore(subRoot.left, depth + 1), maxDpethCore(subRoot.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution solution = new Solution();

        int ret = solution.maxDepth(root);

        System.out.println(ret);
        return;
    }
}
// @lc code=end
