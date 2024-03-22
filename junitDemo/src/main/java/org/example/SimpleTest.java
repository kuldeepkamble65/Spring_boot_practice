package org.example;

import org.junit.Test;

import static org.example.ServiceImpl.add;
import static org.junit.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void testAdditionSuccess() {
        boolean flag = false;
        int result = add(2, 3);
        if (result == 5) {
            flag = true;
        }
        assertEquals("2 + 3 should be 5", true, flag);
    }

    @Test
    public void testAdditionFailed() {
        boolean flag = false;
        int result = add(9, 3);
        if (result == 5) {
            flag = true;
        }
        assertEquals( false, flag);

    }


}