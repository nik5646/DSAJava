package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeFromLevelOrder {
    class Node {
        int val;
        Node left;
        Node right;
    }
    private Node root;
    
    public void create_BinaryTree_LevelOrder(){
        createBinaryTreeLO();
    }

    Scanner sc = new Scanner(System.in);
    private void createBinaryTreeLO() {
        int val = sc.nextInt();
        Node nn = new Node();
        nn.val = val;
        root = nn;
        Queue<Node> q = new LinkedList<>();
        q.add(nn);
        while(!q.isEmpty()){
            Node rn = q.poll();
            int lc = sc.nextInt();
            int rc = sc.nextInt();
            if(lc != -1){
                Node node = new Node();
                node.val = lc;
                q.add(node);
                rn.left = node;
            }
            if(rc != -1){
                Node node = new Node();
                node.val = rc;
                q.add(node);
                rn.right = node;
            }
        }
    }

}
