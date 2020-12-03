package com.company;
import com.company.Annotation.Equal;
import com.company.Annotation.Larger;

public class Person {
    @Larger(value = 50)
    private int ID;

    @Equal(value = 18)
    private int age;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
