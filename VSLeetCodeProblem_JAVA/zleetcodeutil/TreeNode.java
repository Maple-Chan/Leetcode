package zleetcodeutil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-14 11:06:30
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

    /**
     * @description 创建二叉树，该创建方法有问题，只能提供满足树的左节点< 根节点 < 右节点
     * @author Maple Chan
     * @date: 2020-07-18 12:25:17
     * @params 
     * @return 
     */
    public static TreeNode createBsTreeCore(int[] nums) {
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

    /**
     * @description 中序遍历
     * @author Maple Chan
     * @date: 2020-07-18 12:24:50
     * @params 
     * @return 
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorderTraversalCore(root, list);

        return list;
    }

    private List<Integer> inorderTraversalCore(TreeNode root, List<Integer> list) {

        /**
         * Accepted 68/68 cases passed (0 ms) Your runtime beats 100 % of java
         * submissions Your memory usage beats 5.79 % of java submissions (38 MB)
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

    /**
     * @description  广度优先搜索
     * @author Maple Chan
     * @date: 2020-07-18 12:24:25
     * @params 
     * @return 
     */
    public void breadthFirstSearch(TreeNode root) {

        if(null == root){
            return;
        }

        TreeNode rPtr = root;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(rPtr);

        while(!deque.isEmpty()){

            TreeNode top = deque.pop();
            System.out.println(top.val);

            if(null != top.left){
                deque.add(top.left);
            }
            if(null != top.right){
                deque.add(top.right);
            }
        }

    }

}