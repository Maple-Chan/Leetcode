package leetcode100;


/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Accepted
        // 57/57 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.55 % of java submissions (37.5 MB)

        isSameTreeCore(p, q);

        return isSameTreeCore(p, q);
    }

    private boolean isSameTreeCore(TreeNode p, TreeNode q) {
        TreeNode pPtr = p;
        TreeNode qPtr = q;
        if (null == pPtr && null == qPtr) {
            return true;
        }
        if (null != pPtr && null == qPtr) {
            return false;
        }
        if (null == pPtr && null != qPtr) {
            return false;
        }
        if (pPtr.val == qPtr.val) {
            return isSameTreeCore(pPtr.left, qPtr.left) && isSameTreeCore(pPtr.right, qPtr.right);
        }

        return false;

    }

    // public static void main(String[] args) {
    // int[] plist = { 1, 2, 3 };
    // TreeNode p = TreeNode.createBSTree(plist);
    // int[] qlist = { 1, 3, 2 };
    // TreeNode q = TreeNode.createBSTree(qlist);
    // Solution solution = new Solution();
    // solution.isSameTree(p, q);

    // }

}
// @lc code=end
