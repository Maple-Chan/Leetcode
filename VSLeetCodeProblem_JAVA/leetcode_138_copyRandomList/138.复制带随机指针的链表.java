package leetcode_138_copyRandomList;
/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        /**
         * Accepted
         * 18/18 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 59.09 % of java submissions (39.4 MB)
         * 
         */

        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        if (cur == null) {
            return null;
        }

        if (cur.next == null) {
            Node ret = new Node(head.val);

            if (cur.random != null) {
                ret.random = ret;
            }

            return ret;
        }

        Node dupHead = new Node(head.val);
        Node dupCur = dupHead;

        map.put(cur, dupCur);

        cur = cur.next;

        while (cur != null) {
            Node newNode = new Node(cur.val);

            dupCur.next = newNode;
            dupCur = dupCur.next;

            map.put(cur, dupCur);
            cur = cur.next;

        }

        dupCur = dupHead;
        cur = head;
        while (dupCur != null && cur != null) {
            if (cur.random == null) {
                dupCur.random = null;

            } else {
                dupCur.random = map.get(cur.random);
            }
            dupCur = dupCur.next;
            cur = cur.next;
        }

        return dupHead;
    }
}
// @lc code=end
