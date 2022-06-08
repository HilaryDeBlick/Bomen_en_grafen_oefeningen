package ui;

import domain.BinaryTree;

public class BinaryTreeDriver2 {
    public static void main(String[] args) {
        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeC = new BinaryTree<>("C");
        BinaryTree<String> nodeE = new BinaryTree<>("E");
        BinaryTree<String> nodeH = new BinaryTree<>("H");
        BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
        BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);
        BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
        BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);
        System.out.println("\nVolledige boom preorder:");
        boom.printPreorder();
        System.out.println("\nVolledige boom inorder:");
        boom.printInOrder();
        BinaryTree<String> boomZonderI = boom.deelZonder("I");
        System.out.println("\nBoom zonder I preorder: ");
        boomZonderI.printPreorder();
        System.out.println("\nBoom zonder I inorder: ");
        boomZonderI.printInOrder();
        BinaryTree<String> boomZonderB = boom.deelZonder("B");
        System.out.println("\nBoom zonder B preorder: ");
        boomZonderB.printPreorder();
        System.out.println("\nBoom zonder B inorder: ");
        boomZonderB.printInOrder();
    }
}
