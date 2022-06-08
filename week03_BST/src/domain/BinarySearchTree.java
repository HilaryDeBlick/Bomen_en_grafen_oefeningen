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
		if (data == null){
			return false;
		}
		if(data.compareTo(this.data) == 0){
			return true;
		}
		else if(data.compareTo(this.data) < 0){
			return (this.leftTree != null && this.leftTree.lookup(data));
		}
		else{
			return (this.rightTree != null && this.rightTree.lookup(data));
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
			}else return this.leftTree.addNode(data);
		}
		else {
			if(this.rightTree == null){
				rightTree = new BinarySearchTree<E>(data);
				return true;
			} else return this.rightTree.addNode(data);
		}
	}

	public boolean removeNode(E data){
		if(data == null) throw new IllegalArgumentException();
		if(this.data == null) return false;

		if (this.data.compareTo(data) == 0){ //data found
			if (this.isLeaf()){
				this.data = null;
				return true;
			} else {
				if (this.leftTree != null) { //left tree not empty
					E biggestLeft = this.leftTree.searchGreatest();
					this.data = biggestLeft;
					boolean deleteDone = this.leftTree.removeNode(biggestLeft);
					if (deleteDone) {
						this.leftTree.cleanUp();
					}
					return deleteDone;
				} else { //right tree not empty
					E smallestRight = this.rightTree.searchSmallest();
					this.data = smallestRight;
					boolean deleteDone = this.rightTree.removeNode(smallestRight);
					if (deleteDone) {
						this.rightTree.cleanUp();
					}
					return deleteDone;
				}
			}
		} else{
			if(this.data.compareTo(data) > 0){ //search in left tree
				if(this.leftTree == null){
					return false;
				}else{
					boolean result = this.leftTree.removeNode(data);
					this.leftTree.cleanUp();
					return result;
				}
			} else { //search in right tree
				if (this.rightTree == null){
					return false;
				} else{
					boolean result = this.rightTree.removeNode(data);
					this.rightTree.cleanUp();
					return result;
				}
			}
		}
	}

	public E searchSmallest(){
		return this.leftTree == null ? this.data : this.leftTree.searchSmallest();
//		if(this.leftTree == null) return this.data;
//		else return this.leftTree.searchSmallest();
	}

	public E searchGreatest(){
		return this.rightTree == null ? this.data : this.rightTree.searchGreatest();
//		if(this.rightTree == null) return this.data;
//		else return this.rightTree.searchGreatest();
	}

	public ArrayList<E> getPath(E data){
		if(!lookup(data)) return null; //data zit niet in BST
		else if (this.data.compareTo(data) == 0){ //node equals data
			ArrayList<E> theList = new ArrayList<>();
			theList.add(data);
			return theList;
		}
		else if(this.data.compareTo(data) > 0){ //node is greater than data so search in left subtree
			ArrayList<E> theList = new ArrayList<>();
			theList.add(this.data);
			theList.addAll(leftTree.getPath(data));
			return theList;
		}
		else { //node is smaller than data so search in right subtree
			ArrayList<E> theList = new ArrayList<>();
			theList.add(this.data);
			theList.addAll(rightTree.getPath(data));
			return theList;
		}

	}

	public boolean isLeaf(){
		return this.leftTree == null && this.rightTree == null;
	}

	public int countNodes(){
		return 1 + (this.leftTree == null ? 0 : this.leftTree.countNodes())
				+ (this.rightTree == null ? 0 : this.rightTree.countNodes());
	}

	public void cleanUp(){
		if (this.data != null){
			if(this.leftTree != null){
				if(this.leftTree.data == null){
					this.leftTree = null;
				}else{
					this.leftTree.cleanUp();
				}
			}
		}
		if (this.rightTree != null){
			if(this.rightTree.data == null){
				this.rightTree = null;
			}else {
				this.rightTree.cleanUp();
			}
		}
	}
}


