package leetcode101;
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

import java.util.LinkedList;


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// @lc code=start
/**
 * @description: 对称二叉树 https://leetcode-cn.com/problems/symmetric-tree/description/
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-18 16:09:36
 * @version: 0.0.1
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 思路, 广度优先遍历，用栈的方式。

        if (null == root) {
            return true;
        }

        // 迭代
        return isSymmetricCoreBfs(root.left, root.right);
    }

    public boolean isSymmetricCore(TreeNode left, TreeNode right) {
        // Accepted
        // 195/195 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 28.75 % of java submissions (38 MB)

        if (null == left && null == right) {
            return true;
        }
        if (null != left && null == right) {
            return false;
        }
        if (null == left && null != right) {
            return false;
        }

        if (left.val == right.val) {
            return isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
        }

        return false;
    }


    LinkedList<TreeNode> stack = new LinkedList<>();
    /**
     * @description 迭代的方法，用队列存数据进行两两比较。
     * @author Maple Chan
     * @date: 2020-07-18 16:07:16
     * @params 
     * @return 
     */
    public boolean isSymmetricCoreBfs(TreeNode left, TreeNode right) {
        // Accepted
        // 195/195 cases passed (1 ms)
        // Your runtime beats 30.72 % of java submissions
        // Your memory usage beats 5 % of java submissions (39.5 MB)
        if (null == left && null == right) {
            return true;
        }
        if (null != left && null == right) {
            return false;
        }
        if (null == left && null != right) {
            return false;
        }

        stack.add(left);
        stack.add(right);

        while (0 < stack.size()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (null == node1 && null == node2) {
                continue;
            }
            if (null == node1 || null == node2 || node1.val != node2.val) {
                return false;
            }

            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Solution solution = new Solution();

        boolean ret = solution.isSymmetric(root);

        System.out.println(ret);
        return;
    }
}
// @lc code=end
