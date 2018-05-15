package pl.coderslab.converter;

import org.springframework.core.convert.converter.Converter;

public class BooleanConverter implements Converter<String, Boolean> {
    public BooleanConverter() {
    }

    public Boolean convert(String s) {
        return Boolean.getBoolean(s);
    }
}
