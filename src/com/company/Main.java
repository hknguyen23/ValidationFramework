package com.company;

public class Main {

    public static void main(String[] args) {
        Person a = new Person();

        a.setID(100);
        a.setAge(10);
        System.out.println(a.getID() + " " + a.getAge());

        ValidateManager manager = new ValidateManager();
        manager.validate(a);

    }
}
