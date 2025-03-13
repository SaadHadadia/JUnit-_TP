package Queue;

import java.util.ArrayList;

public class QueueBorneeInteger implements QueueBorneeIntegerInterface{

    public ArrayList<Integer> elements;
    public int capacity;

    public QueueBorneeInteger(int capacity){
        if (capacity<=0) throw new IllegalArgumentException("Can not construct Queue - Capacity can not be negative");

        this.elements = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public int capacite() {
        return this.capacity;
    }

    @Override
    public int taille() {
        return this.elements.size();
    }

    @Override
    public boolean estVide() {
        return this.taille() == 0;
    }

    @Override
    public boolean estPleine() {
        return this.taille() == this.capacity;
    }

    @Override
    public void ajouteElement(int element) throws IllegalStateException {
        if(this.estPleine()) throw new IllegalStateException("Can not add element - Queue is full");

        this.elements.add(element);
    }

    @Override
    public int supprimeElement() throws IllegalStateException {
        if (this.estVide()) throw new IllegalStateException("Can not delete element - Queue is empty");

        int first = this.elements.get(0);
        this.elements.remove(0);
        return first;
    }
}
