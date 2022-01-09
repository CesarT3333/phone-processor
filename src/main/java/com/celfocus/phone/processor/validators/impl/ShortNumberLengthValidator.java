package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.constants.ShortNumberConstants;
import com.celfocus.phone.processor.utils.RangeUtil;
import com.celfocus.phone.processor.validators.PhoneNumberValidator;

public class ShortNumberLengthValidator
        implements PhoneNumberValidator {

    @Override
    public boolean numberIsValid(String phoneNumber) {
        return RangeUtil.between(
                phoneNumber.length(),
                ShortNumberConstants.MIN_LENGTH,
                ShortNumberConstants.MAX_LENGTH
        );
    }

}
