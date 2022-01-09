package com.celfocus.phone.processor.utils;

import com.celfocus.phone.processor.exception.InvalidNumberValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangeUtilTest {

    @Test
    @DisplayName("Must return 'true' if the number is between the range")
    void mustReturnTrueIfTheNumberIsBetweenTheRange() {
        assertTrue(RangeUtil.between(4, 0, 6));
        assertTrue(RangeUtil.between(40, 39, 41));
        assertTrue(RangeUtil.between(-1, -2, 0));
    }

    @Test
    @DisplayName("Must return 'false' if the number is out of the range")
    void mustReturnTrueIfTheNumberIsOutOfTheRange() {
        assertFalse(RangeUtil.between(4, 10, 15));
        assertFalse(RangeUtil.between(40, 10, 39));
        assertFalse(RangeUtil.between(-1, -22, -2));
    }

    @Test
    @DisplayName("Must throw an exception if the number 'max' is minor of the number 'min'")
    void mustThrowAnExceptionIfTheNumberMinIsMinorOfTheNumberMax() {

        var invalidNumberValueException1 = assertThrows(
                InvalidNumberValueException.class,
                () -> RangeUtil.between(0, 8, 4),
                "Exception expected but did not occur."
        );

        var expectedexceptionMessage1 = "Min number must to be minor of the max number: min = 8 max = 4";

        assertEquals(expectedexceptionMessage1, invalidNumberValueException1.getMessage());

        var invalidNumberValueException2 = assertThrows(
                InvalidNumberValueException.class,
                () -> RangeUtil.between(0, -4, -10),
                "Exception expected but did not occur."
        );

        var expectedexceptionMessage2 = "Min number must to be minor of the max number: min = -4 max = -10";

        assertEquals(expectedexceptionMessage2, invalidNumberValueException2.getMessage());

    }

}