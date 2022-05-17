package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        //TO DO zie oefening 3
        return null;
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        //TO DO : oefening 4
        int index = this.values.size()-1;
        int indexParent = ((index-1)/2);
        E data = this.values.get(index);
        E dataParent = this.values.get(indexParent);

        while(data.compareTo(dataParent) < 0){
            this.values.set(indexParent, data);
            this.values.set(index, dataParent);
            index = indexParent;
            indexParent = ((index-1)/2);
            data = this.values.get(index);
            dataParent = this.values.get(indexParent);
        }

    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        // TODO zie oefening 5
        int size = this.values.size()-1;
        int index = 0;
        int indexL = 1;
        int indexR = indexL + 1;

        E val = this.values.get(index);
        E valL = this.values.get(indexL);
        E valR = this.values.get(indexR);

        while(indexL <= size){
            if(indexR > size){
                this.values.set(indexL,val);
                this.values.set(index, valL);
                index = indexL;

                val = this.values.get(index);
            }
            else {
                if (valL.compareTo(valR) < 0) {
                    this.values.set(indexL, val);
                    this.values.set(index, valL);
                    index = indexL;
                    indexL = (2 * index) + 1;
                    indexR = indexL + 1;

                    val = this.values.get(index);
                    valL = this.values.get(indexL);
                    valR = this.values.get(indexR);
                }

                else {
                    this.values.set(indexR, val);
                    this.values.set(index, valR);
                    index = indexR;
                    indexL = (2 * index) + 1;
                    indexR = indexL + 1;

                    val = this.values.get(index);
                    valL = this.values.get(indexL);
                    valR = this.values.get(indexR);
                }
            }
        }

    }

    public ArrayList<E> getPath(E value) {
        // TODO zie oefening 6;
        return null;
    }
}
