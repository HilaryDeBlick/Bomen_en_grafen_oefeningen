package domain;

public class BinaryTreeInt {

    private int data;
    private BinaryTreeInt leftTree, rightTree;

    public BinaryTreeInt(int data){
        this(data, null, null);
    }
    public BinaryTreeInt(int data, BinaryTreeInt leftTree, BinaryTreeInt rightTree){
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public boolean isLeaf(){
        return this.leftTree == null && this.rightTree == null;
    }

    public boolean kinderSom(){
        //controleer of wortel voldoet aan voorwaarden kindersom, als wortel een blad is voldoet hij
        if(this.isLeaf()) return true; //bij een blad is kindersom altijd true
        //bij wortel geen blad, controleer
        else{
        //bereken som van de waarde van de kinderen -- somwaarde kind = zijn waarde tenzij kind niet bestaat da is somwaarde 0
            int leftValue = this.leftTree != null ? this.leftTree.data : 0;
            int rightValue = this.rightTree != null ? this.rightTree.data : 0;
            //als som niet juist is voldoet de boom niet, return false
            if (this.data != leftValue + rightValue) return false;
        }

        //als wortel wel voldoet moet de rest van de boom nog gecontroleerd worden
        return (this.leftTree == null || this.leftTree.kinderSom()) && (this.rightTree == null || this.rightTree.kinderSom());
    }
}
