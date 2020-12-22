package com.a3nv.solutions;

import com.a3nv.util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Example 1:
 *      3
 *     / \
 *    9   20
 *       /  \
 *     15    7
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 *           1
 *          / \
 *         2   2
 *       /  \
 *      3    3
 *    /  \
 *   4    4
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 * Input: root = []
 * Output: true
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 * @author Ivan Asonov
 *         Date: December 22, 2020
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">110. Balanced Binary Tree</a>
 */
public class E110BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15),
                new TreeNode(7)));
        boolean result = isBalanced(root);
        System.out.println("Tree is balanced: " + result);


        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                new TreeNode(2));
        result = isBalanced(root);
        System.out.println("Tree is balanced: " + result);
    }
}
