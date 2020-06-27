package com.ncu.zsq.student_service.Pojo;

public class StudentDao {
    private Student student;
    private Classes classes;


    public StudentDao() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
