package com.celfocus.phone.processor.loaders;

import com.celfocus.phone.processor.domain.Country;

public class LoadCountryFile
        extends LoadFile<Country> {

    private static final String FILE_NAME = "coutryCodes.txt";

    public LoadCountryFile() {
        super(FILE_NAME);
    }

    @Override
    protected Country processLine(String line) {
        String[] split = line.split("-");

        return Country.builder()
                .name(split[0])
                .countryCode(split[1])
                .build();
    }

}
