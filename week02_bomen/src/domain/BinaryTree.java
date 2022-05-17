package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printPostorder(){
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public int countNodes(){
		if(this.leftTree == null && this.rightTree == null) return 1;
		else if(this.leftTree != null && this.rightTree == null) return 1 + this.leftTree.countNodes();
		else if(this.leftTree == null) return 1 + this.rightTree.countNodes();
		else return 1 + this.leftTree.countNodes() + this.rightTree.countNodes();
	}

	public int getDepth(){
		if(this.leftTree == null && this.rightTree == null) return 1;
		else if(this.leftTree != null && this.rightTree == null) return 1 + this.leftTree.getDepth();
		else if(this.leftTree == null) return 1 + this.rightTree.getDepth();
		else return Math.max(1 + this.leftTree.getDepth(),1 + this.rightTree.getDepth());
	}

	public boolean isLeaf(){
		return this.leftTree == null && this.rightTree == null;
	}

}
