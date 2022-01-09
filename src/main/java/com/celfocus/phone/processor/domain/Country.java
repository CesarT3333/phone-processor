package com.celfocus.phone.processor.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Country {
    private String name;
    private String countryCode;

    @Setter
    private long finalCount;

    @Override
    public String toString() {
        return name + ": " + finalCount;
    }
}
