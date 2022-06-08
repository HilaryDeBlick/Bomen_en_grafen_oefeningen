package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {

		//integerTree();

//		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(5);
//		boom.addNode(4);
//		boom.addNode(3);
//		boom.addNode(8);
//		boom.addNode(7);

		letterTree();

	}

	private static void integerTree() {
		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		boom.addNode(10);
		boom.addNode(11);
		boom.printInorder();
		System.out.println();
		System.out.println(boom.countNodes());
		boom.removeNode(9);
		boom.removeNode(11);
		boom.removeNode(6);
		boom.printInorder();
		System.out.println();
		System.out.println(boom.countNodes());
		printBoomInfo(boom);
	}

	private static void letterTree() {
		BinarySearchTree<String> letterTree = new BinarySearchTree<>("F");
		letterTree.addNode("B");
		letterTree.addNode("A");
		letterTree.addNode("C");
		letterTree.addNode("D");
		letterTree.addNode("E");
		letterTree.addNode("I");
		letterTree.addNode("H");
		letterTree.addNode("G");

		letterTree.printInorder();

		letterTree.removeNode("G");
		System.out.println();
		letterTree.printInorder();

		letterTree.removeNode("B");
		System.out.println();
		letterTree.printInorder();

		letterTree.removeNode("E");
		System.out.println();
		letterTree.printInorder();
	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInorder();

			//print the lookups
			System.out.println();
			System.out.println(boom.lookup(4));
			System.out.println(boom.lookup(9));
			System.out.println(boom.lookup(2));


			System.out.println();
			System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
			System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());

			System.out.println("Path to 7 = " + boom.getPath(7));
			System.out.println("Path to 4 = " + boom.getPath(4));
			System.out.println("Path to 8 = " + boom.getPath(8));
			System.out.println("Path to 3 = " + boom.getPath(3));
			System.out.println("Path to 10 = " + boom.getPath(10));
			System.out.println("Path to 15 = " + boom.getPath(15));
			System.out.println("Path to 1 = " + boom.getPath(1));
		}


	}
}
