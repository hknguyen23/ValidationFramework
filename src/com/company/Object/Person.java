package com.company.Object;
import com.company.Annotation.*;
import com.company.CustomAnnotation.NotNegative;

public class Person {
    @NotNegative(validatedBy = "com.company.CustomFunction.NotNegative")
    @Larger(value = 200)
    private int ID;

    @NotNull
    @Size(min = 18, max = 50)
    private int age;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 10, message = "SIZE")
    private String name;

    @Email
    private String email;

    @Length(value = 9, message = "LENGTH")
    @NotBlank
    @Digit
    private String IDSerialNumber;

    @Password(min = 4, max = 10, isContainLetter = true, message = "PASSWORD")
    private String password;

    @CheckDate(dateFormat = "dd/MM/yyyy")
    private String dateOfBirth;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
