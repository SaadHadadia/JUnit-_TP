package Queue;

public class QueueBorneeLente implements QueueBorneeIntegerInterface {

    public Integer[] elements;
    public int capacity;
    int taille = 0;
    public int head=0;

    public QueueBorneeLente(int capacity){
        if (capacity<=0) throw new IllegalArgumentException("Can not construct Queue - Capacity can not be negative");

        this.elements = new Integer[capacity];
        this.capacity = capacity;

    }

    @Override
    public int capacite() {
        return this.capacity;
    }

    @Override
    public int taille() {
        return this.taille;
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
        if (this.estPleine()) throw new IllegalStateException("Can not add element - Queue is full");

        int indexAjout = (this.head + this.taille()) % this.capacity;
        this.elements[indexAjout] = element;
        this.taille++;
    }


    @Override
    public int supprimeElement() throws IllegalStateException {
        if (this.estVide()) throw new IllegalStateException("Can not delete element - Queue is empty");

        int first = this.elements[this.head];
        this.elements[this.head] = null;
        if(this.head == this.capacity) this.head=0;
        else this.head ++;
        this.taille--;
        return first;
    }
}
