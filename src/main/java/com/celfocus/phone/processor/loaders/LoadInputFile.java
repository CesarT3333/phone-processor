package com.celfocus.phone.processor.loaders;

import com.celfocus.phone.processor.domain.PhoneNumber;

public class LoadInputFile extends LoadFile<PhoneNumber> {

    public LoadInputFile(String inputFile) {
        super(inputFile);
    }

    protected PhoneNumber processLine(String line) {
        return PhoneNumber.builder()
                .number(line)
                .build();
    }
}
