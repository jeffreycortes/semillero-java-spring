package com.semillerogtc.gtcusermanagament.domain;

import org.springframework.beans.factory.annotation.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String value;
    final Pattern EMAIL_FORMAT_REGEX = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);

    public Email(String value) {
        if (value == null || !isValid(value))
            throw new InvalidEmailException();

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValid(String email) {
        Matcher matcher = EMAIL_FORMAT_REGEX.matcher(email);
        return matcher.find();
    }
}
