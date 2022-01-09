package com.celfocus.phone.processor;

import com.celfocus.phone.processor.domain.Country;
import com.celfocus.phone.processor.domain.PhoneNumber;
import com.celfocus.phone.processor.utils.CountryCodeCounter;
import com.celfocus.phone.processor.utils.LongNumberPrefixUtil;
import com.celfocus.phone.processor.validators.ValidatorProvider;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Collectors;

public final class PhoneNumberClassifier {

    private final ValidatorProvider validatorProvider;
    private final List<Country> countries;

    public PhoneNumberClassifier(List<Country> countries) {
        this.countries = countries;
        validatorProvider = ValidatorProvider.getInstance(countries);
    }

    public List<Country> execute(List<PhoneNumber> phoneNumbers) {
        var shortNumbers = filterShortNumbers(phoneNumbers);
        var longNumbers = filterLongNumbers(phoneNumbers);

        var shortNumberCount = shortNumbers.size();

        return CountryCodeCounter.count(longNumbers, shortNumberCount, countries);

    }

    private List<PhoneNumber> filterShortNumbers(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream()
                .filter(this::validateShortNumber)
                .collect(Collectors.toList());
    }

    private List<PhoneNumber> filterLongNumbers(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream()
                .filter(this::validateLongNumber)
                .map(this::setCountryCode)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    private PhoneNumber setCountryCode(PhoneNumber phoneNumber) {
        var countryCode = LongNumberPrefixUtil.getCountryCode(phoneNumber.getNumber());
        phoneNumber.setCountryCode(countryCode);
        return phoneNumber;
    }

    private boolean validateLongNumber(PhoneNumber phoneNumber) {
        var phoneNumberString = phoneNumber.getNumber();
        return validatorProvider.getLongNumberValidators()
                .stream()
                .allMatch(validator -> validator.numberIsValid(phoneNumberString));
    }

    private boolean validateShortNumber(PhoneNumber phoneNumber) {
        var phoneNumberString = phoneNumber.getNumber();
        return validatorProvider.getShortNumberValidators()
                .stream()
                .allMatch(validator -> validator.numberIsValid(phoneNumberString));
    }

}
