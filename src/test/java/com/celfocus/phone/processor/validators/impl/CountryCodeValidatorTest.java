package com.celfocus.phone.processor.validators.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountryCodeValidatorTest {

    private CountryCodeValidator countryCodeValidator;

    @BeforeEach
    void setup() {
        countryCodeValidator = new CountryCodeValidator(Arrays.asList("55", "44", "351", "1"));
    }

    @Test
    @DisplayName("Must return 'true' when the number contain a valid country number")
    void mustReturnTrueWhenTheNumberContainAValidCountryNumber() {
        assertTrue(countryCodeValidator.numberIsValid("+4465465444"));
        assertTrue(countryCodeValidator.numberIsValid("+443489002"));
        assertTrue(countryCodeValidator.numberIsValid("+3513489002"));
        assertTrue(countryCodeValidator.numberIsValid("+3513489002"));
        assertTrue(countryCodeValidator.numberIsValid("+198798798"));

        assertTrue(countryCodeValidator.numberIsValid("004465465444"));
        assertTrue(countryCodeValidator.numberIsValid("00443489002"));
        assertTrue(countryCodeValidator.numberIsValid("003513489002"));
        assertTrue(countryCodeValidator.numberIsValid("003513489002"));
        assertTrue(countryCodeValidator.numberIsValid("00198798798"));
    }

    @Test
    @DisplayName("Must return 'false' when the number not contain a valid country number")
    void mustReturnTrueWhenTheNumberNotContainAValidCountryNumber() {
        assertFalse(countryCodeValidator.numberIsValid("+565465444"));
        assertFalse(countryCodeValidator.numberIsValid("+43489002"));
        assertFalse(countryCodeValidator.numberIsValid("+513489002"));
        assertFalse(countryCodeValidator.numberIsValid("+313489002"));
        assertFalse(countryCodeValidator.numberIsValid("+987938798"));

        assertFalse(countryCodeValidator.numberIsValid("00565465444"));
        assertFalse(countryCodeValidator.numberIsValid("0043489002"));
        assertFalse(countryCodeValidator.numberIsValid("00513489002"));
        assertFalse(countryCodeValidator.numberIsValid("00313489002"));
        assertFalse(countryCodeValidator.numberIsValid("00987938798"));
    }

}