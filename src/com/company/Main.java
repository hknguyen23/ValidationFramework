package com.company;

public class Main {

    public static void main(String[] args) {
        Person a = new Person();

        a.setID(100);
        a.setAge(10);
        a.setName("Minh");

        ValidateManager manager = new ValidateManager();
        if (manager.validate(a)) {
            a.toString();
        }
        else {
            System.out.println(manager.getMessages());
        }
    }
}
