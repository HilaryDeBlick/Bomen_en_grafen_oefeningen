package ui;

import domain.BinaryTree;
import domain.BinaryTreeInt;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		// bladeren niveau 5 boom
		BinaryTree<String> nodeE1 = new BinaryTree<>("E");
		BinaryTree<String> nodeE2 = new BinaryTree<>("E");
		// bladeren niveau 4 boom
		BinaryTree<String> nodeE3 = new BinaryTree<>("E");
		BinaryTree<String> nodeE4 = new BinaryTree<>("E");
		// bladeren niveau 3 boom
		BinaryTree<String> nodeA = new BinaryTree<>("A");

		// niveau 4 knoop C met rechts E
		BinaryTree<String> nodeC = new BinaryTree<>("C",null,nodeE1);
		// niveau 4 knoop H met rechts E
		BinaryTree<String> nodeH1 = new BinaryTree<>("H",null,nodeE2);
		// niveau 3 knoop H met links C en rechts E
		BinaryTree<String> nodeH2 = new BinaryTree<>("H",nodeC,nodeE3);
		// niveau 3 knoop I met links H en rechts E
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH1,nodeE4);
		// niveau 2 knoop H met links A en rechts H
		BinaryTree<String> nodeH3 = new BinaryTree<>("H",nodeA,nodeH2);
		//niveau 2 knoop G met rechts I
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);

		//root A met links H en rechts G
		BinaryTree<String> boomRootA = new BinaryTree<>("A",nodeH3,nodeG);

		System.out.println(boomRootA.count("I"));
		System.out.println(boomRootA.count("A"));
		System.out.println(boomRootA.count("H"));
		System.out.println(boomRootA.count("E"));
		System.out.println(boomRootA.count("Q"));
		System.out.println();
		System.out.println("Datavelden van knopen verwijderd op een afstand van 0 van de root = " + boomRootA.getNodesAtDistance(0));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 1 van de root = " + boomRootA.getNodesAtDistance(1));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 2 van de root = " + boomRootA.getNodesAtDistance(2));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 3 van de root = " + boomRootA.getNodesAtDistance(3));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 4 van de root = " + boomRootA.getNodesAtDistance(4));
		System.out.println();
		System.out.println(boomRootA.mystery(0));
		System.out.println(boomRootA.mystery(1));
		System.out.println(boomRootA.mystery(2));
		System.out.println(boomRootA.mystery(3));
		System.out.println(boomRootA.mystery(4));
		System.out.println(boomRootA.mystery(5));

		//bladeren niveau 4 van int boom
		BinaryTreeInt node8 = new BinaryTreeInt(8);
		BinaryTreeInt nodeNeg3 = new BinaryTreeInt(-3);
		BinaryTreeInt nodeNeg1 = new BinaryTreeInt(-1);
		BinaryTreeInt node10 = new BinaryTreeInt(10);
		BinaryTreeInt nodeNeg7 = new BinaryTreeInt(-7);
		//blad niveau 3 van int boom, node 0
		BinaryTreeInt node0 = new BinaryTreeInt(0);

		// niveau 3 node 5 met links 8 en rechts -3
		BinaryTreeInt node5 = new BinaryTreeInt(5,node8,nodeNeg3);
		// niveau 3 node -1 met links -1
		BinaryTreeInt nodeNeg1Int = new BinaryTreeInt(-1,nodeNeg1,null);
		//niveau 3 node 3 met links 10 en rechts -7
		BinaryTreeInt node3 = new BinaryTreeInt(3,node10,nodeNeg7);

		//niveau 2 node 4 met links 5 en rechts -1
		BinaryTreeInt node4 = new BinaryTreeInt(4,node5,nodeNeg1Int);

		//niveau 2 node 3 met links 0 en rechts 3
		BinaryTreeInt node3Int = new BinaryTreeInt(3,node0,node3);

		//niveau 1 node 7 met links 4 en rechts 3
		BinaryTreeInt boomRoot7 = new BinaryTreeInt(7,node4,node3Int);
		System.out.println();
		System.out.println("Int tree oudernode som van kinderen?");
		System.out.println(boomRoot7.kinderSom());
	}

}
