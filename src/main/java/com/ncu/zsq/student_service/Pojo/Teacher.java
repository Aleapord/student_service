package com.ncu.zsq.student_service.Pojo;

public class Teacher extends Character{
    private String sex;

    public Teacher() {

    }

    public Teacher(int id, String name,String password, String sex) {
        super(id, name, password);
        this.sex = sex;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
