package com.company;

import com.company.FunctionManager.ValidateManager;
import com.company.Object.Person;

public class Main {

    public static void main(String[] args) {
        Person a = new Person();

        a.setID(101);
        a.setAge(31);
        //a.setName(" ");
        a.setEmail("hophanminhgmail@gmail.com");

        ValidateManager manager = new ValidateManager();
        if (manager.validate(a)) {
            a.toString();
        }
        else {
            System.out.println(manager.getMessages());
        }
    }
}
