package com.company;

import com.company.FunctionManager.ValidationManager;
import com.company.Object.Animal;
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

        ValidationManager manager = ValidationManager.createNormalValidator();
//        if (manager.validate(person)) {
//            person.toString();
//        }
//        else {
//            System.out.println(manager.getMessages());
//        }

        List<String> personValidationErrors = manager.validate(person);
        if (personValidationErrors.isEmpty()) {
            System.out.println("person = " + person);
        } else {
            System.out.println("validationErrors = " + personValidationErrors);
        }

	    Animal animal = new Animal();
	    animal.setID(199);
	    animal.setAge(31);
	    animal.setName("hophanminh");
	    animal.setEmail("hophanminhgmail@gmail.com");
	    animal.setIDSerialNumber("         ");
	    List<String> validationErrors = manager.validate(animal);
	    if (validationErrors.isEmpty()) {
		    System.out.println("person = " + person);
	    } else {
		    System.out.println("validationErrors = " + validationErrors);
	    }

    }
}
