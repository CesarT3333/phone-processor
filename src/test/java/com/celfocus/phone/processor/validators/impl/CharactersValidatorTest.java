package com.celfocus.phone.processor.validators.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharactersValidatorTest {

    private CharactersValidator charactersValidator;

    @BeforeEach
    void setup() {
        charactersValidator = new CharactersValidator();
    }

    @Test
    @DisplayName("Should return 'true' when the number contains no special characters except the first character")
    void shouldReturnTrueWhenTheNumberContainsNoSpecialCharactersExceptTheFirstCharacter() {
        assertTrue(charactersValidator.numberIsValid("+555499999"));
        assertTrue(charactersValidator.numberIsValid("00499999"));
        assertTrue(charactersValidator.numberIsValid("+66499999"));

        assertTrue(charactersValidator.numberIsValid("+66499 999"));
        assertTrue(charactersValidator.numberIsValid("+66499  999"));
        assertTrue(charactersValidator.numberIsValid("+66499    999"));
        assertTrue(charactersValidator.numberIsValid("+6 6 4 9 9 9 9 9"));
    }

    @Test
    @DisplayName("Should return 'false' when the number contains special characters")
    void shouldReturnFalseWhenTheNumberContainsSpecialCharacters() {
        assertFalse(charactersValidator.numberIsValid("-(800)-123-4567"));
        assertFalse(charactersValidator.numberIsValid("0049fff9999"));
        assertFalse(charactersValidator.numberIsValid("(926) 1234567"));
        assertFalse(charactersValidator.numberIsValid("++555499999"));
    }

}