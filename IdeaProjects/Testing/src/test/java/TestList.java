import jUnit.List;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestList {

    private List testPeople = new List();

    @Before
    public void init() {
        testPeople.add("Peter");
        testPeople.add("Jane");
    }

    @Test
    public void testSize() {
        assertEquals("Size check", 2, testPeople.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(testPeople.isEmpty());

        testPeople.removeAll();
        assertTrue(testPeople.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void remove() {
        testPeople.remove("Bob");
    }

    @Test
    public void testRemoveAll() {
        testPeople.removeAll();
        assertTrue(testPeople.isEmpty());
    }
}
