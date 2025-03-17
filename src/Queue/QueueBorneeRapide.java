package Queue;

public class QueueBorneeRapide implements QueueBorneeIntegerInterface{
    public Integer[] elements;
    public int capacity;
    public int taille = 0;

    public QueueBorneeRapide(int capacity){
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
        if(this.estPleine()) throw new IllegalStateException("Can not add element - Queue is full");

        else this.elements[this.taille()] = element;
        this.taille++;
    }

    @Override
    public int supprimeElement() throws IllegalStateException {
        if (this.estVide()) throw new IllegalStateException("Can not delete element - Queue is empty");

        int first = this.elements[0];

        // Nouveau tableau de taille réduite
        Integer[] newArray = new Integer[elements.length - 1];
        // Copier les éléments sauf le premier
        System.arraycopy(elements, 1, newArray, 0, newArray.length);

        // Update the elements reference to point to the new array
        this.elements = newArray;

        this.taille--;
        return first;
    }
}
