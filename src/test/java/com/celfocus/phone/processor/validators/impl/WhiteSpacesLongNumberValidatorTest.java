package com.celfocus.phone.processor.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WhiteSpacesLongNumberValidatorTest {

    private WhiteSpacesLongNumberValidator whiteSpacesLongNumberValidator;

    @BeforeEach
    void setup() {
        whiteSpacesLongNumberValidator = new WhiteSpacesLongNumberValidator();
    }

    @Test
    @DisplayName("Should return 'true' when the number not contain invalid white spaces")
    void shouldReturnTrueWhenTheNumberNotContainInvalidWhiteSpaces() {
        assertTrue(whiteSpacesLongNumberValidator.numberIsValid("+55 3 5 1 6 3 5 1"));
        assertTrue(whiteSpacesLongNumberValidator.numberIsValid("+55  3 5 1 6 3 5 1"));
        assertTrue(whiteSpacesLongNumberValidator.numberIsValid("+55   3 5 1 6 3 5 1"));

        assertTrue(whiteSpacesLongNumberValidator.numberIsValid("0035 1 6 3 5 1"));
        assertTrue(whiteSpacesLongNumberValidator.numberIsValid("003 5 1 6 3 5 1"));
        assertTrue(whiteSpacesLongNumberValidator.numberIsValid("003 5 1 6 3 5 1"));
    }

    @Test
    @DisplayName("Should return 'false' when the number contain invalid white spaces")
    void shouldReturnTrueWhenTheNumberContainInvalidWhiteSpaces() {
        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("+ 553516351"));
        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("+ 55 3 5 1 6 3 5 1"));
        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("+  55  3 5 1 6 3 5 1"));
        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("+   55   3 5 1 6 3 5 1"));

        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("00 35 1 6 3 5 1"));
        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("00  3 5 1 6 3 5 1"));
        assertFalse(whiteSpacesLongNumberValidator.numberIsValid("00   3 5 1 6 3 5 1"));
    }
}