package domain;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
    private E data;
    private BinaryTree<E> leftTree, rightTree;

    public BinaryTree(E data) {
        this(data, null, null);
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public void printPreorder() {
        System.out.print(this.data + " ");
        if (this.leftTree != null) this.leftTree.printPreorder();
        if (this.rightTree != null) this.rightTree.printPreorder();

    }

    public void printInorder() {

        if (this.leftTree != null) this.leftTree.printInorder();
        System.out.print(this.data + " ");
        if (this.rightTree != null) this.rightTree.printInorder();
    }

    public void printPostorder() {

        if (this.leftTree != null) this.leftTree.printPostorder();
        if (this.rightTree != null) this.rightTree.printPostorder();
        System.out.print(this.data + " ");
    }


    /**
     * Deze functie telt het aantal knopen. De som = 0, als de linkerboom verschilt van null, tel je dit aantal bij
     * de som, hetzelfde voor de rechterboom.
     *
     * @return som + 1
     */
    public int countNode() {
        int som = 1;
        if (this.leftTree != null) {
            som += this.leftTree.countNode();
        }
        if (this.rightTree != null) {
            som += this.rightTree.countNode();
        }
        return som;
    }

    /**
     * Deze functie telt de diepte. ALs de linker- en rechterboom verschilt van null dan tel je de bij de linkerhelft 1
     * op en ook bij de rechterhelft.
     *
     * @return het maximum tussen de linker- en rechterhelft.
     */

    public int getDepth() {
        return 1 + Math.max((this.leftTree == null ? 0 : this.leftTree.getDepth()),
                (this.rightTree == null ? 0 : this.rightTree.getDepth()));
    }

    /**
     * Deze functie telt of een knoop een blad is.
     *
     * @return true of false.
     */

    public boolean isLeaf() {
        return (this.leftTree == null && this.rightTree == null);
    }

    /**
     * Deze functie telt het aantal blaadjes.
     *
     * @return int som.
     */


    public int countLeaves() {
        int som = 0;

        if (this.leftTree != null) {
            som += this.leftTree.countLeaves();
        }

        if (this.rightTree != null) {
            som += this.rightTree.countLeaves();
        }

        if (this.leftTree == null && this.rightTree == null) {
            return som + 1;
        }
        return som;
    }

    public int kinderSom() {
        int som = 0;

        if (this.leftTree != null) {
            som = +this.leftTree.kinderSom();
        }

        if (this.rightTree != null) {
            som += this.rightTree.kinderSom();
        }
        return som;
    }


    public List<E> getDataLeaves() {
        List<E> data = new ArrayList<>();
        if (this.isLeaf())
            data.add(this.data);
        if (this.leftTree != null)
            data.addAll(this.leftTree.getDataLeaves());
        if (this.rightTree != null)
            data.addAll(this.rightTree.getDataLeaves());

        return data;
    }

    public boolean contains(String vergelijk) {
        if (this.data.equals(vergelijk)) {
            return true;
        }
        return (this.leftTree != null && this.leftTree.contains(vergelijk)) || (this.rightTree != null && this.rightTree.contains(vergelijk));
    }

    public boolean allNodesHaveTwoChildren() {
        if (this.isLeaf()) {
            return true;
        }
        return (this.leftTree != null && this.leftTree.allNodesHaveTwoChildren()) && (this.rightTree != null && this.rightTree.allNodesHaveTwoChildren());
    }

    public boolean onlyLeavesOnDepth(int k) {
        if (k == this.getDepth()) {
            this.isLeaf();
            return true;
        }
        return false;
    }

    public boolean isPerfect() {
        if (this.allNodesHaveTwoChildren() && this.onlyLeavesOnDepth(this.getDepth())) {
            return true;
        }
        return false;
    }

}
