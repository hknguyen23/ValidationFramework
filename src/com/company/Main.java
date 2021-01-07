package com.company;

import com.company.FunctionManager.ValidateManager;
import com.company.Object.Person;

public class Main {

    public static void main(String[] args) {
        Person a = new Person();

        a.setID(199);
        a.setAge(30);
        a.setName("testtesttesttest");
        a.setEmail("hophanminhgmail@gmail.com");
        a.setIDSerialNumber("12345678");
        a.setPassword("abc");
        a.setDateOfBirth("31/04/1975");

        ValidateManager manager = new ValidateManager();
        if (manager.validate(a)) {
            System.out.println(a.toString());
        }
        else {
            System.out.println(manager.getMessages());
        }
    }
}
