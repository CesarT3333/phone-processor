package com.celfocus.phone.processor.validators.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortNumberWhiteSpacesValidatorTest {
    private ShortNumberWhiteSpacesValidator shortNumberWhiteSpacesValidator;

    @BeforeEach
    void setup() {
        shortNumberWhiteSpacesValidator = new ShortNumberWhiteSpacesValidator();
    }

    @Test
    @DisplayName("Must return 'false' if string not have white spaces")
    void mustReturnFalseIfStringNotHaveWhiteSpaces() {
        assertTrue(shortNumberWhiteSpacesValidator.numberIsValid("FSDFSK=ofa"));
        assertTrue(shortNumberWhiteSpacesValidator.numberIsValid("12356"));
        assertTrue(shortNumberWhiteSpacesValidator.numberIsValid("kdjfu"));
    }

    @Test
    @DisplayName("Must return 'true' if string have white spaces")
    void mustReturnTrueIfStringHaveWhiteSpaces() {
        assertFalse(shortNumberWhiteSpacesValidator.numberIsValid("FSDFSK=o fa"));
        assertFalse(shortNumberWhiteSpacesValidator.numberIsValid("123 56"));
        assertFalse(shortNumberWhiteSpacesValidator.numberIsValid("kdj   fu"));
    }

}