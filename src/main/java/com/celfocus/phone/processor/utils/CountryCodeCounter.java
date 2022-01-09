package com.celfocus.phone.processor.utils;

import com.celfocus.phone.processor.constants.LongNumberConstants;
import com.celfocus.phone.processor.domain.Country;
import com.celfocus.phone.processor.domain.PhoneNumber;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountryCodeCounter {

    public static List<Country> count(List<PhoneNumber> longNumbers, int shortNumberCount, List<Country> countries) {
        return countries.stream()
                .peek(country -> setCount(country, longNumbers, shortNumberCount))
                .filter(i -> i.getFinalCount() > 0)
                .collect(Collectors.toList());
    }

    private static void setCount(Country country, List<PhoneNumber> longNumbers, int shortNumberCount) {
        var longNumbersFiltered = longNumbers.stream()
                .filter(ln -> ln.getCountryCode().equals(country.getCountryCode()))
                .collect(Collectors.toList());

        var count = longNumbersFiltered.size();

        longNumbers.removeAll(longNumbersFiltered);

        if (country.getCountryCode().equals(LongNumberConstants.POUTUGAL_COUNTRY_CODE)) {
            count += shortNumberCount;
        }

        country.setFinalCount(count);
    }


}
