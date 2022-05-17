package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if(data.compareTo(this.data) == 0){
			return true;
		}
		else if(data.compareTo(this.data) < 0){
			if(this.leftTree == null){
				return false;
			}
			return this.leftTree.lookup(data);
		}
		else{
			if(this.rightTree == null){
				return false;
			}
			return this.rightTree.lookup(data);
		}
	}

	public boolean addNode(E data) {
		if(data.compareTo(this.data) == 0){
			return false;
		}
		else if(data.compareTo(this.data) < 0){
			if(this.leftTree == null){
				leftTree = new BinarySearchTree<E>(data);
				return true;
			}
			return this.leftTree.addNode(data);
		}
		else {
			if(this.rightTree == null){
				rightTree = new BinarySearchTree<E>(data);
				return true;
			}
			return this.rightTree.addNode(data);
		}
	}

	public boolean removeNode(E data){
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public E searchSmallest(){
		if(this.leftTree == null) return this.data;
		else return this.leftTree.searchSmallest();
	}

	public E searchGreatest(){
		if(this.rightTree == null) return this.data;
		else return this.rightTree.searchGreatest();
	}


	public ArrayList<E> getPath(E data){
		if(!lookup(data)) return null;
		else if (this.data.compareTo(data) == 0){
			ArrayList<E> theList = new ArrayList<>();
			theList.add(data);
			return theList;
		}
		else if(this.data.compareTo(data) > 0){
			ArrayList<E> theList = new ArrayList<>();
			theList.add(this.data);
			theList.addAll(leftTree.getPath(data));
			return theList;
		}
		else {
			ArrayList<E> theList = new ArrayList<>();
			theList.add(this.data);
			theList.addAll(rightTree.getPath(data));
			return theList;
		}

	}

}


