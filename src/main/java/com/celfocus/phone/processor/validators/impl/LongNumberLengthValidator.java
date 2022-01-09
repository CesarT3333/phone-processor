package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.constants.LongNumberConstants;
import com.celfocus.phone.processor.utils.FirstCharactersUtil;
import com.celfocus.phone.processor.utils.RangeUtil;
import com.celfocus.phone.processor.validators.PhoneNumberValidator;

public class LongNumberLengthValidator
        implements PhoneNumberValidator {

    public boolean numberIsValid(String phoneNumber) {

        var phoneToTest = phoneNumber.replace(" ", "");

        if (FirstCharactersUtil.stringStartsWithCharacter(phoneToTest, "+")) {
            phoneToTest = phoneToTest.substring(1);
        } else if (FirstCharactersUtil.stringStartsWithCharacter(phoneNumber, "00")) {
            phoneToTest = phoneToTest.substring(2);
        }

        return RangeUtil.between(
                phoneToTest.length(),
                LongNumberConstants.MIN_LENGTH,
                LongNumberConstants.MAX_LENGTH
        );
    }
}
