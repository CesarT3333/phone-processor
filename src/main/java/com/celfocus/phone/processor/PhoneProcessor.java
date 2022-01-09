package com.celfocus.phone.processor;

import com.celfocus.phone.processor.loaders.LoadCountryFile;
import com.celfocus.phone.processor.loaders.LoadInputFile;
import lombok.SneakyThrows;

public class PhoneProcessor {

    @SneakyThrows
    public static void main(String[] args) {
        var countries = new LoadCountryFile().load();
        var inputNumbers = new LoadInputFile(args[0]).load();
        var phoneNumberClassifier = new PhoneNumberClassifier(countries);

        var processedCountries = phoneNumberClassifier.execute(inputNumbers);

        processedCountries.forEach(System.out::println);
    }

}
