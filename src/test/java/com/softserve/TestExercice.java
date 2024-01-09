package com.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestExercice {

    private Exercice exercice;

    @BeforeEach
    public void reset() {
        exercice = new Exercice();
    }

    @Test
    void testProcessChainWhenChainIsNullExpectedException() {
        final String chain = null;
        Exception exception = assertThrows(Exception.class, () -> {
            exercice.processChain(chain);
        });
        assertEquals("The chain should be not null or empty.", exception.getMessage());
    }

    @Test
    void testProcessChainWhenChainHasSpacesExpectedChainWithoutSpacesAndWithoutDuplicates() throws Exception {
        final String chain = " AABBCCD1 12233 ";
        String result = exercice.processChain(chain);
        assertEquals("ABCD123", result);
    }

    @Test
    void testProcessChainWhenChainIsNotOrderedExpectedChainWithoutDuplicates() throws Exception {
        final String chain = " A 2YE 41 T1 B2 ABAT";
        String result = exercice.processChain(chain);
        assertEquals("A2YE41TB", result);
    }

    @Test
    void testProcessChainWhenChainIsEmptyExpectedChainException() throws Exception {
        final String chain = "";
        Exception exception = assertThrows(Exception.class, () -> {
            exercice.processChain(chain);
        });
        assertEquals("The chain should be not null or empty.", exception.getMessage());
    }

    @Test
    void testProcessChainWhenChainHasOneSpaceExpectedChainException() throws Exception {
        final String chain = " ";
        Exception exception = assertThrows(Exception.class, () -> {
            exercice.processChain(chain);
        });
        assertEquals("The chain should be empty.", exception.getMessage());
    }

}
