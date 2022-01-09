package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.validators.PhoneNumberValidator;

public class FirstCharacterZeroPhoneNumberValidator
        implements PhoneNumberValidator {

    public boolean numberIsValid(String phoneNumber) {
        var firstCharacter = phoneNumber.split("")[0];
        return !firstCharacter.equals("0");
    }
}
