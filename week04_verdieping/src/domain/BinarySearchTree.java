package domain;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private BinaryTree<E> root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean addNode(E data)
    {
        if (this.root == null) {
            this.root = new BinaryTree<>(data);
            return true;
        }

        return this.root.addNode(data);
    }

    public void printPreOrder() {
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.printPreOrder();
    }

    public void printInorder() {
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.printInorder();
    }

    public List<E> geefKnopenBinnenInterval(E min, E max) {
        if (this.isEmpty())
            throw new IllegalStateException("Empty tree");
        return this.root.geefKnopenBinnenInterval(min, max);
    }

    private class BinaryTree<E extends Comparable<E>> {
        private E data;
        private BinaryTree<E> leftTree, middleTree, rightTree;

        public BinaryTree(E data)
        {
            if (data == null) throw new IllegalArgumentException("De data mag niet leeg zijn bij het aanmaken van een nieuwe node.");
            this.data = data;
        }

        public void printPreOrder() {
            System.out.print(" " + this.data);
            if (leftTree != null) leftTree.printPreOrder();
            if (rightTree != null) rightTree.printPreOrder();
        }

        public void printInorder(){
            if (this.leftTree != null) this.leftTree.printInorder();
            System.out.print(this.data + " ");
            if (this.rightTree != null) this.rightTree.printInorder();
        }
        
        public boolean addNode(E data) {
            if(data.compareTo(this.data) == 0){
                return false;
            }
            else if(data.compareTo(this.data) < 0){
                if(this.leftTree == null){
                    leftTree = new BinaryTree<E>(data);
                    return true;
                }else return this.leftTree.addNode(data);
            }
            else {
                if(this.rightTree == null){
                    rightTree = new BinaryTree<E>(data);
                    return true;
                } else return this.rightTree.addNode(data);
            }
        }

        public List<E> geefKnopenBinnenInterval(E min, E max) {
            if (min == null || max == null)
                throw new IllegalArgumentException("Geen effectief interval");
            List<E> result = new ArrayList<>();
            if (min.compareTo(max) > 0)
                return result;
            // zoek eerst waarden in linkerboom
            // je hoeft niet over volledig interval te zoeken
            // want alle knopen in linkerboom zijn kleiner dan wortel
            if (this.leftTree != null)
                result.addAll(this.leftTree.geefKnopenBinnenInterval(min, getMinimum(this.data, max)));
            // controleer of data in gevraagde interval zit
            if (this.data.compareTo(min) >= 0 && this.data.compareTo(max) <= 0)
                result.add(this.data);
            // behandel rechterboom
            if (this.rightTree != null)
                result.addAll(this.rightTree.geefKnopenBinnenInterval(getMaximum(min, this.data), max));
            return result;
        }
        private E getMinimum(E object1, E object2) {
            if (object1.compareTo(object2) <= 0)
                return object1;
            else
                return object2;
        }
        private E getMaximum(E object1, E object2) {
            if (object1.compareTo(object2) >= 0)
                return object1;
            else
                return object2;
        }
    }
}