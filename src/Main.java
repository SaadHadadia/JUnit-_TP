import Queue.QueueBorneeLente;
import Queue.QueueBorneeRapide;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main {
    public static void main(String[] args) {

        QueueBorneeRapide queue = new QueueBorneeRapide(5);

        queue.ajouteElement(10);
        queue.ajouteElement(20);
        queue.ajouteElement(30);

        // Remove first element, should shift array
        System.out.println(queue.supprimeElement()); //10
        System.out.println(queue.taille()); //2


        // Add another element
        queue.ajouteElement(40);
        System.out.println(queue.taille()); //3

        // Verify all elements
        System.out.println(queue.supprimeElement()); //20
        System.out.println(queue.supprimeElement()); //30
        System.out.println(queue.supprimeElement()); //40

        System.out.println(queue.estVide()); // True

    }
}