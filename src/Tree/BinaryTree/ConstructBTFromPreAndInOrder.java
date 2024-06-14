package Tree.BinaryTree;

public class ConstructBTFromPreAndInOrder {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    //plo = preorder lower index
    //ilo = inorder lower index
    private TreeNode createTree(int[] pre, int[] in, int plo, int phi, int ilo, int ihi) {
      if(ilo>ihi || plo>phi){
          return null;
      }
      TreeNode node = new TreeNode(pre[plo]);
      int idx = searchInOrder(in, ilo, ihi, pre[plo]);
      int count = idx - ilo;
      node.left = createTree(pre, in , plo+1, plo+count, ilo, idx-1);
      node.right = createTree(pre, in, plo+count+1, phi, idx+1, ihi);
      return node;
    }

    private int searchInOrder(int[] in, int si, int ei, int item) {
        for(int i = si;i< ei; i++){
            if(in[i] == item){
                return i;
            }

        }
       return 0;
    }
}
