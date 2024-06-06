package Tree.BinaryTree;

import Tree.BinaryTree.BinaryTree;

public class BinaryTreeClient {
        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            //INPUT :- 10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false
//            tree.displayData();
//            System.out.println(tree.max());
//            System.out.println(tree.find(40));
//            System.out.println(tree.height());
            tree.levelOrder();
        }
    }

