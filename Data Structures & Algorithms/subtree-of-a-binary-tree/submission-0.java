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
    public boolean isSame(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(p);

        Queue<TreeNode> qq = new LinkedList<>();
        qq.offer(q);

        while(!pq.isEmpty() && !qq.isEmpty()) {
            if(pq.size() != qq.size()) return false;
            int sz = pq.size();

            for(int i = 0; i < sz; i++) {
                TreeNode curr1 = pq.poll();
                TreeNode curr2 = qq.poll();

                if(curr1 == null && curr2 == null) continue;
                if(curr1 == null || curr2 == null) return false;
                if(curr1.val != curr2.val) return false;

                pq.offer(curr1.left);
                pq.offer(curr1.right);

                qq.offer(curr2.left);
                qq.offer(curr2.right);
            }
        }
        return true;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

       
        if(root.val == subRoot.val && isSame(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}