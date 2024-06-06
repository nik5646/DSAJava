package Tree.BinarySearchTree;

//Leetcode questions
public class TreeNodeBST {
      int val;
      TreeNodeBST left;
      TreeNodeBST right;
      TreeNodeBST() {}
      TreeNodeBST(int val) { this.val = val; }
      TreeNodeBST(int val, TreeNodeBST left, TreeNodeBST right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    class Solution {
        public TreeNodeBST insertIntoBST(TreeNodeBST root, int val) {
            if (root == null) {
//				TreeNode nn = new TreeNode(val);
//				return nn;
                return new TreeNodeBST(val);
            }
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
            return root;
        }
        public boolean isValidBST(TreeNodeBST root) {
            return validBst(root).isBst;
        }
        public BstPair validBst(TreeNodeBST root){
            if(root == null){
                return new BstPair();
            }
            BstPair lbstp = validBst(root.left);
            BstPair rbstp = validBst(root.right);
            BstPair sbstp = new BstPair();
            sbstp.min = Math.min(root.val, Math.min(lbstp.min, rbstp.min));
            sbstp.max = Math.max(root.val, Math.max(lbstp.max, rbstp.max));
            sbstp.isBst = lbstp.isBst && rbstp.isBst && lbstp.max < root.val && rbstp.min > root.val;
            return sbstp;
        }
        class BstPair{
            boolean isBst = true;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
        }

        public int maxSumBST(TreeNodeBST root) {
            return validBst2(root).ans;
        }
        public BstPair2 validBst2(TreeNodeBST root){
            if(root == null){
                return new BstPair2();
            }
            BstPair2 lbstp = validBst2(root.left);
            BstPair2 rbstp = validBst2(root.right);
            BstPair2 sbstp = new BstPair2();
            sbstp.min = Math.min(root.val, Math.min(lbstp.min, rbstp.min));
            sbstp.max = Math.max(root.val, Math.max(lbstp.max, rbstp.max));
            sbstp.isBst = lbstp.isBst && rbstp.isBst && lbstp.max < root.val && rbstp.min > root.val;
            sbstp.sum = root.val+lbstp.sum + rbstp.sum;
            if(sbstp.isBst){
                sbstp.ans = Math.max(sbstp.sum, Math.max(lbstp.ans, rbstp.ans));
            }
            else{
                sbstp.ans = Math.max(lbstp.ans, rbstp.ans);
            }

            return sbstp;
        }
        class BstPair2{
            boolean isBst = true;
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            int sum=0; // sum of all nodes of tree
            int ans=0;// sum of maximum sum BST in the tree
        }

    }
  }

