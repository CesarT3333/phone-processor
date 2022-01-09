package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.utils.FirstCharactersUtil;
import com.celfocus.phone.processor.validators.PhoneNumberValidator;

public class CharactersValidator
        implements PhoneNumberValidator {

    @Override
    public boolean numberIsValid(String phoneNumber) {

        var phoneToTest = phoneNumber.replace(" ", "");

        if (FirstCharactersUtil.stringStartsWithCharacter(phoneToTest, "+")) {
            phoneToTest = phoneToTest.substring(1, phoneToTest.length() - 1);
        } else if (FirstCharactersUtil.stringStartsWithCharacter(phoneToTest, "00")) {
            phoneToTest = phoneToTest.substring(2, phoneToTest.length() - 1);
        }

        return phoneToTest.matches("^[1-9\\s*]\\d*(\\.\\d+)?$");
    }

}
