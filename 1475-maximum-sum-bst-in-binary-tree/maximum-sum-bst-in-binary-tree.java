// class Solution {

//     int ans = 0;

//     public boolean isvalidBST(TreeNode root, TreeNode min, TreeNode max) {

//         if(root == null) {
//             return true;
//         }

//         if(min != null && root.val <= min.val) {
//             return false;
//         }

//         if(max != null && root.val >= max.val) {
//             return false;
//         }

//         return isvalidBST(root.left, min, root)
//             && isvalidBST(root.right, root, max);
//     }

//     public void inorder(ArrayList<Integer> inorder, TreeNode root) {

//         if(root == null) {
//             return;
//         }

//         inorder(inorder, root.left);
//         inorder.add(root.val);
//         inorder(inorder, root.right);
//     }

//     public int sum(ArrayList<Integer> inorder) {

//         int ans = 0;

//         for(int i = 0; i < inorder.size(); i++) {
//             ans += inorder.get(i);
//         }

//         return ans;
//     }

//     public void findMax(TreeNode root) {

//         if(root == null) {
//             return;
//         }

//         // Check current subtree
//         if(isvalidBST(root, null, null)) {

//             ArrayList<Integer> inorder = new ArrayList<>();

//             inorder(inorder, root);

//             int currentSum = sum(inorder);

//             ans = Math.max(ans, currentSum);
//         }

//         // Check left subtree
//         findMax(root.left);

//         // Check right subtree
//         findMax(root.right);
//     }

//     public int maxSumBST(TreeNode root) {

//         findMax(root);

//         return ans;
//     }
// }

class Solution {

    int ans = 0;

    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public Info check(TreeNode root) {

        if(root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = check(root.left);
        Info right = check(root.right);

        if(left.isBST && right.isBST &&
           left.max < root.val &&
           root.val < right.min) {

            int currentSum = left.sum + root.val + right.sum;

            ans = Math.max(ans, currentSum);

            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);

            return new Info(true, min, max, currentSum);
        }

        return new Info(false, 0, 0, 0);
    }

    public int maxSumBST(TreeNode root) {
        check(root);
        return ans;
    }
}