package com.company.Object;
import com.company.Annotation.Equal;
import com.company.Annotation.Larger;
import com.company.Annotation.Less;
import com.company.Annotation.NotNull;

public class Person {
    @NotNull
    private int ID;

    @NotNull
    @Larger(value = 18)
    @Less(value = 50)
    private int age;

    @NotNull
    private String name;

    public float getID() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
