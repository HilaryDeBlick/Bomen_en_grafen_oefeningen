package domain;

public class TenarySearchTree<E extends Comparable<E>> {
    private TenaryTree<E> root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean addNode(E data)
    {
        if (this.root == null) {
            this.root = new TenaryTree<>(data);
            return true;
        }

        return this.root.addNode(data);
    }

    public void printPreOrder() {
        if (this.isEmpty()) System.out.println("Geen data in TST");
        else root.printPreOrder();
    }

    private class TenaryTree<E extends Comparable<E>> {
        private E data1, data2;
        private TenaryTree<E> leftTree, middleTree, rightTree;

        public TenaryTree(E data)
        {
            if (data == null) throw new IllegalArgumentException("De data mag niet leeg zijn bij het aanmaken van een nieuwe node.");
            this.data1 = data;
        }

        public void printPreOrder() {
            System.out.print(" " + this.data1 + "-" + this.data2);
            if (leftTree != null) leftTree.printPreOrder();
            if (middleTree != null) middleTree.printPreOrder();
            if (rightTree != null) rightTree.printPreOrder();
        }

        public boolean addNode(E data)
        {
            // We kunnen natuurlijk geen lege data toevoegen, duuh!
            if (data == null) throw new IllegalArgumentException("Je kan geen lege data toevoegen");

            // Data is groter dan data1
            if (data.compareTo(this.data1) > 0) {
                if (this.data2 == null) {
                    this.data2 = data;
                    return true;
                }

                // Als het groter is dan data 2 maar kleiner dan data2, middelste boom
                if (data.compareTo(this.data2) < 0) {
                    // Als de midden boom niet bestaat dan maken we deze aan
                    if (this.middleTree == null) {
                        this.middleTree = new TenaryTree<>(data);
                        return true;
                    }

                    // We gaan naar de midden boom
                    return this.middleTree.addNode(data);
                }

                // Als het groter is dan data1 & data2 dan gaan we naar de rechter boom
                // Als deze niet bestaat maken we die aan
                if (this.rightTree == null) {
                    this.rightTree = new TenaryTree<>(data);
                    return true;
                }

                return this.rightTree.addNode(data);
            }

            // Data is kleiner dan data1
            // Als linker boom niet bestaat maken we deze weer aan
            if (this.leftTree == null) {
                this.leftTree = new TenaryTree<>(data);
                return true;
            }

            // Dan zal het maar in de linker boom moeten zijn.
            return this.leftTree.addNode(data);
        }
    }
}