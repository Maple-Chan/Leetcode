package leetcode_94_inorderTraversal;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    private static int index = 0;

    public static TreeNode createBSTree(int[] nums) {
        index = 0;
        return createBSTreeCore(null, nums);
    }

    private static TreeNode createBSTreeCore(TreeNode root, int[] nums) {

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
            root.left = createBSTreeCore(root.left, nums);
        } else {
            root.right = createBSTreeCore(root.right, nums);
        }

        return root;
    }
}
