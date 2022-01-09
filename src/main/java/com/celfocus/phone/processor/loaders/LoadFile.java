package com.celfocus.phone.processor.loaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class LoadFile<T> {

    private final String fileName;

    protected LoadFile(String fileName) {
        this.fileName = fileName;
    }

    public List<T> load() {
        var classLoader = getClass().getClassLoader();
        var inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        return createCountryList(inputStream);
    }

    private List<T> createCountryList(InputStream is) {
        var countries = new ArrayList<T>();

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.equals("")) {
                    countries.add(processLine(line));
                }

            }

            return countries;

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    protected abstract T processLine(String line);
}
