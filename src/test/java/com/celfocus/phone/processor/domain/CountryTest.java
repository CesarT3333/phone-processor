package com.celfocus.phone.processor.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryTest {

    @Test
    @DisplayName("should return 'toString' correctly")
    void shouldReturnToStringCorrectly() {
        var country = Country.builder()
                .name("Brazil")
                .finalCount(45)
                .build();

        assertEquals("Brazil: 45", country.toString());
    }
}