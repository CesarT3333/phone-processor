package com.celfocus.phone.processor.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PhoneNumber {
    private String number;

    @Setter
    private String countryCode;

}
