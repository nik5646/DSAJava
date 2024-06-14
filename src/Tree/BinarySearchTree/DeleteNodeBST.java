package Tree.BinarySearchTree;

public class DeleteNodeBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            //for 0 or1 child
            if(root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            else{
                //for two child we are deleting minimum from right child
                int min = min(root.right);
                root.right = deleteNode(root.right, min);
                root.val = min;
            }
        }
        return root;
    }

    private int min(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int l= min(root.left);
        return Math.min(l, root.val);
    }


}
