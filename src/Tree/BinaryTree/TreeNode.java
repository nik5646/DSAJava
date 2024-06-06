package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//LeetCode Questions
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

 class TreeLeetcode {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);//mirror image of each other
    }
    public boolean IsExactlysame(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        boolean left = symmetric(node1.left, node2.left);//compare left with left
        boolean right = symmetric(node1.right, node2.right);
        return left && right;
    }

    public boolean symmetric(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        boolean left = symmetric(node1.left, node2.right);//compare left with right
        boolean right = symmetric(node1.right, node2.left);
        return left && right;
    }

     public boolean isStructureSame(TreeNode node1, TreeNode node2){
         if(node1 == null && node2 == null){
             return true;
         }
         if(node1 == null || node2 == null){
             return false;
         }
//         since checking only structure, data checkup not required.
         boolean left = symmetric(node1.left, node2.left);//compare left with left
         boolean right = symmetric(node1.right, node2.right);
         return left && right;
     }

     public boolean flipEquiv(TreeNode root1, TreeNode root2) {
         if(root1 == null && root2 == null){
             return true;
         }
         if(root1 == null || root2 == null){
             return false;
         }
         if(root1.val != root2.val){
             return false;
         }
         boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);// here we are checking mirror or can be obrained via flip
         boolean noflip = flipEquiv(root1.left, root2.left)&& flipEquiv(root1.right, root2.right);// flip npot required they are same
         return flip || noflip;

     }
     public int sumNumbers(TreeNode root) {
       return sumRootToLeaf(root, 0);
     }

     private int sumRootToLeaf(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return sum*10+root.val;
        }
        int l = sumRootToLeaf(root.left, sum*10+root.val);
        int r= sumRootToLeaf(root.right, sum*10+root.val);
        return l+r;
     }

     public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left==null && root.right==null){
            return (targetSum - root.val) == 0;
        }
        boolean l = hasPathSum(root.left, targetSum-root.val);
        boolean r = hasPathSum(root.right, targetSum-root.val);
        return l || r;

     }

     public List<Integer> rightSideView(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
       RightView(root, 1, ans);
       return ans;

     }
      int maxDepth = 0;
     private void RightView(TreeNode root, int curr, List<Integer> ans) {
         if(root ==  null){
             return;
         }
         if(maxDepth < curr){
             ans.add(root.val);
             maxDepth = curr;
         }
         RightView(root.right, curr+1, ans);// calling right child first coz right view
         RightView(root.left, curr+1, ans);
     }

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null){
             return null;
         }
         if( root == p || root == q){
             return root;
         }
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);
         if(left != null && right != null){
             return root;
         }
         else if(right == null){
             return left;
         }
         else{
             return right;
         }
     }
//O(n2)
     public int diameterOfBinaryTree(TreeNode root) {
         if(root == null){
             return 0;
         }
         int ld = diameterOfBinaryTree(root.left);
         int rd = diameterOfBinaryTree(root.right);
         int sd = height(root.left) + height(root.right) + 2;
         return Math.max(sd, Math.max(rd,ld));

     }

     private int height(TreeNode root) {
         if(root == null){
             return -1; // taking leaf as height 0
         }
         int lh = height(root.left);
         int rh = height(root.right);
         return Math.max(lh, rh)+1;
     }

     //O(n) Fast Diameter
     public int FastDiameter(TreeNode root){
         return Diameter(root).dt;
     }
     public Diapair Diameter(TreeNode root){
            if(root == null){
                return new Diapair();
            }
            Diapair ldp = Diameter(root.left);
            Diapair rdp = Diameter(root.right);
            int sd = Math.max(ldp.ht, rdp.ht)+2;
            Diapair sdp = new Diapair();
            sdp.ht = Math.max(ldp.ht, rdp.ht)+1;
            sdp.dt = Math.max(sd, Math.max(rdp.dt, ldp.dt));
            return sdp;
     }
     class Diapair{
         int dt = 0;
         int ht = -1;
     }

     public boolean isBalanced(TreeNode root) {
         return Balanced(root).isbal;
     }

     public BalancedPair Balanced(TreeNode root) {
         if (root == null) {
             return new BalancedPair();
         }
         BalancedPair lbp = Balanced(root.left);
         BalancedPair rbp = Balanced(root.right);
         boolean sb = Math.abs(lbp.ht - rbp.ht) <= 1;
         BalancedPair sbp = new BalancedPair();
         sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
         sbp.isbal = lbp.isbal && rbp.isbal && sb;
         return sbp;

     }

     class BalancedPair {
         boolean isbal = true;;
         int ht = -1;
     }

     public boolean isValidBST(TreeNode root) {
           return validBst(root).isBst;
     }
     public BstPair validBst(TreeNode root){
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

     public int maxSumBST(TreeNode root) {
         return validBst2(root).ans;
     }
     public BstPair2 validBst2(TreeNode root){
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

//     Status code:- 0, 1, -1
//     0 :- Means Covered
//     1 :- Camera Installed
//     -1 :- Camera needed

     public int minCameraCover(TreeNode root) {
         int ans = countCamera(root);
         if(ans == -1){
             // root needs camera
             camcount++;
         }
         return camcount; // final ans
     }
     int camcount =0;
     public int countCamera(TreeNode root){
         if(root == null){
             // if no node , we will suppose it as covered since no camera needed so retrun 0
             return 0;
         }
//         Now we will take status of right and left child
         int left = countCamera(root.left);
         int right = countCamera(root.right);

         if(left == -1 || right == -1){
             // If any child need camera we will install
             camcount++;
             return 1; // camera installed
         }
         else if(left == 1 || right == 1){
             // if any child has camera it means this node is covered so we will return 0
             return 0;
         }
         else{
             return -1;// Node needs camera
         }
     }



 }

