package com.celfocus.phone.processor.exception;

public final class InvalidNumberValueException
        extends RuntimeException {
    public InvalidNumberValueException(int min, int max) {
        super("Min number must to be minor of the max number: min = " + min + " max = " + max);
    }
}
