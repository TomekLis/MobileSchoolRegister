package com.example.tomasz.mobileschoolregister.model;

/**
 * Created by Tomasz on 23-Dec-17.
 */

class Student extends User{

    private int age;
    private int studentsGroupId;
    private StudentGroup studentGroup;

    public Student(String id, String userName, String fullName, String firstName, String lastName, String email, String phoneNumber) {
        super(id, userName, fullName, firstName, lastName, email, phoneNumber);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentsGroupId() {
        return studentsGroupId;
    }

    public void setStudentsGroupId(int studentsGroupId) {
        this.studentsGroupId = studentsGroupId;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
