package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
//		BinaryTree<String> nodeD = new BinaryTree<>("D");
//		BinaryTree<String> nodeF = new BinaryTree<>("F");
//		BinaryTree<String> nodeB = new BinaryTree<>("B");
//		BinaryTree<String> nodeH = new BinaryTree<>("H");
//
//		// knoop A heeft links D en rechts F
//		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
//		// knoop E heeft links H
//		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
//		// knoop G heeft links E en rechts B
//		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
//
//		// boom heeft root C en heeft links A en rechts G
//		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
//		boom.printPreorder();

		// oef 2.2 f
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");

		// knoop D heeft links C en rechts E
		BinaryTree<String> nodeD = new BinaryTree<>("D",nodeC,nodeE);
		// knoop I heeft links H
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH,null);
		// knoop B links A rechts D
		BinaryTree<String> nodeB = new BinaryTree<>("B",nodeA,nodeD);
		// knoop G rechts I
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);
		// boom heeft root F met links B en rechts G
		BinaryTree<String> boom = new BinaryTree<>("F",nodeB,nodeG);
		boom.printPreorder();
		System.out.println();
		boom.printInorder();
		System.out.println();
		boom.printPostorder();
		System.out.println();
		System.out.println(boom.countNodes());
		//System.out.println(nodeB.countNodes());
		//System.out.println(nodeI.countNodes());
		System.out.println(boom.getDepth());
		//System.out.println(nodeB.getDepth());
		//System.out.println(nodeI.getDepth());
		System.out.println(boom.isLeaf());
		System.out.println(nodeE.isLeaf());
	}

}
