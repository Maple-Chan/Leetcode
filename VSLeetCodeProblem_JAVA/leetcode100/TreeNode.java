package leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-13 18:28:43
 * @version: 0.0.1
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    private static int index = 0;

    public static TreeNode createBsTree(int[] nums) {
        index = 0;
        return createBsTreeCore(null, nums);
    }

    private static TreeNode createBsTreeCore(TreeNode root, int[] nums) {

        if (nums.length <= index) {
            return null;
        }

        if (root == null) {
            root = new TreeNode(nums[index]);
            root.left = null;
            root.right = null;
        }
        index++;

        if (nums.length <= index) {
            return root;
        }

        if (root.val > nums[index]) {
            root.left = createBsTreeCore(root.left, nums);
        } else {
            root.right = createBsTreeCore(root.right, nums);
        }

        return root;
    }


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
        System.out.println(root.val);

        inorderTraversalCore(root.right, list);

        return list;
    }
}