package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.validators.PhoneNumberValidator;

public class ShortNumberWhiteSpacesValidator
        implements PhoneNumberValidator {

    public boolean numberIsValid(String phoneNumber) {
        return !phoneNumber.matches(".*\\s+.*");
    }

}
