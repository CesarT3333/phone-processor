package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.utils.FirstCharactersUtil;
import com.celfocus.phone.processor.validators.PhoneNumberValidator;

public class WhiteSpacesLongNumberValidator
        implements PhoneNumberValidator {

    public boolean numberIsValid(String phoneNumber) {
        var splitedPhoneNumber = phoneNumber.split("");

        if (FirstCharactersUtil.stringStartsWithCharacter(phoneNumber, "+")) {
            return !splitedPhoneNumber[1].equals(" ");
        } else if (FirstCharactersUtil.stringStartsWithCharacter(phoneNumber, "00")) {
            return !splitedPhoneNumber[2].equals(" ");
        }

        return true;
    }

}
