package tests;

import Queue.QueueBorneeLente;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class QueueBorneeLenteTest {

    private QueueBorneeLente queue;
    private final int CAPACITY = 5;

    @Before
    public void setUp() {
        queue = new QueueBorneeLente(CAPACITY);
    }

    @Test
    public void testConstructor() {
        assertEquals(CAPACITY, queue.capacite());
        assertEquals(0, queue.taille());
        assertTrue(queue.estVide());
        assertFalse(queue.estPleine());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeCapacity() {
        new QueueBorneeLente(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithZeroCapacity() {
        new QueueBorneeLente(0);
    }

    @Test
    public void testAjouteElement() {
        queue.ajouteElement(10);
        assertEquals(1, queue.taille());
        assertFalse(queue.estVide());

        queue.ajouteElement(20);
        assertEquals(2, queue.taille());
    }

    @Test
    public void testSupprimeElement() {
        queue.ajouteElement(10);
        queue.ajouteElement(20);

        assertEquals(10, queue.supprimeElement());
        assertEquals(1, queue.taille());

        assertEquals(20, queue.supprimeElement());
        assertEquals(0, queue.taille());
        assertTrue(queue.estVide());
    }

    @Test
    public void testCircularBehavior() {
        // Fill the queue
        for (int i = 0; i < CAPACITY; i++) {
            queue.ajouteElement(i);
        }

        // Remove first two elements
        assertEquals(0, queue.supprimeElement());
        assertEquals(1, queue.supprimeElement());

        // Add new elements that should wrap around
        queue.ajouteElement(100);
        queue.ajouteElement(101);

        // Remove all elements and verify order
        assertEquals(2, queue.supprimeElement());
        assertEquals(3, queue.supprimeElement());
        assertEquals(4, queue.supprimeElement());
        assertEquals(100, queue.supprimeElement());
        assertEquals(101, queue.supprimeElement());
    }

    @Test
    public void testHeadWrapping() {
        // Fill the queue
        for (int i = 0; i < CAPACITY; i++) {
            queue.ajouteElement(i);
        }

        // Empty the queue
        for (int i = 0; i < CAPACITY; i++) {
            queue.supprimeElement();
        }

        // Ensure head has wrapped properly
        queue.ajouteElement(100);
        assertEquals(100, queue.supprimeElement());
    }

    @Test
    public void testEstPleine() {
        for (int i = 0; i < CAPACITY; i++) {
            queue.ajouteElement(i);
        }

        assertTrue(queue.estPleine());
    }

    @Test(expected = IllegalStateException.class)
    public void testAjouteElementWhenFull() {
        for (int i = 0; i < CAPACITY; i++) {
            queue.ajouteElement(i);
        }

        queue.ajouteElement(100); // This should throw exception
    }

    @Test(expected = IllegalStateException.class)
    public void testSupprimeElementWhenEmpty() {
        queue.supprimeElement(); // This should throw exception
    }
}