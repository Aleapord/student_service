package com.ncu.zsq.student_service.Pojo;

public class Course {
    private int id;
    private String name;
    private int teather_id;
    private String period;
    private int credit;

    public Course() {

    }

    public int getTeather_id() {
        return teather_id;
    }

    public void setTeather_id(int teather_id) {
        this.teather_id = teather_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
