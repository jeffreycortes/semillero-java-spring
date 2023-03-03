package com.semillerogtc.gtcusermanagament.components;

import org.springframework.stereotype.Component;

@Component
public class UsersValidation {
    public boolean execute(String user) {
        return  (user == "Jeff");
    }
}