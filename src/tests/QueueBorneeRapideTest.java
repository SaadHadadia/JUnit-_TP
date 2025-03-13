package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Queue.QueueBorneeRapide;

public class QueueBorneeRapideTest {

    private QueueBorneeRapide queue;
    private final int CAPACITY = 5;

    @Before
    public void setUp() {
        queue = new QueueBorneeRapide(CAPACITY);
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
        new QueueBorneeRapide(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithZeroCapacity() {
        new QueueBorneeRapide(0);
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
    }

    @Test
    public void testArrayCopyBehavior() {
        // Add several elements
        queue.ajouteElement(10);
        queue.ajouteElement(20);
        queue.ajouteElement(30);

        // Remove first element, should shift array
        assertEquals(10, queue.supprimeElement());
        assertEquals(2, queue.taille());

        // Add another element
        queue.ajouteElement(40);
        assertEquals(3, queue.taille());

        // Verify all elements
        assertEquals(20, queue.supprimeElement());
        assertEquals(30, queue.supprimeElement());
        assertEquals(40, queue.supprimeElement());
        assertTrue(queue.estVide());
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