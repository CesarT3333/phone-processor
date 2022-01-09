package com.celfocus.phone.processor.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstCharactersUtilTest {

    @Test
    @DisplayName("Must return 'true' if string starts with character")
    void mustReturnTrueIfStringStartsWithCharacter() {
        assertTrue(FirstCharactersUtil.stringStartsWithCharacter("00ksdgffsd", "00"));
        assertTrue(FirstCharactersUtil.stringStartsWithCharacter("7209ksjd", "7"));
        assertTrue(FirstCharactersUtil.stringStartsWithCharacter("+-098786", "+"));
    }

    @Test
    @DisplayName("Must return 'false' if string not starts with character")
    void mustReturnFalseIfStringNotStartsWithCharacter() {
        assertFalse(FirstCharactersUtil.stringStartsWithCharacter("00ksdgffsd", "8"));
        assertFalse(FirstCharactersUtil.stringStartsWithCharacter("7209ksjd", "44"));
        assertFalse(FirstCharactersUtil.stringStartsWithCharacter("+-098786", "="));
    }

}