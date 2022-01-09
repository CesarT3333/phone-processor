package com.celfocus.phone.processor.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ValidatorProviderTest {
    private ValidatorProvider validatorProvider;

    @BeforeEach
    void setup() {
        validatorProvider = ValidatorProvider.getInstance(List.of());
    }

    @Test
    @DisplayName("Must create dependencies")
    void mustCreateDependencies() {
        assertNotNull(validatorProvider);

        assertEquals(4, validatorProvider.getLongNumberValidators().size());
        assertEquals(4, validatorProvider.getShortNumberValidators().size());
    }

}