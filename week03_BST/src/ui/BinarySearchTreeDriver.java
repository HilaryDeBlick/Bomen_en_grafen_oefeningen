package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
//		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
//		boom.addNode(4);
//		boom.addNode(8);
//		boom.addNode(3);
//		boom.addNode(5);
//		boom.addNode(7);
//		boom.addNode(9);

		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(5);
		boom.addNode(4);
		boom.addNode(3);
		boom.addNode(8);
		boom.addNode(7);
		boom.addNode(10);

		printBoomInfo(boom);

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
			System.out.println("Path to 3 = " + boom.getPath(3));
			System.out.println("Path to 10 = " + boom.getPath(10));
			System.out.println("Path to 15 = " + boom.getPath(15));
			System.out.println("Path to 1 = " + boom.getPath(1));
		}


	}
}
