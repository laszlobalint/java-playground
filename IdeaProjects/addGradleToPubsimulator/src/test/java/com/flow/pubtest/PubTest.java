package com.flow.pubtest;

import com.flow.pubsimluator.Barkeep;
import com.flow.pubsimluator.Human;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PubTest {
    Human human = new Human("Mr. Test", 40, true, 600);
    Barkeep barkeep = new Barkeep("Ms. Rapid", 45, false, 100);

    @Test
    public void testSetAge() {
        int expectedAge = 30;
        assertEquals(expectedAge, 30);
        assertEquals(true, human.isInPub());
        assertNotEquals(true, human.isInPub());
        }
    }
