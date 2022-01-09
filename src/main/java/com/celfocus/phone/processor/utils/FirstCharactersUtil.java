package com.celfocus.phone.processor.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FirstCharactersUtil {

    public static boolean stringStartsWithCharacter(String string, String character) {
        var stringSplited = Arrays.asList(string.split(""));
        var characterSplited = character.split("");

        var count = 0;
        for (String c : characterSplited) {
            if (!c.equals(stringSplited.get(count))) {
                return false;
            }
        }

        return true;
    }
}
