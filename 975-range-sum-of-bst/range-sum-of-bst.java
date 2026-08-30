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
    public void inorder(ArrayList<Integer> inorder, TreeNode root){
            if(root == null){
                return;
            }
             inorder(inorder,root.left);
            inorder.add(root.val);
             inorder(inorder,root.right);
    }
    public int sum(ArrayList<Integer> inorder , int ans , int low , int high){
        
        int n = inorder.size();
        for(int i = 0 ; i< n ; i++){
            if(inorder.get(i)>=low&&inorder.get(i)<=high)
            ans = ans+inorder.get(i);
        }
        return ans;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(inorder,root);
        return sum(inorder,ans,low,high);
    }
}