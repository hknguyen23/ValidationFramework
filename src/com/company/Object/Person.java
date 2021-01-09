package com.company.Object;
import com.company.Annotation.*;
import com.company.CustomAnnotation.NotNegative;
import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;

//@ValidationStrategy(FailFastValidationStrategy.class)
public class Person {
    @NotNegative(validatedBy = "com.company.CustomFunction.NotNegative")
    @Larger(value = 200)
    private int ID;

    @NotNull
    @Larger(value = 18)
    @Less(value = 50)
    private int age;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Email
    private String email;

    @Length(value = 9)
    @NotBlank
    @Digit
    private String IDSerialNumber;

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

    public String getIDSerialNumber() {
        return IDSerialNumber;
    }

    public void setIDSerialNumber(String IDSerialNumber) {
        this.IDSerialNumber = IDSerialNumber;
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
