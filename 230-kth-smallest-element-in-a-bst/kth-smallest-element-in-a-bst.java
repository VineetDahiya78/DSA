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
    int count = 0;
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        if(root.left!=null){
            kthSmallest(root.left,k);
        }
        count++;
        if(k==count){
            res= root.val;
            return root.val;
        }
        if(root.right!=null){
            kthSmallest(root.right,k);
            return res;
           
        }
        return res;
    }
}