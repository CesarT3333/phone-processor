package com.celfocus.phone.processor.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LongNumberPrefixUtil {

    public static String getCountryCode(String phoneNumber) throws NumberParseException {
        var phoneUtil = PhoneNumberUtil.getInstance();

        if (FirstCharactersUtil.stringStartsWithCharacter(phoneNumber, "00")) {
            phoneNumber = "+" + phoneNumber.substring(2);
        }

        Phonenumber.PhoneNumber numberProto = phoneUtil
                .parse(phoneNumber, "");

        return numberProto.getCountryCode() + "";


    }
}
