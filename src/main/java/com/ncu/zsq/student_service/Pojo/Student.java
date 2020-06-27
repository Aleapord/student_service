package com.ncu.zsq.student_service.Pojo;

public class Student extends Character {
    private int class_id;
    private int total_creadits;

    public Student() {
    }

    public Student(int id, String name, String password, int class_id, int total_creadits) {
        super(id, name, password);
            this.class_id = class_id;
        this.total_creadits = total_creadits;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTotal_creadits() {
        return total_creadits;
    }

    public void setTotal_creadits(int total_creadits) {
        this.total_creadits = total_creadits;
    }
}
