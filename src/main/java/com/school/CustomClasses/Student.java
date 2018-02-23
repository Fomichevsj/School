package com.school.CustomClasses;

public class Student {
    public String Id;
    public String LastName;
    public String FirstName;
    public String MiddleName;
    public String BirthDate;

    public Student(String lastName,
                   String firstName,
                   String middleName,
                   String birthDate) {
        this.LastName = lastName;
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.BirthDate = birthDate;
    }

    public void print() {
        System.out.println(LastName + "     " + FirstName + "     " + MiddleName + "     " + BirthDate);
    }
}
