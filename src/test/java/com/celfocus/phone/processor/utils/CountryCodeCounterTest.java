package com.celfocus.phone.processor.utils;

import com.celfocus.phone.processor.domain.Country;
import com.celfocus.phone.processor.domain.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryCodeCounterTest {

    @Test
    @DisplayName("Should count country codes")
    void shouldCountCountryCodes() {
        var mockCountries = new ArrayList<>(Arrays.asList(
                Country.builder().name("Canada").countryCode("1").build(),
                Country.builder().name("United States").countryCode("1").build(),
                Country.builder().name("Portugal").countryCode("351").build(),
                Country.builder().name("United Kingdom").countryCode("44").build(),
                Country.builder().name("Indonesia").countryCode("62").build()
        ));

        var mockLongNumbers = new ArrayList<>(Arrays.asList(
                PhoneNumber.builder().number("+44 65465444").countryCode("44").build(),
                PhoneNumber.builder().number("+351 918 878 443").countryCode("351").build(),
                PhoneNumber.builder().number("00198798798").countryCode("1").build(),
                PhoneNumber.builder().number("+62 12354634654").countryCode("62").build()
        ));

        var countryCounted = CountryCodeCounter
                .count(mockLongNumbers, 4, mockCountries);

        assertEquals(4, countryCounted.size());

        var country1 = countryCounted.get(0);
        assertEquals(1, country1.getFinalCount());
        assertEquals("1", country1.getCountryCode());
        assertEquals("Canada", country1.getName());

        var country2 = countryCounted.get(1);
        assertEquals(5, country2.getFinalCount());
        assertEquals("351", country2.getCountryCode());
        assertEquals("Portugal", country2.getName());

        var country3 = countryCounted.get(2);
        assertEquals(1, country3.getFinalCount());
        assertEquals("44", country3.getCountryCode());
        assertEquals("United Kingdom", country3.getName());

        var country4 = countryCounted.get(3);
        assertEquals(1, country4.getFinalCount());
        assertEquals("62", country4.getCountryCode());
        assertEquals("Indonesia", country4.getName());

    }

}