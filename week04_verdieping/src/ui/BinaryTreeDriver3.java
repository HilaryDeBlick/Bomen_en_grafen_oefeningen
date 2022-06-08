package ui;

import domain.BinaryTree;

public class BinaryTreeDriver3 {
    public static void main(String[] args) {
        BinaryTree<String> nodeM = new BinaryTree<>("M");
        BinaryTree<String> nodeG = new BinaryTree<>("G");
        BinaryTree<String> nodeP = new BinaryTree<>("P");
        BinaryTree<String> nodeR = new BinaryTree<>("R");

        BinaryTree<String> nodeF = new BinaryTree<>("F", nodeM, null);
        BinaryTree<String> nodeA = new BinaryTree<>("A", nodeG, nodeF);
        BinaryTree<String> nodeE = new BinaryTree<>("E", nodeR, nodeP);
        BinaryTree<String> boomRootJ = new BinaryTree<>("J", nodeE, nodeA);

        System.out.println("Boom met root J strict? " + boomRootJ.isStrict());
        System.out.println("node R strict? " + nodeR.isStrict());
        System.out.println("subboom node E strict? " + nodeE.isStrict());
    }
}
