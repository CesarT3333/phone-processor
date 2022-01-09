package com.celfocus.phone.processor.validators.impl;

import com.celfocus.phone.processor.utils.LongNumberPrefixUtil;
import com.celfocus.phone.processor.validators.PhoneNumberValidator;
import com.google.i18n.phonenumbers.NumberParseException;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CountryCodeValidator
        implements PhoneNumberValidator {

    private final List<String> countryCodes;

    public boolean numberIsValid(String phoneNumber) {

        try {
            var countryCode = LongNumberPrefixUtil.getCountryCode(phoneNumber);
            return countryCodes.contains(countryCode);

        } catch (NumberParseException e) {

            return false;
        }

    }
}
