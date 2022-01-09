package com.celfocus.phone.processor.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstCharacterZeroPhoneNumberValidatorTest {

    private FirstCharacterZeroPhoneNumberValidator firstCharacterZeroPhoneNumberValidator;

    @BeforeEach
    void setup() {
        firstCharacterZeroPhoneNumberValidator = new FirstCharacterZeroPhoneNumberValidator();
    }

    @Test
    @DisplayName("Must return 'true' if the number not beginning with 0")
    void mustReturnTrueIfTheNumberNotBeginningWith0() {
        assertTrue(firstCharacterZeroPhoneNumberValidator.numberIsValid("10368432"));
        assertTrue(firstCharacterZeroPhoneNumberValidator.numberIsValid("8345"));
        assertTrue(firstCharacterZeroPhoneNumberValidator.numberIsValid("12345"));
    }

    @Test
    @DisplayName("Must return 'false' if the number not beginning with 0")
    void mustReturnFalseIfTheNumberBeginningWith0() {
        assertFalse(firstCharacterZeroPhoneNumberValidator.numberIsValid("065ds"));
        assertFalse(firstCharacterZeroPhoneNumberValidator.numberIsValid("05752"));
        assertFalse(firstCharacterZeroPhoneNumberValidator.numberIsValid("0"));
    }

}