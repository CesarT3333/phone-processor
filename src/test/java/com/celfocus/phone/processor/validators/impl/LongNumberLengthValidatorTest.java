package com.celfocus.phone.processor.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongNumberLengthValidatorTest {

    private LongNumberLengthValidator longNumberLengthValidator;

    @BeforeEach
    void setup() {
        longNumberLengthValidator = new LongNumberLengthValidator();
    }

    @Test
    @DisplayName("Should return 'true' when the number is within range.")
    void shouldReturnTrueWhenTheNumberIsWithinRange() {
        assertTrue(longNumberLengthValidator.numberIsValid("+565455554"));
        assertTrue(longNumberLengthValidator.numberIsValid("+5 6 5 4 5 5 5 5 4"));
        assertTrue(longNumberLengthValidator.numberIsValid("+164351976 32183"));

        assertTrue(longNumberLengthValidator.numberIsValid("00565455554"));
        assertTrue(longNumberLengthValidator.numberIsValid("0016435197632183"));

        assertTrue(longNumberLengthValidator.numberIsValid("565455554"));
        assertTrue(longNumberLengthValidator.numberIsValid("16435197632183"));
    }

    @Test
    @DisplayName("Should return 'false' when the number is out of range.")
    void shouldReturnTrueWhenTheNumberIsOutOfRange() {
        assertFalse(longNumberLengthValidator.numberIsValid("123"));
        assertFalse(longNumberLengthValidator.numberIsValid(""));
        assertFalse(longNumberLengthValidator.numberIsValid("3216546"));
        assertFalse(longNumberLengthValidator.numberIsValid("741852964564654"));

        assertFalse(longNumberLengthValidator.numberIsValid("+56545554"));
        assertFalse(longNumberLengthValidator.numberIsValid("+16435197632h183"));

        assertFalse(longNumberLengthValidator.numberIsValid("0056545554"));
        assertFalse(longNumberLengthValidator.numberIsValid("00164351976321483"));

        assertFalse(longNumberLengthValidator.numberIsValid("56545554"));
        assertFalse(longNumberLengthValidator.numberIsValid("164351976332183"));
    }

}