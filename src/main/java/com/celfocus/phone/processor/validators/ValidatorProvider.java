package com.celfocus.phone.processor.validators;

import com.celfocus.phone.processor.domain.Country;
import com.celfocus.phone.processor.validators.impl.CharactersValidator;
import com.celfocus.phone.processor.validators.impl.CountryCodeValidator;
import com.celfocus.phone.processor.validators.impl.FirstCharacterZeroPhoneNumberValidator;
import com.celfocus.phone.processor.validators.impl.LongNumberLengthValidator;
import com.celfocus.phone.processor.validators.impl.ShortNumberLengthValidator;
import com.celfocus.phone.processor.validators.impl.ShortNumberWhiteSpacesValidator;
import com.celfocus.phone.processor.validators.impl.WhiteSpacesLongNumberValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidatorProvider {

    private static ValidatorProvider instance;

    private final CharactersValidator charactersValidator;

    private final ShortNumberLengthValidator shortNumberLengthValidator;
    private final ShortNumberWhiteSpacesValidator shortNumberWhiteSpacesValidator;
    private final FirstCharacterZeroPhoneNumberValidator firstCharacterZeroPhoneNumberValidator;

    private final WhiteSpacesLongNumberValidator whiteSpacesLongNumberValidator;
    private final LongNumberLengthValidator longNumberLengthValidator;
    private final CountryCodeValidator countryCodeValidator;

    private ValidatorProvider(List<Country> countries) {
        this.charactersValidator = new CharactersValidator();

        this.shortNumberLengthValidator = new ShortNumberLengthValidator();
        this.shortNumberWhiteSpacesValidator = new ShortNumberWhiteSpacesValidator();
        this.firstCharacterZeroPhoneNumberValidator = new FirstCharacterZeroPhoneNumberValidator();

        this.whiteSpacesLongNumberValidator = new WhiteSpacesLongNumberValidator();
        this.longNumberLengthValidator = new LongNumberLengthValidator();

        var countryCodesList = countries.stream()
                .map(Country::getCountryCode)
                .collect(Collectors.toList());

        this.countryCodeValidator = new CountryCodeValidator(countryCodesList);
    }

    public static ValidatorProvider getInstance(List<Country> countries) {
        if (instance == null) {
            instance = new ValidatorProvider(countries);
        }
        return instance;
    }

    public List<PhoneNumberValidator> getShortNumberValidators() {
        return Arrays.asList(
                charactersValidator,
                shortNumberLengthValidator,
                shortNumberWhiteSpacesValidator,
                firstCharacterZeroPhoneNumberValidator
        );
    }

    public List<PhoneNumberValidator> getLongNumberValidators() {
        return Arrays.asList(
                charactersValidator,
                whiteSpacesLongNumberValidator,
                longNumberLengthValidator,
                countryCodeValidator
        );
    }

}
