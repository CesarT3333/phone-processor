package com.celfocus.phone.processor.validators.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortNumberLengthValidatorTest {
    private ShortNumberLengthValidator shortNumberLengthValidator;

    @BeforeEach
    void setup() {
        shortNumberLengthValidator = new ShortNumberLengthValidator();
    }

    @Test
    @DisplayName("Should return 'true' when the number is within range.")
    void shouldReturnTrueWhenTheNumberIsWithinRange() {
        assertTrue(shortNumberLengthValidator.numberIsValid("123456"));
        assertTrue(shortNumberLengthValidator.numberIsValid("5555"));
        assertTrue(shortNumberLengthValidator.numberIsValid("5556"));
        assertTrue(shortNumberLengthValidator.numberIsValid("165492"));
    }

    @Test
    @DisplayName("Should return 'false' when the number is out of range.")
    void shouldReturnTrueWhenTheNumberIsOutOfRange() {
        assertFalse(shortNumberLengthValidator.numberIsValid("123"));
        assertFalse(shortNumberLengthValidator.numberIsValid(""));
        assertFalse(shortNumberLengthValidator.numberIsValid("3216546"));
        assertFalse(shortNumberLengthValidator.numberIsValid("741852964564654"));
    }

}