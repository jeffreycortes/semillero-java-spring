package com.semillerogtc.gtcusermanagament.components;

import org.springframework.stereotype.Component;

@Component
public class UsersValidation {
    public boolean execute(String user) {
        //return  (user == "Jeff") ? true : false; //1. if ternario
        //return  (user == "Jeff"); //2. retornar la condición

        if (!(user == "Jeff"))
            return false;


        return true;
    }
}