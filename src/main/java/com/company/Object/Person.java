package com.company.Object;
import com.company.Annotation.*;
import com.company.CustomAnnotation.NotNegative;
import com.company.validationStrategy.FailFastValidationStrategy;
import com.company.validationStrategy.NormalValidationStrategy;

//@ValidationStrategy(FailFastValidationStrategy.class)
public class Person {
    @NotNull
    @NotNegative(validatedBy = "com.company.CustomFunction.NotNegative")
    @Larger(value = 1000, message = "ID must be larger than 1000")
    private int ID;

    @NotBlank(message = "This is a required field")
    @Size(min = 2, max = 10)
    private String name;

    @Size(min = 18, max = 50)
    private int age;

    @NotBlank(message = "This is a required field")
    @Email
    private String email;

    @NotBlank(message = "This is a required field")
    @Length(value = 9, message = "Value's length must be 9")
    @Digit
    private String IDSerialNumber;

    @CheckDate(dateFormat = "dd/MM/yyyy")
    private String dateOfBirth;

    @NotBlank(message = "This is a required field")
    @Password(min = 4, max = 10, isContainLetter = true, message = "Value's length must be between 4 and 10 characters and contains some letters")
    private String password;


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
