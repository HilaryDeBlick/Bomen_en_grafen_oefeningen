package domain;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
	E data;
	BinaryTree<E> leftTree, rightTree;
	
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

	public int count (E data){
		if (data == null){
			return 0;
		}
		return (this.data.equals(data) ? 1 : 0)
				+ (this.leftTree != null ? this.leftTree.count(data) : 0)
				+ (this.rightTree != null ? this.rightTree.count(data) : 0);
	}

	public ArrayList<E> getNodesAtDistance(int k){
		if (k < 0) throw new IllegalArgumentException();

		ArrayList<E> result = new ArrayList<>();
		if(k == 0){
			result.add(this.data);
		} else{
			if (this.leftTree != null){
				result = this.leftTree.getNodesAtDistance(k - 1);
			}
			if(this.rightTree != null){
				ArrayList<E> lijstVanRechts = this.rightTree.getNodesAtDistance(k - 1);
				result.addAll(lijstVanRechts);
			}
		}
		return result;
	}

	public ArrayList<E> mystery() {
		ArrayList<E> lijst = new ArrayList<>();
		lijst.add(this.data);
//		if (this.leftTree != null) lijst.add(this.leftTree.data);
//		if (this.rightTree != null) lijst.add(this.rightTree.data);
		return lijst;
	}
	public ArrayList<E> mystery(int g) {
		if(g < 1) return new ArrayList<>();
		if (g == 1) {
			return this.mystery();
		} else {
			ArrayList<E> links = new ArrayList<>();
			if (this.leftTree != null) links = this.leftTree.mystery(g - 1);
			ArrayList<E> rechts = new ArrayList<>();
			if (this.rightTree != null) rechts = this.rightTree.mystery(g - 1);
			links.addAll(rechts);
			return links;
		}
	}

	public void printPreorder(){
		System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.printPreorder();
		if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInOrder(){
		if (this.leftTree != null) this.leftTree.printInOrder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInOrder();
	}

	public boolean contains(E s){
		if (s == null){
			return false;
		}else{
			if(s.equals(this.data)){
				return true;
			}else{
				return (this.leftTree != null && this.leftTree.contains(s)) || (this.rightTree != null && this.rightTree.contains(s));
			}
		}
	}

	public BinaryTree<E> deelZonder(E wortelInfo) {
		if (wortelInfo == null || !this.contains(wortelInfo))
			return null;
	// wortelInfo == data, dus hele boom verwijderen
		if (this.data == wortelInfo) {
			return null;
		}
	// wortelInfo = linkerkind van data, dus hele linkertak verwijderen
		if (this.leftTree!=null && this.leftTree.data.equals(wortelInfo)){
			return new BinaryTree(this.data,null,this.rightTree);
		}
	// wortelInfo == rechterkind van data, dus hele rechtertak verwijderen
		if (this.rightTree!= null && this.rightTree.equals(wortelInfo)){
			return new BinaryTree(this.data,this.rightTree,null);
		}
		BinaryTree newLeftTree, newRightTree;
	// als wortelInfo in linkertak zit: nieuwe linkertak maken zonder wortelInfo
		if (this.leftTree != null && this.leftTree.contains(wortelInfo))
			newLeftTree = this.leftTree.deelZonder(wortelInfo);
	// anders linkertak behouden
		else newLeftTree = this.leftTree;
	// idem voor rechtertak
		if (this.rightTree!=null && this.rightTree.contains(wortelInfo))
			newRightTree = this.rightTree.deelZonder(wortelInfo);
		else
			newRightTree = this.rightTree;
	// resulterende boom terug samenstellen
		return new BinaryTree<>(this.data,newLeftTree,newRightTree);
	}

	public boolean isLeaf(){
		return this.leftTree == null && this.rightTree == null;
	}

	public boolean isStrict(){
		// wortel == blaadje
		if (this.isLeaf())
			return true;
		// wortel heeft linker- en rechtertak, dus rest van boom controleren
		if ((this.leftTree != null && this.rightTree != null)) {
			return this.leftTree.isStrict() && this.rightTree.isStrict();
		}
		// bij wortel ontbreekt linker- of rechtertak
		return false;
	}
	//*ONDERSTAANDE METHODES NIET IMPLEMENTEREN! DEZE MOETEN GEIMPLEMENTEERD WORDEN IN DE BinarySearchTree file!*//
	boolean lookup(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean removeNode(E data){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchSmallest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchGreatest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	void cleanUp(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	int countNodes(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public ArrayList<E> getPath(E data){ throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file"); }

	protected List<E> geefKnopenBinnenInterval(E min, E max) { throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");	}
}
