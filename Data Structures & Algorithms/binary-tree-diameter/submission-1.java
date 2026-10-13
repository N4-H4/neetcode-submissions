/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxDia = 0;
    public int dia(TreeNode root) {
        if(root == null) return 0;

        int leftDia = dia(root.left);
        int rightDia = dia(root.right);

        maxDia = Math.max(maxDia, leftDia + rightDia);

        return Math.max(leftDia, rightDia) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);

        return maxDia;
    }
}
