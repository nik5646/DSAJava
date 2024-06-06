package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    class Node{
        int val;
        Node left;
        Node right;
    }
    private Node root;
    Scanner sc = new Scanner(System.in);
    public BinaryTree(){
        //System.out.println("kuchkuch");
        root = CreateTree();

    }
    public void displayData(){
        System.out.println("displayData");
        display(root);
    }


    private void display(Node root) {
        if(root == null){
            return;
        }
        String s = "";
        s= "<--"+s+root.val+"-->";
        if(root.left != null){
            s = root.left.val + s;
        }
        else {
            s = "."+s;
        }
        if(root.right != null){
            s = s + root.right.val;
        }
        else {
            s = s+".";
        }
        System.out.println(s);
        display(root.left);
        display(root.right);
    }
    public int max(){
        return maxNode(this.root);
    }

    private int maxNode(Node node) {
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lmax = maxNode(node.left);
        int rmax = maxNode(node.right);
        return Math.max(node.val, Math.max(lmax, rmax));
    }

    public Boolean find(int item){
        return find(root, item);
    }

    private Boolean find(Node node, int item) {
        if(node == null){
            return false;
        }
        if(node.val == item){
            return true;
        }
        boolean l= find(node.left, item);
        boolean r = find(node.right,item);
        return l||r;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node) {
//     maximum distance between root to leaf
        if(node == null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) +1;
    }

    public void levelOrder(){
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node n = q.poll();
            System.out.print(n.val+" ");
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right != null){
                q.add(n.right);
            }
        }
    }
    private Node CreateTree() {
        // TODO Auto-generated method stub
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;
        boolean hlc = sc.nextBoolean();
        if (hlc) {
            nn.left = CreateTree();
        }
        boolean hrc = sc.nextBoolean();
        if (hrc) {
            nn.right = CreateTree();
        }
        return nn;

    }

}
