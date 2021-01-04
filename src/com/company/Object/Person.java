package com.company.Object;
import com.company.Annotation.*;

public class Person {
    @NotNull
    private int ID;

    @NotNull
    @Larger(value = 18)
    @Less(value = 50)
    private int age;

    @NotBlank
    private String name;

    @Email(value = "[a-zA-Z0-9._%+-]*}")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
