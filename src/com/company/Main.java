package com.company;

import com.company.FunctionManager.ValidateManager;
import com.company.Object.Person;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        Person person = new Person();

        person.setID(101);
        person.setAge(31);
        person.setName(" ");
        person.setEmail("hophanminhgmail@gmail.com");
        person.setIDSerialNumber("         ");

        ValidateManager manager = ValidateManager.createFailFastValidator();
//        if (manager.validate(person)) {
//            person.toString();
//        }
//        else {
//            System.out.println(manager.getMessages());
//        }

        List<String> validationErrors = manager.validate(person);
        if (validationErrors.isEmpty()) {
            System.out.println("person = " + person);
        } else {
            System.out.println("validationErrors = " + validationErrors);
        }
    }
}
