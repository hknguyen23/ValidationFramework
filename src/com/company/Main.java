package com.company;

import com.company.Constant.ValidatorStrategy;
import com.company.FunctionManager.ValidationManager;
import com.company.Object.Animal;
import com.company.Object.Person;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Person person = new Person();
		person.setID(201);
		person.setAge(31);
		person.setName("Minhhhhhhhh");
		person.setEmail("hophanminhgmail@gmail.com");
		person.setIDSerialNumber("001712592");

		// Right input --> depend on input
//		ValidationManager manager = ValidationManager.createValidatorStrategyByName(ValidatorStrategy.NORMAL_VALIDATOR.name());
		// Wrong input --> normal
		ValidationManager manager = ValidationManager.createValidatorStrategyByName("abcde");

//        if (manager.validate(person)) {
//            person.toString();
//        }
//        else {
//            System.out.println(manager.getMessages());
//        }

		System.out.println("Using validation strategy: " + manager.getValidationStrategyName());
		System.out.println("Description: " + manager.getValidationStrategyDescription());
		List<String> personValidationErrors = manager.validate(person);
		if (personValidationErrors.isEmpty()) {
			System.out.println("person = " + person);
		} else {
			System.out.println("validationErrors = \n" + personValidationErrors);
		}

		System.out.println();
		System.out.println();
		manager.updateStrategy(ValidatorStrategy.NORMAL_VALIDATOR.name());
		System.out.println("Using validation strategy: " + manager.getValidationStrategyName());
		System.out.println("Description: " + manager.getValidationStrategyDescription());
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
			System.out.println("validationErrors = \n" + validationErrors);
		}

	}
}
