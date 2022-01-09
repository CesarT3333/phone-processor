package com.celfocus.phone.processor.utils;

import com.celfocus.phone.processor.exception.InvalidNumberValueException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RangeUtil {

    public static boolean between(int number, int min, int max) {

        if (min > max) {
            throw new InvalidNumberValueException(min, max);
        }

        return number >= min && number <= max;
    }

}
