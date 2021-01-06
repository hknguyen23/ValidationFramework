package com.company;

import com.company.FunctionManager.ValidateManager;
import com.company.Object.Person;

public class Main {

    public static void main(String[] args) {
        Person a = new Person();

        a.setID(201);
        a.setAge(51);
        a.setName("abcd");
        a.setEmail("hophanminhgmail@gmail.com");
        a.setIDSerialNumber("123456789");

        ValidateManager manager = new ValidateManager();
        if (manager.validate(a)) {
            a.toString();
        }
        else {
            System.out.println(manager.getMessages());
        }
    }
}
